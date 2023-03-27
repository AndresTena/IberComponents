package es.code.urjc.ibercomponents.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    private String username;
    @OneToMany
    private List<ShoppingCart> shoppingCarts;

    public Order()
    {}

    public Order (long id)
    {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void addShoppingCart(ShoppingCart s)
    {
        if(s!= null)
        shoppingCarts.add(s);
    }

    public Order deleteShoppingCart()
    {
        this.shoppingCarts = new ArrayList<ShoppingCart>();
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
