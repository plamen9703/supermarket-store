package plamen.projects.SuperMarkerSpringBoot.servise;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
				.orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
						"Manufacturer with id %d not found".formatted(id)));
	}
	
	public void update(Manufacturer manufacturer) {
		if (manufacturer.getId() == null || !manufacturerRepository.existsById(manufacturer.getId())) {
			throw new IllegalArgumentException("Manufacturer with given ID does not exist.");
		}
		manufacturerRepository.save(manufacturer);
	}
	
	public void delete(Manufacturer manufacturer) {
		if (!manufacturerRepository.exists(manufacturer)) {
			throw new IllegalArgumentException("Manufacturer with given ID does not exist.");
		}
		manufacturerRepository.delete(manufacturer);
	}
}
