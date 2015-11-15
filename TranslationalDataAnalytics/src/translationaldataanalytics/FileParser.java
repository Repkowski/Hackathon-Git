/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package translationaldataanalytics;

import java.util.ArrayList;
import java.util.Iterator;
//import java.io.BufferedReader;
import java.io.*;
import java.util.*;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
import java.util.ArrayList;
import jxl.*;


/**
 *
 * @author Jason
 */
public class FileParser {
    private ArrayList<Employer> employerList;
    private ArrayList<Student> studentList;
    
    public void parseFiles(String employerFile, String studentFile) {
        ArrayList<Employer> employers = new ArrayList<>();
        ArrayList<String[]> employerText;
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<String[]> studentText;
        
        
        employerText = parse(employerFile, 5);
        studentText = parse(studentFile, 15);
        
        Iterator ei = employerText.iterator();
        while(ei.hasNext()) {
            //process the next employer
            String[] emp = (String[])ei.next();
            Employer employerObj;
            employerObj = new Employer(emp[0],emp[1],emp[2],emp[3],emp[4]);
            employers.add(employerObj);
        }
        employerList = employers;
        
        Iterator si = studentText.iterator();
        while(si.hasNext()) {
            //process the next Student
            String[] stu = (String[])si.next();
            Student studentObj;
            studentObj = new Student(stu[0],stu[1],stu[2],stu[3],stu[4],stu[5],stu[6],stu[7],stu[8],stu[9],stu[10],stu[11],stu[12],stu[13],stu[14]);
            students.add(studentObj);
        }
        studentList = students;
    }
    
    private ArrayList<String[]> parse(String csv, int fields) {
        BufferedReader br = null;
        String line = "";
        String split = ",";
        ArrayList<String[]> entities = new ArrayList<String[]>(); 
        
        String[] filepath = csv.split(".");
        String filetype = csv.substring(csv.lastIndexOf(".") + 1, (csv.length()));
        //String filetype = filepath[filepath.length - 1];
        if("xls".equals(filetype) || "xlsx".equals(filetype)) {
            csv = convertXLS(csv);
        }
        
        try {
            br = new BufferedReader(new FileReader(csv));
            while((line = br.readLine()) != null) {
                line = "\"" + line + "\"";
                String[] entity = line.split(split);
                
                String[] newEntity = new String[fields];
                
                for(int i = 0; i < entity.length; i++) {
                    newEntity[i] = entity[i];
                }
                //Pad the entity item so it has the appropriate number of fields in it
                //Will need to do this if the last columns do not have text in them
                if(entity.length < fields) {
                    int extra = fields - entity.length;
                    for(int i = entity.length; i < entity.length + extra; i++) {
                        newEntity[i] = "";
                    }
                }
                entities.add(newEntity);
            }
        } catch (FileNotFoundException e) {
            System.err.print(e.getMessage());
        }
          catch (IOException e) {
              System.err.printf(e.getMessage());
          }
        finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {}
            }
            return entities;
        }
        
    }
    
    //Function taken from 
    //http://www.java-tips.org/other-api-tips-100035/93-jexcel/414-converting-excel-documents-to-csv-files.html
    private String convertXLS(String file) {
        try{
            String[] filepath = file.split("\\\\"); //Need to do four \ since regex uses \ as an escape character
            String filename = filepath[filepath.length - 1].substring(0, filepath[filepath.length - 1].lastIndexOf("."));
            String CSVname = filename + ".csv";
            File f = new File(CSVname);
            
            OutputStream os = (OutputStream)new FileOutputStream(f);
            String encoding = "UTF8";
            OutputStreamWriter osw = new OutputStreamWriter(os, encoding);
            BufferedWriter bw = new BufferedWriter(osw);
            
            WorkbookSettings ws = new WorkbookSettings();
            ws.setLocale(new Locale("en","EN"));
            Workbook w = Workbook.getWorkbook(new File(file),ws);
            
            Sheet s = w.getSheet(0);
            Cell[] row = null;
            
            for (int i=0; i < s.getRows(); i++) {
                row = s.getRow(i);
                if (row.length > 0) {
                    bw.write(row[0].getContents().replaceAll("(\\r|\\n|\\r\\n|,)+", " ").replace("\"", "\\\""));
                    for(int j = 1; j < row.length; j++) {
                       bw.write(',');
                        bw.write(row[j].getContents().replaceAll("(\\r|\\n|\\r\\n|,)+", " ").replace("\"", "\\\""));
                    }
                }
                bw.newLine();
            }
            bw.flush();
            bw.close();
            return CSVname;
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.toString());
        }
          catch (IOException e) {
              System.err.println(e.toString());
          }
          catch (Exception e) {
              System.err.println(e.toString());
          }
        return null;
    }
    
    public ArrayList<Employer> getEmployers() {
        return employerList;
    }
    
    public ArrayList<Student> getStudents() {
        return studentList;
    }
}
