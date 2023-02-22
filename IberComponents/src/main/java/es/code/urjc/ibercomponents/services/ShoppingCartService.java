package es.code.urjc.ibercomponents.services;

import es.code.urjc.ibercomponents.entities.ShoppingCart;
import es.code.urjc.ibercomponents.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ShoppingCartService {


    @Autowired
    private ShoppingCartRepository repository;

    public Optional<ShoppingCart> findById(long id)
    {
        return repository.findById(id);
    }

    public List<ShoppingCart> findAll()
    {
        return repository.findAll();
    }

    public void save(ShoppingCart product)
    {
        repository.save(product);
    }

    public void delete(ShoppingCart product)
    {
        repository.delete(product);
    }
}
