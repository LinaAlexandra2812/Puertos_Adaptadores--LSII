/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.cauca.event.services;

import co.edu.cauca.event.domain.Chair;
import co.edu.cauca.event.domain.Researcher;
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
@FeignClient(name = "researcher-service", url = "localhost:8002")
public interface IResearcherClientRest {
    
    @GetMapping("/Researcher/")
	public List<Chair> list();

	@GetMapping("/Researcher/{id}")
	public Researcher detail(@PathVariable Long id);

	@PostMapping("/Researcher")
	public Researcher create(@RequestBody Researcher researcher);

	@PutMapping("/Researcher/{id}")
	public Researcher update(@RequestBody Researcher researcher, @PathVariable Long id);

	@DeleteMapping("/eliminar/{id}")
	public void delete(@PathVariable Long id);
}
