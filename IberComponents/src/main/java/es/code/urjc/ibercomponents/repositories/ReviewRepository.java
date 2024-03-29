package es.code.urjc.ibercomponents.repositories;

import es.code.urjc.ibercomponents.entities.Product;
import es.code.urjc.ibercomponents.entities.Review;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@CacheConfig(cacheNames = "review")
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @CacheEvict(allEntries=true)
    Review save(Review anuncio);

    @CachePut(value = "review")
    List<Review> findAll();
}