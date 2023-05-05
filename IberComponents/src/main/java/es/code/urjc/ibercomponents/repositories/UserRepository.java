package es.code.urjc.ibercomponents.repositories;

import es.code.urjc.ibercomponents.entities.ShoppingCart;
import es.code.urjc.ibercomponents.entities.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

    User save(User anuncio);

    List<User> findAll();
}