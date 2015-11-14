/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package translationaldataanalytics;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Jason
 */
public class FileParser {
    public void parseFiles(String employerFile, String studentFile) {
        ReadCSV reader = new ReadCSV();
        ArrayList<Employer> employers = new ArrayList<>();
        ArrayList<String[]> employerText;
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<String[]> studentText;
        
        
        employerText = reader.parse(employerFile);
        studentText = reader.parse(studentFile);
        
        Iterator ei = employerText.iterator();
        while(ei.hasNext()) {
            //process the next employer
            String[] emp = (String[])ei.next();
            Employer employerObj;
            employerObj = new Employer(emp[0],emp[1],emp[2],emp[3],emp[4]);
            employers.add(employerObj);
        }
        
        Iterator si = studentText.iterator();
        while(si.hasNext()) {
            //process the next Student
            String[] stu = (String[])si.next();
            Student studentObj;
            studentObj = new Student(stu[0],);
        }
    }
}
