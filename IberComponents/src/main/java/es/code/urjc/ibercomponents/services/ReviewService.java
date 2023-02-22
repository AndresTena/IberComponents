package es.code.urjc.ibercomponents.services;

import es.code.urjc.ibercomponents.entities.Review;
import es.code.urjc.ibercomponents.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    //  @Autowired
    private ReviewRepository repository;

    public Optional<Review> findById(long id)
    {
        return repository.findById(id);
    }

    public List<Review> findAll()
    {
        return repository.findAll();
    }

    public void save(Review review)
    {
        repository.save(review);
    }

    public void delete(Review review)
    {
        repository.delete(review);
    }
}
