package es.code.urjc.ibercomponents;

import java.util.List;
import java.util.Optional;

public class OrderService {
    //  @Autowired
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
