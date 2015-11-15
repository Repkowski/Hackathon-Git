/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listcounting;

import java.util.ArrayList;

/**
 *
 * @author Matt
 */
public class ArrayListIterate {
      public ArrayList<Employer> ogEmployer; //contain the original arraylist for the employer attributes
      public ArrayList<String> employUniWord;
      public ArrayList<Integer> employWordCount;
      public ArrayList<Student> ogStudent; //contain original arraylist for student attributes
      public ArrayList<String> studUniWord;
      public ArrayList<Integer> studWordCount;
      
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
           if (employUniWord.contains(attribute) == false){
               employUniWord.add(attribute.toLowerCase());
               firstArPos = employUniWord.indexOf(attribute);
               tempCount = 1;
               employWordCount.add(firstArPos, tempCount);
           }
           
           else {
               firstArPos = employUniWord.indexOf(attribute);
               tempCount = employWordCount.get(firstArPos) + 1;
               employWordCount.add(firstArPos, tempCount);
           }
       }
       
       public void checkStudentAttribute (String attribute){
           int tempCount = 0;
           int firstArPos = 0;
           if(studUniWord.contains(attribute)== false){
               studUniWord.add(attribute.toLowerCase());
               firstArPos = studUniWord.indexOf(attribute);
               tempCount = 1;
               studWordCount.add(firstArPos, tempCount);
           }
           
           else{
               firstArPos = studUniWord.indexOf(attribute);
               tempCount = studWordCount.get(firstArPos) + 1;
               studWordCount.add(firstArPos, tempCount);
           }
       }
       
}
