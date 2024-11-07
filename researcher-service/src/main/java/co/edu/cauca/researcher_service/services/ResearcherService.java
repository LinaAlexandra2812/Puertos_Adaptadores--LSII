/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.cauca.researcher_service.services;

import co.edu.cauca.researcher_service.access.IResearcherRepository;
import co.edu.cauca.researcher_service.domain.Researcher;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Ashlee Campaz
 */

@Component
public class ResearcherService implements IResearcherService{
    
    @Autowired
    IResearcherRepository researcherAccess; 
    
    @Override
    @Transactional
    public List<Researcher> findAll() {
        return (List<Researcher>) researcherAccess.findAll(); 
    }

    @Override
    @Transactional
    public Researcher findById(Long id) {
        Researcher r = researcherAccess.findById(id).orElse(null);
       return r;
    }

    @Override
    @Transactional
    public Researcher create(Researcher researcher) {
        return researcherAccess.save(researcher); 
    }

    @Override
    @Transactional
    public Researcher update(Long id, Researcher researcher) {
        Researcher r = findById(id);
        r.setName(researcher.getName());
        return researcherAccess.save(r);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        researcherAccess.deleteById(id);
    }
    
}
