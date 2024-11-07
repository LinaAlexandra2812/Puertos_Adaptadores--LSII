/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.cauca.event.services;

import co.edu.cauca.event.access.IEventRepository;
import co.edu.cauca.event.domain.Event;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ashlee Vanessa Campaz
 */
@Component
public class EventService implements IEventServiceBasic{
    @Autowired
    IEventRepository eventAcces;

    @Override
    @Transactional
    public List<Event> findAll() {
        return (List<Event>) eventAcces.findAll(); 
    }

    @Override
    @Transactional
    public Event findById(Long id) {
       Event e = eventAcces.findById(id).orElse(null);
       return e; 
    }

    @Override
    @Transactional
    public Event create(Event event) {
        return eventAcces.save(event); 
    }

    @Override
    @Transactional
    public Event update(Long id, Event event) {
       Event e = findById(id);
        e.setName(event.getName());
        return eventAcces.save(e);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        eventAcces.deleteById(id);
    }
    
}
