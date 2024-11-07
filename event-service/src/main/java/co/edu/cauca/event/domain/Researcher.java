/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.cauca.event.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



/**
 *
 * @author Ashlee Campaz
 */
//@Entity
//@Table (name = "Researcher")
public class Researcher {
    
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long researcher_id; 
    
    private String name;
    
    private String lastName;
    
    private String email;
    
    private String researchField;
    
    public Long getResearcher_id() {
        return researcher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResearchField() {
        return researchField;
    }

    public void setResearchField(String researchField) {
        this.researchField = researchField;
    }

    public void setResearcher_id(Long Researcher_id) {
        this.researcher_id = Researcher_id;
    }
    
    
}
