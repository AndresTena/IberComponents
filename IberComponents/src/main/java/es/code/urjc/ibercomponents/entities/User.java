package es.code.urjc.ibercomponents.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private String name;

    @JsonIgnore
    private String user_password;
    private Boolean user_admin;

    private String gmail;

    private double money;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;


    @OneToOne(cascade = CascadeType.ALL)
    private ShoppingCart cart;

    public User() {
    }

    public User(long id,String user_name, String user_password, ShoppingCart cart, Boolean user_admin, String gmail, double money, String ...roles) {
        this.name = user_name;
        this.user_password = user_password;
        this.cart = cart;
        this.user_admin = user_admin;
        this.gmail = gmail;
        this.id = id;
        this.money = money;
        this.roles = List.of(roles);
    }
    public User(long id,String user_name, String user_password, ShoppingCart cart, Boolean user_admin, String gmail, double money) {
        this.name = user_name;
        this.user_password = user_password;
        this.cart = cart;
        this.user_admin = user_admin;
        this.gmail = gmail;
        this.id = id;
        this.money = money;
    }


    public ShoppingCart getCart() {
        return cart;
    }

    public String getUserName() {
        return name;
    }

    public void setUserName(String name) {
        this.name = name;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public boolean getUserAdmin() {
        return user_admin;
    }

    public void setUserAdmin(Boolean UserAdmin) {
        this.user_admin = user_admin;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public List<String> getRoles() {
        return roles;
    }
}
