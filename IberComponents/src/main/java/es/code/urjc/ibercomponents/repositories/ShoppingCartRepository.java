package es.code.urjc.ibercomponents.repositories;

import es.code.urjc.ibercomponents.entities.Review;
import es.code.urjc.ibercomponents.entities.ShoppingCart;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@CacheConfig(cacheNames = "carritos")
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    @CacheEvict(allEntries=true)
    ShoppingCart save(ShoppingCart anuncio);
    @Cacheable
    List<ShoppingCart> findAll();
}