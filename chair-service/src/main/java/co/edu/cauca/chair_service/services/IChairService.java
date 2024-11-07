/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.cauca.chair_service.services;

import domain.model.Chair;
import java.util.List;

/**
 *
 * @author Ashlee Campaz
 */
public interface IChairService {
    
    public List<Chair> findAll();
    public Chair findById(Long id);
    public Chair create(Chair chair);
    public Chair update(Long id, Chair chair);
    public void deleteById(Long id);
}
