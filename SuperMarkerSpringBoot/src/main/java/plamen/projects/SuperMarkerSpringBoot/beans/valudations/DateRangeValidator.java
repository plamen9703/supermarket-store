package plamen.projects.SuperMarkerSpringBoot.beans.valudations;

import java.time.LocalDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import plamen.projects.SuperMarkerSpringBoot.beans.Discount;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, Discount> {

	@Override
	public boolean isValid(Discount discount, ConstraintValidatorContext context) {
		if(discount == null)return true;
		LocalDate start= discount.getStartDate();
		LocalDate end= discount.getEndDate();
		boolean before = start.isBefore(end);
		return start!=null && end !=null && before;
	}

}
