package plamen.projects.SuperMarkerSpringBoot.beans;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table
public class Manufacturer{
	@Id
	private Integer id;
	@NotEmpty
	private String manufacturerName;
	@NotEmpty
	private String contatct;
	@NotEmpty
	private String address;
	@OneToMany(mappedBy = "manufacturerId")
	private List<Product> products;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getManufacturerName() {
		return manufacturerName;
	}
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	public String getContatct() {
		return contatct;
	}
	public void setContatct(String contatct) {
		this.contatct = contatct;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Manufacturer(Integer id, @NotEmpty String manufacturerName, @NotEmpty String contatct,
			@NotEmpty String address) {
		super();
		this.id = id;
		this.manufacturerName = manufacturerName;
		this.contatct = contatct;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Manufacturer []";
	}
	public Manufacturer() {
	}
	
}
