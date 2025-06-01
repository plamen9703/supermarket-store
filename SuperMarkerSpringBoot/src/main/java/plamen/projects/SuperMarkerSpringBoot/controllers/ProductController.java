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
import plamen.projects.SuperMarkerSpringBoot.beans.Discount;
import plamen.projects.SuperMarkerSpringBoot.beans.Manufacturer;
import plamen.projects.SuperMarkerSpringBoot.beans.Product;
import plamen.projects.SuperMarkerSpringBoot.repositories.DiscountRepository;
import plamen.projects.SuperMarkerSpringBoot.repositories.ProductRepository;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	public final ProductRepository productRepository;
	public final DiscountRepository discountRepository;

	public ProductController(ProductRepository productRepository, DiscountRepository discountRepository) {
		super();
		this.productRepository = productRepository;
		this.discountRepository = discountRepository;
	}

	@GetMapping()
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable Integer id) {
		Optional<Product> product = productRepository.findById(id);
		if( product.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Manufacturer with id %d not found".formatted(id));
		return product.get();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@Valid @RequestBody Product manufacturer) {
		productRepository.save(manufacturer);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Product update(@Valid @RequestBody Product product) {
		Optional<Discount> discount = discountRepository.findById(product.getDiscount().getId());
		System.out.println(discount.toString());
		if(discount.isEmpty())discountRepository.save(product.getDiscount());
		return productRepository.save(product);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@RequestBody Product manufacturer) {
		productRepository.delete(manufacturer);
	}
	
}
