package plamen.projects.SuperMarkerSpringBoot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import plamen.projects.SuperMarkerSpringBoot.beans.Manufacturer;
import plamen.projects.SuperMarkerSpringBoot.repositories.ManufacturerRepository;
import plamen.projects.SuperMarkerSpringBoot.servise.ManufacturerService;

@RestController
@RequestMapping("/api/manufacturer")
public class ManufacturerController {
	private final ManufacturerService manufacturerService;

	public ManufacturerController(ManufacturerService manufacturerService) {
		super();
		this.manufacturerService = manufacturerService;
	}
	
	@GetMapping()
	public List<Manufacturer> findAll() {
		return manufacturerService.findAll();
	}
	
	@GetMapping("/{id}")
	public Manufacturer findById(@PathVariable Integer id) {
		return manufacturerService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@Valid @RequestBody Manufacturer manufacturer) {
		manufacturerService.create(manufacturer);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@Valid @RequestBody Manufacturer manufacturer) {
		manufacturerService.update(manufacturer);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@RequestBody Manufacturer manufacturer) {
		manufacturerService.delete(manufacturer);
	}
}
