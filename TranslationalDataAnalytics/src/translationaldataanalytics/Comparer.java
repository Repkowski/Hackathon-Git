/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package translationaldataanalytics;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Jason
 */
public class Comparer {
    private ArrayList<String> wordsMatched;
    private ArrayList<Integer> countMatched;
    private ArrayList<String> majorsSought;
    private int student_score;
    private int employer_score;
    
    public void compareWords(ArrayList<String> employerWords,ArrayList<Integer> employerCount,ArrayList<String> studentWords,ArrayList<Integer> studentCount) {
        
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
    
    public void compareMajors(ArrayList<Employer> employers) {
        String file = "C:\\Users\\Jason\\Dropbox\\Fall2015-Spring2016\\OHI_O2015\\Hackathon-Git\\TranslationalDataAnalytics\\src\\translationaldataanalytics\\Target_Majors.txt";
        String[] majorArray = new String[760];
        ArrayList<String> employerMajors = new ArrayList<>();
        
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String currentLine;
            int c = 0;
            
            while((currentLine = br.readLine()) != null) {
                majorArray[c] = currentLine.toLowerCase();
                c++;
            }
            br.close();
            
            Iterator ewi = employers.iterator();
            while(ewi.hasNext()) {
                Employer currentEmployer = (Employer) ewi.next();
                String majors = currentEmployer.getMajor().toLowerCase();
                for(int i = 0; i < majorArray.length; i++) {
                    
                    if(majors.contains(majorArray[i].toLowerCase())) {
                          employerMajors.add(majorArray[i]);
                    }                
                }
            }    
        } catch (Exception e) {
            e.printStackTrace();
        }
         majorsSought = employerMajors;
    }
    
    public void scoreResumes(ArrayList<String> employerWords, ArrayList<String> studentWords)
    {
       int student_positive_score = 0;
       int student_negative_score = 0;
       int employer_negative_score = 0;
       int employer_positive_score = 0;
       int wordCount = 0;
       
       String[] negative_word_array = new String[200];
       String[] positive_word_array = new String[200];
       String current_positive_array_word;
       String current_negative_array_word;
       String current_employer_word;
       String current_student_word;
       
       FileReader inputFile1;
       FileReader inputFile2;
       
       BufferedReader reader1;
       BufferedReader reader2;
       
       Iterator si = studentWords.iterator();
       Iterator ew = employerWords.iterator();
       
       int studentCurrentCount = 0;
       int employerCurrentCount = 0;
       ArrayList<String> matchedWords = new ArrayList<String>();
       ArrayList<Integer> matchedWordCount = new ArrayList<Integer>();
       
       String positiveFile = "C:\\Users\\Jason\\Documents\\GitHub\\Hackathon-Git\\Hackathon-Git\\TranslationalDataAnalytics\\src\\translationaldataanalytics\\Target_Negative_Words.txt";
       String negativeFile = "C:\\Users\\Jason\\Documents\\GitHub\\Hackathon-Git\\Hackathon-Git\\TranslationalDataAnalytics\\src\\translationaldataanalytics\\Target_Positive_Words.txt";
       
       //Puts all positive words into an array
       try{
            
               inputFile1 = new FileReader(positiveFile);
               reader1 = new BufferedReader(inputFile1);
               String currentLine1;
            
           while((currentLine1 = reader1.readLine()) != null)
           {
                String currentWord = "";
                
                for(int i = 0; i < currentLine1.length(); i++)
                {
                    if(currentLine1.charAt(i) == ',' || currentLine1.charAt(i) == '\n')
                    {
                        positive_word_array[wordCount] = currentWord;
                        wordCount++;
                        currentWord = "";
                    }
                    else
                    {
                        currentWord += currentLine1.charAt(i);
                    }  
                }
            }
            reader1.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
       
        try{
            
                inputFile2 = new FileReader(negativeFile);
                reader2 = new BufferedReader(inputFile2);
                String currentLine2;
            
            while((currentLine2 = reader2.readLine()) != null)
            {
                String currentWord = "";
                
                for(int i = 0; i < currentLine2.length(); i++)
                {
                    if(currentLine2.charAt(i) == ',' || currentLine2.charAt(i) == '\n')
                    {
                        negative_word_array[wordCount] = currentWord;
                        wordCount++;
                        currentWord = "";
                    }
                    else
                    {
                        currentWord += currentLine2.charAt(i);
                    }  
                }
            }
            reader2.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
       
       while(si.hasNext()) 
       {
           current_student_word = studentWords.get(wordCount);
           current_positive_array_word = positive_word_array[wordCount];
           current_negative_array_word = negative_word_array[wordCount];
           
           if(current_student_word.equals(current_positive_array_word))
           {
               student_positive_score++;
           }
           else if(current_student_word.equals(current_negative_array_word))
           {
               student_negative_score++;   
           }
           wordCount++;  
       }
       
       wordCount = 0;
       
       while(ew.hasNext())
       {
           current_employer_word = employerWords.get(wordCount);
           current_positive_array_word = positive_word_array[wordCount];
           current_negative_array_word = negative_word_array[wordCount];
           
           if(current_employer_word.equals(current_positive_array_word))
           {
               employer_positive_score++;
           }
           else if(current_employer_word.equals(current_negative_array_word))
           {
               employer_negative_score++;
           }
           wordCount++;
       }
       
       student_score = student_positive_score - student_negative_score;
       employer_score = employer_positive_score - employer_negative_score;
    }
    
    public ArrayList<String> getMatchedWords() {
        return wordsMatched;
    }
    
    public ArrayList<Integer> getMatchedWordCount() {
        return countMatched;
    }
    
    public ArrayList<String> getMatchedMajors() {
        return majorsSought;
    }
    
    public int getStudentScore()
    {
        return student_score;
    }
    
    public int getEmployerScore()
    {
        return employer_score;
    }
    
}
