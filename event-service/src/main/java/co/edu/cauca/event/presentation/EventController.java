/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.cauca.event.presentation;

import co.edu.cauca.event.domain.Chair;
import co.edu.cauca.event.domain.Event;
import co.edu.cauca.event.domain.Researcher;
import co.edu.cauca.event.services.IEventFeignService;
import co.edu.cauca.event.services.IEventServiceBasic;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ashlee Vanessa Campaz
 */
@RestController
@Component
@RequestMapping("/event")

public class EventController {
    @Autowired
    IEventServiceBasic eventService;
    @Autowired
    IEventFeignService eventServiceFeign;
    
    @RequestMapping(method = RequestMethod.GET, produces =
    "application/json")
     @ResponseBody
     public List<Event> findAll() {
     return eventService.findAll();
     }
     @RequestMapping(method = RequestMethod.POST, produces =
    "application/json")
     @ResponseBody
     public Event create(@RequestBody Event event) {
     return eventService.create(event);
     }
     /* Get a Event by ID */
     @GetMapping("/{id}")
     public Event getEventById(@PathVariable Long id) {
     return eventService.findById(id);
    }
     
    @GetMapping("/{id}/Researchers")
     public List<Researcher> findAllResearchers(@PathVariable Long id){
        return eventServiceFeign.findAllResearcher(id);
     }
     
     @GetMapping("/{id}/Chair")
     public Chair findChair(@PathVariable Long id){
        return eventServiceFeign.findChair(id);
     }
}
