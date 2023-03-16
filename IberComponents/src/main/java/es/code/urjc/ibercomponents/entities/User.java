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
    private String password;
    private Boolean userAdmin;

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
        this.password = user_password;
        this.cart = cart;
        this.userAdmin = user_admin;
        this.gmail = gmail;
        this.id = id;
        this.money = money;
        this.roles = List.of(roles);
    }
    public User(long id,String user_name, String user_password, ShoppingCart cart, Boolean user_admin, String gmail, double money) {
        this.name = user_name;
        this.password = user_password;
        this.cart = cart;
        this.userAdmin = user_admin;
        this.gmail = gmail;
        this.id = id;
        this.money = money;
    }


    public ShoppingCart getCart() {
        return cart;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public boolean getAdmin() {
        return userAdmin;
    }

    public void setAdmin(Boolean userAdmin) {
        this.userAdmin = userAdmin;
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

    public void setRoles(List<String> roles) {this.roles = roles; }
}
