package plamen.projects.SuperMarkerSpringBoot.beans;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@ValidDateRange
public class Discount {
	@Id
	private Integer id;
	private Double dicountAmount;
	private LocalDate startDate;
	private LocalDate endDate;
	public Discount(){
	}
	public Discount(Integer id, Double dicountAmount, LocalDate startDate, LocalDate endDate) {
		super();
		if(startDate.isAfter(endDate))
			throw new IllegalArgumentException("Starting date can not be after end date.");
		this.id = id;
		this.dicountAmount = dicountAmount;
		this.startDate = startDate;
		this.endDate = endDate;

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getDicountAmount() {
		return dicountAmount;
	}
	public void setDicountAmount(Double dicountAmount) {
		this.dicountAmount = dicountAmount;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Discount [id=" + id + ", dicountAmount=" + dicountAmount + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(dicountAmount, endDate, id, startDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Discount other = (Discount) obj;
		return Objects.equals(dicountAmount, other.dicountAmount) && Objects.equals(endDate, other.endDate)
				&& Objects.equals(id, other.id) && Objects.equals(startDate, other.startDate);
	}
}
