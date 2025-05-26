package plamen.projects.SuperMarkerSpringBoot.controllers;

import java.util.List;

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

import jakarta.validation.Valid;
import plamen.projects.SuperMarkerSpringBoot.beans.Discount;
import plamen.projects.SuperMarkerSpringBoot.repositories.DiscountRepository;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {

	private final DiscountRepository discountRepository;

	public DiscountController(DiscountRepository discountRepository) {
		super();
		this.discountRepository = discountRepository;
	}
	
	@GetMapping()
	public List<Discount> getAll() {
		return discountRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Discount getById(@PathVariable Integer id) {
		Discount referenceById = discountRepository.getReferenceById(id);
		return referenceById;
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@Valid @RequestBody Discount discount) {
		discountRepository.save(discount);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@Valid @RequestBody Discount discount) {
		discountRepository.save(discount);
	}
	
	@DeleteMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@RequestBody Discount discount) {
		System.out.println("delete starting");
		discountRepository.delete(discount);
	}
}
