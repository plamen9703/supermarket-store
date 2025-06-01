package plamen.projects.SuperMarkerSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import plamen.projects.SuperMarkerSpringBoot.beans.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer>{


	boolean exists(Manufacturer manufacturer);

}
