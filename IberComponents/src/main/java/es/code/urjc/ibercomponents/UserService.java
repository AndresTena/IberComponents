package es.code.urjc.ibercomponents;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private UserRepository repository;

    public Optional<User> findById(long id)
    {
        return repository.findById(id);
    }

    public List<User> findAll()
    {
        return repository.findAll();
    }

    public void save(User product)
    {
        repository.save(product);
    }

    public void delete(User product)
    {
        repository.delete(product);
    }
}
