/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan
 */
public class WordReaderRun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        WordReader reader = new WordReader();
        
        String[] test;
        
        test = reader.get_useful_courses();        
        for(int i = 0; i < test.length; i++)
        {
            System.out.print(test[i] + ", ");
        }
    }
    
}
