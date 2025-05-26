package plamen.projects.SuperMarkerSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import plamen.projects.SuperMarkerSpringBoot.beans.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
