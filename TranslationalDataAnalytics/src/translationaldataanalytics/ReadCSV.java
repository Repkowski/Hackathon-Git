/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package translationaldataanalytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jason
 */
public class ReadCSV {
    public ArrayList<String[]> parse(String csv) {
        BufferedReader br = null;
        String line = "";
        String split = ",";
        ArrayList<String[]> entities = new ArrayList<String[]>();        
        try {
            br = new BufferedReader(new FileReader(csv));
            while((line = br.readLine()) != null) {
                String[] entity = line.split(split);
                entities.add(entity);
            }
        } catch (FileNotFoundException e) {}
          catch (IOException e) {}
        finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {}
            }
            return entities;
        }
        
    }
}
