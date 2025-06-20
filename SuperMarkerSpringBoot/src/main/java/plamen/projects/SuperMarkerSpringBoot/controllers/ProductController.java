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
import plamen.projects.SuperMarkerSpringBoot.beans.Product;
import plamen.projects.SuperMarkerSpringBoot.servise.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping()
	public List<Product> findAll() {
		return productService.findAll();
	}
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable Integer id) {
		Optional<Product> product = productService.findById(id);
		if( product.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Manufacturer with id %d not found".formatted(id));
		return product.get();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@Valid @RequestBody Product manufacturer) {
		productService.create(manufacturer);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@Valid @RequestBody Product product) {
		productService.update(product);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@RequestBody Product manufacturer) {
		productService.delete(manufacturer);
	}
	
}
