package es.code.urjc.ibercomponents.services;


import es.code.urjc.ibercomponents.entities.Product;
import es.code.urjc.ibercomponents.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Optional<Product> findById(long id)
    {
        return repository.findById(id);
    }

    public List<Product> findAll()
    {
        return repository.findAll();
    }

    public void save(Product product)
    {
        repository.save(product);
    }

    public void delete(Product product)
    {
        repository.delete(product);
    }
}
