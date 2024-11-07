/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.cauca.researcher_service.presentation;

import co.edu.cauca.researcher_service.domain.Researcher;
import co.edu.cauca.researcher_service.services.IResearcherService;
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
 * @author Ashlee Campaz
 */
@RestController
@Component
@RequestMapping("/Researcher")
public class ResearcherController {
    @Autowired
    IResearcherService researcherService;
    
    @RequestMapping(method = RequestMethod.GET, produces =
    "application/json")
     @ResponseBody
     public List<Researcher> findAll() {
     return researcherService.findAll();
     }
     @RequestMapping(method = RequestMethod.POST, produces =
    "application/json")
     @ResponseBody
     public Researcher create(@RequestBody Researcher event) {
     return researcherService.create(event);
     }
     /* Get a researcher by ID */
     @GetMapping("/{id}")
     public Researcher getResearcherById(@PathVariable Long id) {
     return researcherService.findById(id);
    }
    
}
