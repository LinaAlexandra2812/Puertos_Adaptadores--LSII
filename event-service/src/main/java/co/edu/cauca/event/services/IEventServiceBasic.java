/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.cauca.event.services;

import co.edu.cauca.event.domain.Event;
import java.util.List;

/**
 *
 * @author Ashlee Campaz
 */
public interface IEventServiceBasic {
    
    public List<Event> findAll();
    public Event findById(Long id);
    public Event create(Event event);
    public Event update(Long id, Event event);
    public void deleteById(Long id);
}
