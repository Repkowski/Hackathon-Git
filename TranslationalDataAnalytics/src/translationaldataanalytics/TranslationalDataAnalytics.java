/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package translationaldataanalytics;

import java.util.ArrayList;

/**
 *
 * @author Jason
 */
public class TranslationalDataAnalytics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FileParser parser = new FileParser();
        parser.parseFiles("Downloads\\TDA Jobs Data Test.xls", "Downloads\\TDA Students Test.xlxs");
        ArrayList<Employer> employers = parser.getEmployers();
        ArrayList<Student> students = parser.getStudents();
    }
    
}
