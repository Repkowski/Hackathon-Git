/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package translationaldataanalytics;

/**
 * The Employer Object Class. This class will contain the
 * different fields in the CSV file.
 * @author Jason
 */
public class Employer {
    private String title;
    private String description;
    private String type;
    private String major;
    private String skills;
    
    public Employer(String title,String description,String type, String major, String skills) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.major = major;
        this.skills = skills;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public String getType() {
        return this.type;
    }
    
    public String getMajor() {
        return this.major;
    }
    
    public String getSkills() {
        return this.skills;
    }
}
