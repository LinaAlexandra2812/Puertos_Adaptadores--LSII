/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.cauca.event.domain;

/**import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;*/


/**
 *
 * @author Ashlee Campaz
 */
//@Entity
//@Table (name = "Chair")
public class Chair {
    private String name;
    
    private String lastName;
    
    private String email;

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chair_id;        
    
    public Long getId() {
        return chair_id;
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

    public void setChair_id(Long chair_id) {
        this.chair_id = chair_id;
    }
    
    
    
}
