package plamen.projects.SuperMarkerSpringBoot.beans;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table
public class Product {
	@Id
	private Integer id;
	@NotNull
	private String productName;
	@Positive
	private Double price;
	@OneToOne(fetch = FetchType.LAZY)
	private Discount discount;
	@ManyToOne
	@JoinColumn(name = "manufacturer_id")
	private Manufacturer manufacturerId;
	private LocalDate exparationDate;
	@Positive
	private Integer amount;

	public Product() {

	}

	public Product(Integer id, @NotNull String productName, @Positive Double price, Discount discount,
			Manufacturer manufacturerId, LocalDate exparationDate, @Positive Integer amount) {
		super();
		if (exparationDate.isAfter(LocalDate.now()))
			throw new IllegalArgumentException("Exeration date can not be after the current date.");
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.discount = discount;
		this.manufacturerId = manufacturerId;
		this.exparationDate = exparationDate;
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Manufacturer getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Manufacturer manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public LocalDate getExparationDate() {
		return exparationDate;
	}

	public void setExparationDate(LocalDate exparationDate) {
		this.exparationDate = exparationDate;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
