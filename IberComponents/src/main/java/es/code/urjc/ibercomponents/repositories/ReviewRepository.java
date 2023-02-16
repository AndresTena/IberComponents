package es.code.urjc.ibercomponents.repositories;

import es.code.urjc.ibercomponents.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}