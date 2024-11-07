/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.cauca.event.services;

import co.edu.cauca.event.access.IEventRepository;
import co.edu.cauca.event.domain.Chair;
import co.edu.cauca.event.domain.Event;
import co.edu.cauca.event.domain.Researcher;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ashlee Campaz
 */
@Service("serviceFeign")
public class EventServiceFeign implements IEventFeignService {
    @Autowired
    IEventRepository eventAcces;
    
    @Autowired
    private IChairClientRest chairClient;
    
    @Autowired
    private IResearcherClientRest researcherClient;
    

    @Override
    @Transactional
    public List<Researcher> findAllResearcher(Long id) {
        Event e = eventAcces.findById(id).orElse(null);
        List<Researcher> lista = new ArrayList(); 
        for(Long r: e.getComiteDeprograma()){
            lista.add(researcherClient.detail(r));
            System.out.println(researcherClient.detail(r).getName());
        } 
        return lista;
    }

    @Override
    @Transactional
    public Chair findChair(Long id) {
        Event e = eventAcces.findById(id).orElse(null);
        return chairClient.detail(e.getChair_id());
    }
    
}
