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
public class Comparer {
    private ArrayList<String> wordsMatched;
    private ArrayList<Integer> countMatched;
    public void compareWords(ArrayList<Employer> employers, ArrayList<Student> students, ArrayList<String> employerWords,ArrayList<Integer> employerCount,ArrayList<String> studentWords,ArrayList<Integer> studentCount) {
        
        Iterator si = studentWords.iterator();
        Iterator sci = studentCount.iterator();
        
       
        int studentCurrentCount = 0;
        int employerCurrentCount = 0;
        ArrayList<String> matchedWords = new ArrayList<String>();
        ArrayList<Integer> matchedWordCount = new ArrayList<Integer>();
        
        
        while(si.hasNext()) {
            studentCurrentCount = (Integer)sci.next();
            Iterator eci = employerCount.iterator();
            Iterator ei = employerWords.iterator();
            String studentCurrentWord = (String)si.next();
            while(ei.hasNext()) {
                employerCurrentCount = (Integer)eci.next();
                String word = (String)ei.next();
                if(studentCurrentWord.equals(word)) {
                    matchedWords.add(word);
                    matchedWordCount.add(studentCurrentCount - employerCurrentCount);
                }
            }
        }
        wordsMatched = matchedWords;
        countMatched = matchedWordCount;
    }
    
    public ArrayList<String> getMatchedWords() {
        return wordsMatched;
    }
    
    public ArrayList<Integer> getMatchedWordCount() {
        return countMatched;
    }
}
