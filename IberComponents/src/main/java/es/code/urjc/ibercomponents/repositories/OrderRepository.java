package es.code.urjc.ibercomponents.repositories;

import es.code.urjc.ibercomponents.entities.Order;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@CacheConfig (cacheNames = "pedidos")
public interface OrderRepository extends JpaRepository<Order, Long> {

    @CacheEvict(allEntries=true)
    Order save(Order anuncio);

    @Cacheable
    Optional<Order> findByUsername(String name);

    @Cacheable
    List<Order> findAll();
}