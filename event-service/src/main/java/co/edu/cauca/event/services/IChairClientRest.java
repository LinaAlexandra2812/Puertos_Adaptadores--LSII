/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.cauca.event.services;

import co.edu.cauca.event.domain.Chair;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Ashlee Campaz
 */

@FeignClient(name = "chair-service", url = "localhost:8001")
public interface IChairClientRest {
    
    @GetMapping("/Chair/")
	public List<Chair> list();

	@GetMapping("/Chair/{id}")
	public Chair detail(@PathVariable Long id);

	@PostMapping("/Chair")
	public Chair create(@RequestBody Chair chair);

	@PutMapping("/Chair/{id}")
	public Chair update(@RequestBody Chair chair, @PathVariable Long id);

	@DeleteMapping("/eliminar/{id}")
	public void delete(@PathVariable Long id);
}
