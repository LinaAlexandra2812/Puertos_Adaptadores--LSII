/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.cauca.researcher_service.services;

import co.edu.cauca.researcher_service.domain.Researcher;
import java.util.List;

/**
 *
 * @author Ashlee Campaz
 */
public interface IResearcherService {
    public List<Researcher> findAll();
    public Researcher findById(Long id);
    public Researcher create(Researcher researcher);
    public Researcher update(Long id, Researcher researcher);
    public void deleteById(Long id);
}
