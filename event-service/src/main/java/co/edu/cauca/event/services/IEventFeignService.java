/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.cauca.event.services;
import co.edu.cauca.event.domain.Chair;
import co.edu.cauca.event.domain.Researcher;
import java.util.List;

/**
 *
 * @author Ashlee Vanessa Campaz
 */
public interface IEventFeignService {
    
    public List<Researcher> findAllResearcher(Long id); 
    public Chair findChair(Long id); 
}
