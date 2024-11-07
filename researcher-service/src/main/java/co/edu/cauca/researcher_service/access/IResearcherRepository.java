/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.cauca.researcher_service.access;

import co.edu.cauca.researcher_service.domain.Researcher;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ashlee Campaz
 */
public interface IResearcherRepository extends CrudRepository <Researcher, Long>{
    
}
