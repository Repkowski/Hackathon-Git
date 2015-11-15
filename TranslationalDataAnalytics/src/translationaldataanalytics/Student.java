/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translationaldataanalytics;
/**
 *
 * @author Jason
 */
public class Student {
    private String major;
    private String minor;
    private String graduation;
    private String priorDegrees;
    private String title1;
    private String experience1;
    private String title2;
    private String experience2;
    private String title3;
    private String experience3;
    private String computerSkills;
    private String languageSkills;
    private String personalSkills;
    private String courses;
    private String projects;
    
    public Student(String major, String minor, String grad, String prior, String title1, String exp1, String title2, String exp2, String title3, String exp3, String comp, String lang, String pers, String course, String projects) {
        this.major = major;
        this.minor = minor;
        this.graduation = grad;
        this.priorDegrees = prior;
        this.title1 = title1;
        this.experience1 = exp1;
        this.title2 = title2;
        this.experience2 = exp2;
        this.title3 = title3;
        this.experience3 = exp3;
        this.computerSkills = comp;
        this.languageSkills = lang;
        this.personalSkills = pers;
        this.courses = course;
        this.projects = projects;
    }
    
    public String getMajor() {
        return this.major;
    }
    
    public String getMinor() {
        return this.minor;
    }
    
    public String getGraduation() {
        return this.graduation;
    }
    
    public String getPriorDegrees() {
        return this.priorDegrees;
    }
    
    public String getJobTitle1() {
        return this.title1;
    }
    
    public String getJobExperience1() {
        return this.experience1;
    }
    
    public String getJobTitle2() {
        return this.title2;
    }
    
    public String getJobExperience2() {
        return this.experience2;
    }
    
    public String getJobTitle3() {
        return this.title3;
    }
    
    public String getJobExperience3() {
        return this.experience3;
    }
    
    public String getComputerSkills() {
        return this.computerSkills;
    }
    
    public String getLanguageSkills() {
        return this.languageSkills;
    }
    
    public String getPersonalSkills() {
        return this.personalSkills;
    }
}
