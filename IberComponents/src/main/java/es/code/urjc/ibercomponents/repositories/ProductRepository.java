package es.code.urjc.ibercomponents.repositories;

import es.code.urjc.ibercomponents.entities.Order;
import es.code.urjc.ibercomponents.entities.Product;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@CacheConfig(cacheNames = "productos")
public interface ProductRepository extends JpaRepository<Product, Long> {

    @CacheEvict(allEntries=true)
    Product save(Product anuncio);
    @Cacheable
    List<Product> findAll();
}
