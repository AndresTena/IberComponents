package es.code.urjc.ibercomponents.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @OneToMany
    private List<ShoppingCart> shoppingCarts;

    public Order()
    {}

    public Order (long id)
    {
        this.id = id;
    }

    public void addShoppingCart(ShoppingCart s)
    {
        if(s!= null)
        shoppingCarts.add(s);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
