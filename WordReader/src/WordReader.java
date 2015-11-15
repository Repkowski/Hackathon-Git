
import java.io.*;

/**
 *
 * @author Ryan
 */
public class WordReader{
    
    //Some of these files are read differently based on their format, so they are declared as seen here.
    String action_words = "Target_Action_Words.txt";
    String majors = "Target_Majors.txt";
    String positive_words = "Target_Positive_Words.txt";
    String negative_words = "Target_Negative_Words.txt";
    String useful_courses = "Useful_Courses.txt";
    
    FileReader inputFile;
    BufferedReader reader;
    
    /*
     * This method gets the action words from the text file that are used in the scoring algorithm later defined.
     * This method reads in words alphabetically and puts them in an array that will be used to find and parse words
     * in the data set.
     */
    public String[] get_action_words()
    {
        String action_word_array[] = new String[100];
        int wordCount = 0;
        
        try {
            
            inputFile = new FileReader(action_words);
            reader = new BufferedReader(inputFile);
            String currentLine;
            
            while((currentLine = reader.readLine()) != null)
            {
                String currentWord = "";
                
                for(int i = 0; i < currentLine.length(); i++)
                {
                    if(currentLine.charAt(i) == ',' || currentLine.charAt(i) == '\n')
                    {
                        action_word_array[wordCount] = currentWord;
                        wordCount++;
                        currentWord = "";
                    }
                    else
                    {
                        currentWord += currentLine.charAt(i);
                    }  
                }
            }
            reader.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return action_word_array;
    }
    
    /*
     * This method gets the targetted negative words and puts them in an array for comparison between
     * the students and full-time positions/internships.
     */
    public String[] get_target_negative_words()
    {
        String target_negative_words[] = new String[100];
        int wordCount = 0;
        
        try {
            inputFile = new FileReader(negative_words);
            reader = new BufferedReader(inputFile);
            String currentLine;
            
            while((currentLine = reader.readLine()) != null)
            {
                String currentWord = "";
                
                for(int i = 0; i < currentLine.length(); i++)
                {
                    if(currentLine.charAt(i) == ',' || currentLine.charAt(i) == '\n')
                    {
                        target_negative_words[wordCount] = currentWord;
                        wordCount++;
                        currentWord = "";
                    }
                    else
                    {
                        currentWord += currentLine.charAt(i);
                    }
                }
            }
            reader.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }     
        return target_negative_words;
    }
    
    /*
     * This method gets the targetted positive words and puts them in an array for comparison between
     * the students and full-time positions/internships.
     */
    public String[] get_target_positive_words()
    {
        String target_positive_words[] = new String[100];
        int wordCount = 0;
        
        try {
            inputFile = new FileReader(positive_words);
            reader = new BufferedReader(inputFile);
            String currentLine;
            
            while((currentLine = reader.readLine()) != null)
            {
                String currentWord = "";
                
                for(int i = 0; i < currentLine.length(); i++)
                {
                   if(currentLine.charAt(i) == ',' || currentLine.charAt(i) == '\n')
                    {
                        target_positive_words[wordCount] = currentWord;
                        wordCount++;
                        currentWord = "";
                    }
                    else
                    {
                        currentWord += currentLine.charAt(i);
                    } 
                }
            }
            reader.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return target_positive_words;
    }
    
    /*
     * This method gets the targetted majors and puts them in an array for comparison between
     * the students and full-time position/internship candidates.
     */
    public String[] get_target_major()
    {
        String listed_majors[] = new String[760];
        
        try {
           inputFile = new FileReader(majors); 
           reader = new BufferedReader(inputFile);
           String currentLine;
           int counter = 0;
           
           while((currentLine = reader.readLine()) != null)
           {
               listed_majors[counter] = currentLine;
               counter++;
           }
           reader.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return listed_majors;                
    }
    
    /*
     * This method gets the targetted useful courses and puts them in an array for comparison between
     * the students and full-time position/internship candidates.
     */
    public String[] get_useful_courses()
    {
        String useful[] = new String[54];
        
        try {
           inputFile = new FileReader(useful_courses); 
           reader = new BufferedReader(inputFile);
           String currentLine;
           int counter = 0;
           
           while((currentLine = reader.readLine()) != null)
           {
               useful[counter] = currentLine;
               counter++;
           }
           reader.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return useful;                
    }
}
