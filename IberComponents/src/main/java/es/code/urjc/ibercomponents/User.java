package es.code.urjc.ibercomponents;


import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity (name = "UserTable")
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private String name;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private ShoppingCart cart;

    public User() {
    }

    public User(String name, String password, ShoppingCart cart) {
        this.name = name;
        this.password = password;
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ShoppingCart getShoppingCart() {
        return cart;
    }

    public void setShoppingCart(ShoppingCart cart) {
        this.cart = cart;
    }
}
