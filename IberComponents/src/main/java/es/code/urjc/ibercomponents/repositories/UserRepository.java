package es.code.urjc.ibercomponents.repositories;

import es.code.urjc.ibercomponents.entities.ShoppingCart;
import es.code.urjc.ibercomponents.entities.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@CacheConfig(cacheNames = "usuarios")
public interface UserRepository extends JpaRepository<User, Long> {
    @Cacheable
    Optional<User> findByName(String name);
    @CacheEvict(allEntries=true)
    User save(User anuncio);
    @Cacheable
    List<User> findAll();
}