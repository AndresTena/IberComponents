package es.code.urjc.ibercomponents.services;

import es.code.urjc.ibercomponents.entities.User;
import es.code.urjc.ibercomponents.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
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

    public Optional<User> findByName(String name)
    {
        List <User> users = findAll();
        for(User user: users)
        {
            if(user.getUserName() == name)
                return Optional.of(user);
        }
        return null;
    }
    public void delete(User product)
    {
        repository.delete(product);
    }
}
