/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package translationaldataanalytics;

import java.util.ArrayList;

/**
 *
 * @author Matt
 */
public class ArrayListIterate {
      public ArrayList<Employer> ogEmployer = new ArrayList<Employer>(); //contain the original arraylist for the employer attributes
      public ArrayList<String> employUniWord = new ArrayList<String>();
      public ArrayList<Integer> employWordCount = new ArrayList<Integer>();
      public ArrayList<Student> ogStudent = new ArrayList<Student>(); //contain original arraylist for student attributes
      public ArrayList<String> studUniWord = new ArrayList<String>();
      public ArrayList<Integer> studWordCount = new ArrayList<Integer>();
      
      public  ArrayListIterate(ArrayList<Student> aStudent,
              ArrayList<Employer> aEmployer){
       this.ogStudent = aStudent;
       this.ogEmployer = aEmployer;    
       }
       
       public void uniqueEmployer(){
           String tempTitle = " ";
           String tempDesc = " ";
           String tempType = " ";
           String tempMajor = " ";
           String tempSkills = " ";
           
           Employer tempEmploy;
           
           for (int i = 0; i < ogEmployer.size(); i++){
                tempEmploy = ogEmployer.get(i);
                
                tempTitle = tempEmploy.getTitle();
                tempDesc = tempEmploy.getDescription();
                tempType = tempEmploy.getType();
                tempMajor = tempEmploy.getMajor();
                tempSkills = tempEmploy.getSkills();

                checkEmployerAttribute(tempTitle);
                checkEmployerAttribute(tempDesc);
                checkEmployerAttribute(tempType);
                checkEmployerAttribute(tempMajor);
                checkEmployerAttribute(tempSkills);
       }
   }
       public void uniqueStudent(){
          String major = " ";
          String minor = " ";
          String graduation = " ";
          String priorDegrees = " ";
          String title1 = " ";
          String experience1 = " ";
          String title2 = " ";
          String experience2 = " ";
          String title3 = " ";
          String experience3 = " ";
          String computerSkills = " ";
          String languageSkills = " ";
          String personalSkills = " ";
          String courses = " ";
          String projects = " ";
          
          Student tempStudent;
          
          for (int j = 0; j < ogStudent.size(); j++  ){
              tempStudent = ogStudent.get(j);
              
              major = tempStudent.getMajor();
              minor = tempStudent.getMinor();
              graduation = tempStudent.getGraduation();
              priorDegrees = tempStudent.getPriorDegrees();
              title1 = tempStudent.getJobTitle1();
              experience1 = tempStudent.getJobExperience1();
              title2 = tempStudent.getJobTitle2();
              experience2 = tempStudent.getJobExperience2();
              title3 = tempStudent.getJobTitle3();
              experience3 = tempStudent.getJobExperience3();
              computerSkills = tempStudent.getComputerSkills();
              languageSkills = tempStudent.getLanguageSkills();
              personalSkills = tempStudent.getPersonalSkills();
              courses = tempStudent.getCourses();
              projects = tempStudent.getProjects();
              
              checkStudentAttribute(major);
              checkStudentAttribute(minor);
              checkStudentAttribute(graduation);
              checkStudentAttribute(priorDegrees);
              checkStudentAttribute(title1);
              checkStudentAttribute(experience1);
              checkStudentAttribute(title2);
              checkStudentAttribute(experience2);
              checkStudentAttribute(title3);
              checkStudentAttribute(experience3);
              checkStudentAttribute(computerSkills);
              checkStudentAttribute(languageSkills);
              checkStudentAttribute(personalSkills);
              checkStudentAttribute(courses);
              checkStudentAttribute(projects);
          }
              
           
           
       }
       
       public void checkEmployerAttribute (String attribute){
           int tempCount = 0;
           int firstArPos = 0;
           String[] attributeWords = attribute.split("[\\W]");
           for(int i = 0; i < attributeWords.length; i++) {
               if (employUniWord.contains(attributeWords[i].toLowerCase()) == false){
                   employUniWord.add(attributeWords[i].toLowerCase());
                   //firstArPos = employUniWord.indexOf(attribute);
                   tempCount = 1;
                   employWordCount.add(tempCount);
               }
               else {
                   firstArPos = employUniWord.indexOf(attributeWords[i].toLowerCase());
                   tempCount= employWordCount.get(firstArPos) + 1;
                   //employWordCount.add(firstArPos, tempCount);
                   employWordCount.set(firstArPos, tempCount);
               } 
           }
       }
       
       public void checkStudentAttribute (String attribute){
           int tempCount = 0;
           int firstArPos = 0;
           String[] attributeWords = attribute.split("[\\W]");
           for(int i = 0; i < attributeWords.length; i++) {
                if(studUniWord.contains(attributeWords[i].toLowerCase())== false){
                    studUniWord.add(attributeWords[i].toLowerCase());
                    //firstArPos = studUniWord.indexOf(attributeWords[i]);
                    tempCount = 1;
                    studWordCount.add(tempCount);
                }

                else{
                    firstArPos = studUniWord.indexOf(attributeWords[i].toLowerCase());
                    tempCount = studWordCount.get(firstArPos) + 1;
                    studWordCount.set(firstArPos, tempCount);
                }
           }
       }
       
}
