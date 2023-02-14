package es.code.urjc.ibercomponents.repositories;

import es.code.urjc.ibercomponents.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
