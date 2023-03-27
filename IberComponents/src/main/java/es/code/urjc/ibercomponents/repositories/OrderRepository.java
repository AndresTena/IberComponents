package es.code.urjc.ibercomponents.repositories;

import es.code.urjc.ibercomponents.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByUsername(String name);
}