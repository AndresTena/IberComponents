package es.code.urjc.ibercomponents.entities;

import javax.persistence.*;

import java.util.List;

import javax.persistence.Entity;

@Entity
@Table(name = "ShoppingCart")
public class ShoppingCart {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "ejemplo")
    @OneToMany
    private List<Product> products;

    public ShoppingCart() {}

    public ShoppingCart(long id) {
        this.id = id;
    }


    public ShoppingCart(List<Product> products, String address) {

    }

    public void addProduct(Product product)
    {
        if(product!= null)
        products.add(product);
    }

    public int getLength()
    {
        return products.size();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
