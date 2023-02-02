package es.code.urjc.ibercomponents;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
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
