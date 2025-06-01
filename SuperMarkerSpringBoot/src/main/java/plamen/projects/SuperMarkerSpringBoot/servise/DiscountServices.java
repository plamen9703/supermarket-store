package plamen.projects.SuperMarkerSpringBoot.servise;

import java.util.List;

import org.springframework.stereotype.Service;

import plamen.projects.SuperMarkerSpringBoot.beans.Discount;
import plamen.projects.SuperMarkerSpringBoot.repositories.DiscountRepository;

@Service
public class DiscountServices {

	public final DiscountRepository discountRepository;
	
	public DiscountServices(DiscountRepository discountRepository) {
		super();
		this.discountRepository = discountRepository;
	}
	
	
	public List<Discount> findAll() {
		return discountRepository.findAll();
	}
	
	public Discount findById(Integer id) {
		return discountRepository.findById(id).orElse(null);
	}
	
	public void create(Discount discount) {
		if (discount.getStartDate() == null || discount.getEndDate() == null) {
			throw new IllegalArgumentException("Discount start and end dates cannot be null.");
		}
		if (discount.getStartDate().isAfter(discount.getEndDate())) {
			throw new IllegalArgumentException("Start date should be before end date.");
		}
		discountRepository.save(discount);
	}
	
	public void update(Discount discount) {
		if (discount.getId() == null || !discountRepository.existsById(discount.getId())) {
			throw new IllegalArgumentException("Discount with given ID does not exist.");
		}
		if (discount.getStartDate() == null || discount.getEndDate() == null) {
			throw new IllegalArgumentException("Discount start and end dates cannot be null.");
		}
		if (discount.getStartDate().isAfter(discount.getEndDate())) {
			throw new IllegalArgumentException("Start date should be before end date.");
		}
		discountRepository.save(discount);
	}
	
	public void delete(Integer id) {
		if (!discountRepository.existsById(id)) {
			throw new IllegalArgumentException("Discount with given ID does not exist.");
		}
		discountRepository.deleteById(id);
	}
}
