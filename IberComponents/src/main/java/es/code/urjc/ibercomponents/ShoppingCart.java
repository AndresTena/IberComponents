package es.code.urjc.ibercomponents;

import javax.persistence.*;

import java.util.List;

import javax.persistence.Entity;

@Entity(name = "ShoppingCart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Product> products;

    public ShoppingCart() {}

    public ShoppingCart(List<Product> products, String address) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getproducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
