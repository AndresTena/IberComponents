package es.code.urjc.ibercomponents.entities;

import es.code.urjc.ibercomponents.controllers.OrdersController;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
@Table(name = "ShoppingCart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "productos")
    @ManyToMany
    private List<Product> products;


    private double sumProductPrices;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public ShoppingCart(long id) {
        this.id = id;
        this.sumProductPrices = 0;
    }


    public ShoppingCart(List<Product> products, String address)
    {
        this.sumProductPrices = 0;

        products = new ArrayList<>();

    }

    public void addProduct(Product product)
    {
        if(product!= null)
        products.add(product);
    }

    public void deleteProduct(Product product)
    {
        if(product!= null)
            products.remove(product);
    }

    public void copyProducts(ShoppingCart shoppingCart)
    {
        for (int i = 0; i < shoppingCart.getProducts().size(); i++)
        {
            this.products.add(shoppingCart.products.get(i));
        }
    }

    public void deleteAllProducts()
    {
        products = null;
        products = new ArrayList<>();
    }

    public int getLength()
    {
        return products.size();
    }

    public Long getId() {
        return id;
    }

    public double getSumProductPrices()
    {
        double suma = 0;
        for(int i =0; i < products.size(); i++)
        {
            suma += products.get(i).getPrice();
        }

        this.sumProductPrices = suma;

        return suma;

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
