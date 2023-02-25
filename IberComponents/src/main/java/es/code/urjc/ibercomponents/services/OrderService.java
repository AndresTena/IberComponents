package es.code.urjc.ibercomponents.services;

import es.code.urjc.ibercomponents.entities.Order;
import es.code.urjc.ibercomponents.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public Optional<Order> findById(long id)
    {
        return repository.findById(id);
    }

    public List<Order> findAll()
    {
        return repository.findAll();
    }

    public void save(Order order)
    {
        repository.save(order);
    }

    public void delete(Order order)
    {
        repository.delete(order);
    }
}
