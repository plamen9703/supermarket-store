package plamen.projects.SuperMarkerSpringBoot.servise;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import plamen.projects.SuperMarkerSpringBoot.beans.Discount;
import plamen.projects.SuperMarkerSpringBoot.beans.Product;
import plamen.projects.SuperMarkerSpringBoot.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	private final DiscountService discountService;
	private final ManufacturerService manufacturerService;
	public ProductService(ProductRepository productService,
			DiscountService discountServise,
			ManufacturerService manufacturerService) {
		super();
		this.productRepository = productService;
		this.discountService = discountServise;
		this.manufacturerService = manufacturerService;
	}
	
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Optional<Product> findById(Integer id){
		return productRepository.findById(id);
	}
	
	
	public void create(Product product) {
		Discount inputDiscont=product.getDiscount();
		validateDate(inputDiscont);
		productRepository.save(product);
	}


	private void validateDate(Discount inputDiscont) {
		if(inputDiscont ==null || inputDiscont.getStartDate()==null || inputDiscont.getEndDate()==null)
			throw new IllegalArgumentException("Discount start and end dates cannot be null.");
		boolean isValidDiscount = inputDiscont.getStartDate()!=null 
				&& inputDiscont.getEndDate()!=null 
				&& inputDiscont.getStartDate().isBefore(inputDiscont.getEndDate());
		if (!isValidDiscount) {
			throw new IllegalArgumentException("Start date should be before end date.");
		}
		boolean discountExists = discountService.exists(inputDiscont);
		if (!discountExists) {
			discountService.create(inputDiscont);
		}
	}
	
	
	public void update(Product product) {
		if (product.getId() == null || !productRepository.existsById(product.getId())) {
			throw new IllegalArgumentException("Product with given ID does not exist.");
		}
		create(product);
	}
	
	public void delete(Product manufacturer) {
		if (!productRepository.exists(manufacturer)) {
			throw new IllegalArgumentException("Product with given ID does not exist.");
		}
		productRepository.delete(manufacturer);
	}
	
	
}
