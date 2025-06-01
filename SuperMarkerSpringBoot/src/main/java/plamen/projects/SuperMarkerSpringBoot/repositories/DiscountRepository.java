package plamen.projects.SuperMarkerSpringBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import plamen.projects.SuperMarkerSpringBoot.beans.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer>{
	Optional<Discount> findById(Integer id);

	boolean exists(Discount discount);
}
