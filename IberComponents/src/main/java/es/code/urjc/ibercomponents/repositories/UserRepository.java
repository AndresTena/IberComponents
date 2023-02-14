package es.code.urjc.ibercomponents.repositories;

import es.code.urjc.ibercomponents.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}