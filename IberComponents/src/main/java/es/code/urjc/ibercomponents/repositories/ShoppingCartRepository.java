package es.code.urjc.ibercomponents.repositories;

import es.code.urjc.ibercomponents.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}