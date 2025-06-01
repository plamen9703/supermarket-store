package plamen.projects.SuperMarkerSpringBoot.servise;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import plamen.projects.SuperMarkerSpringBoot.beans.Discount;
import plamen.projects.SuperMarkerSpringBoot.beans.Product;
import plamen.projects.SuperMarkerSpringBoot.repositories.DiscountRepository;
import plamen.projects.SuperMarkerSpringBoot.repositories.ProductRepository;

@Service
public class ProductService {
	public final ProductRepository productRepository;
	public final DiscountRepository discountRepository;
	
	public ProductService(ProductRepository productService, DiscountRepository discountRepository) {
		super();
		this.productRepository = productService;
		this.discountRepository = discountRepository;
	}
	
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Optional<Product> findById(Integer id){
		return productRepository.findById(id);
	}
	
	
	public void create(Product product) {
		Discount inputDiscont=product.getDiscount();
		if(inputDiscont ==null || inputDiscont.getStartDate()==null || inputDiscont.getEndDate()==null)
			throw new IllegalArgumentException("Discount start and end dates cannot be null.");
		validateDate(inputDiscont);
		productRepository.save(product);
	}


	private void validateDate(Discount inputDiscont) {
		boolean isValidDiscount = inputDiscont.getStartDate()!=null 
				&& inputDiscont.getEndDate()!=null 
				&& inputDiscont.getStartDate().isBefore(inputDiscont.getEndDate());
		if (!isValidDiscount) {
			throw new IllegalArgumentException("Start date should be before end date.");
		}
		boolean discountExists = discountRepository.existsById(inputDiscont.getId());
		if (!discountExists) {
			discountRepository.save(inputDiscont);
		}
	}
	
	
	public void update(Product product) {
		if (product.getId() == null || !productRepository.existsById(product.getId())) {
			throw new IllegalArgumentException("Product with given ID does not exist.");
		}
		create(product);
	}
	
	public void delete(Integer id) {
		if (!productRepository.existsById(id)) {
			throw new IllegalArgumentException("Product with given ID does not exist.");
		}
		productRepository.deleteById(id);
	}
	
	
}
