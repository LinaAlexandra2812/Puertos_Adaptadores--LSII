/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.cauca.event.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ashlee Vanessa Campaz
 */
@Entity
@Table (name = "event")
public class Event implements Serializable {
    private String name;
    
    
    private Long chair_id;
    
    private List<Long> comiteDeprograma;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getChair_id() {
        return chair_id;
    }

    
    public List<Long> getComiteDeprograma() {
        return comiteDeprograma;
    }
    
    
    
    
}
