package es.code.urjc.ibercomponents;


import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private String user_name;
    private String user_password;
    private Boolean user_admin;

    @OneToOne(cascade = CascadeType.ALL)
    private ShoppingCart cart;

    public User() {
    }

    public User(String user_name, String user_password, ShoppingCart cart, Boolean user_admin) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.cart = cart;
        this.user_admin = user_admin;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String name) {
        this.user_name = name;
    }

    public String getUserPassword() {
        return user_password;
    }

    public void setUserPassword(String password) {
        this.user_password = password;
    }

    public ShoppingCart getShoppingCart() {
        return cart;
    }

    public void setShoppingCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public boolean getUserAdmin() {
        return user_admin;
    }

    public void setUserAdmin(Boolean UserAdmin) {
        this.user_admin = user_admin;
    }
}
