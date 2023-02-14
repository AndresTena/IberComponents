package es.code.urjc.ibercomponents.repositories;

import es.code.urjc.ibercomponents.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}