package plamen.projects.SuperMarkerSpringBoot.servise;

import java.util.List;

import org.springframework.stereotype.Service;

import plamen.projects.SuperMarkerSpringBoot.beans.Manufacturer;
import plamen.projects.SuperMarkerSpringBoot.repositories.ManufacturerRepository;

@Service
public class ManufacturerService {

	public final ManufacturerRepository manufacturerRepository;

	public ManufacturerService(ManufacturerRepository manufacturerRepository) {
		super();
		this.manufacturerRepository = manufacturerRepository;
	}
	
	public void create(Manufacturer manufacturer) {
		manufacturerRepository.save(manufacturer);
	}
	
	public List<Manufacturer> findAll() {
		return manufacturerRepository.findAll();
	}

	public Manufacturer findById(Integer id) {
		return manufacturerRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Manufacturer not found"));
	}
	
	public void update(Manufacturer manufacturer) {
		if (manufacturer.getId() == null || !manufacturerRepository.existsById(manufacturer.getId())) {
			throw new IllegalArgumentException("Manufacturer with given ID does not exist.");
		}
		manufacturerRepository.save(manufacturer);
	}
	
	public void delete(Integer id) {
		if (!manufacturerRepository.existsById(id)) {
			throw new IllegalArgumentException("Manufacturer with given ID does not exist.");
		}
		manufacturerRepository.deleteById(id);
	}
}
