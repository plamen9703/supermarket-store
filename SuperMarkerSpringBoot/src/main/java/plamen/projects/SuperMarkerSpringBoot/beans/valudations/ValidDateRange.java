package plamen.projects.SuperMarkerSpringBoot.beans.valudations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RUNTIME)
@Constraint(validatedBy = DateRangeValidator.class)
@Target(TYPE)
public @interface ValidDateRange {
	String message() default "start date must be before end date";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
}
