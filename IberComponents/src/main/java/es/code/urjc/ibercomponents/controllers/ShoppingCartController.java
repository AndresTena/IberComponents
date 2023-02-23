package es.code.urjc.ibercomponents.controllers;

import es.code.urjc.ibercomponents.entities.Product;
import es.code.urjc.ibercomponents.entities.ShoppingCart;
import es.code.urjc.ibercomponents.entities.User;
import es.code.urjc.ibercomponents.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.code.urjc.ibercomponents.services.ShoppingCartService;
import es.code.urjc.ibercomponents.services.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCart;

    @Autowired
    private UserService userService;


    @Autowired
    private ProductService productService;
    @GetMapping("/shoppingCart")
    public String shoppingCart(Model model)
    {
        Optional<User> user = userService.findById(1);
        if(user!=null) {
            model.addAttribute("user", user.get());
        }
        model.addAttribute("shoppingCart");
        return "shoppingCart";
    }



    @PostMapping("/addProduct/{id}")
    public String addProductShoppingCart(Model model, @PathVariable String id)
    {

        Optional<Product> product = productService.findById(Long.parseLong(id));
        Optional<User> user = userService.findById(1);
        if(user!=null) {
            model.addAttribute("user", user.get());
        }
        ShoppingCart carrito = user.get().getCart();
        if((product.get().getFeatures() != null) &&(product.get().getName() != null )&& (product.get().getPrice() > 0)&&(product.get().getName()!= null) )
        {
            Optional<Product> product1 = productService.findById(1);
            carrito.addProduct(product1.get());
            user.get().setShoppingCart(carrito);
            userService.save(user.get());
            return "/shoppingCart";
        }
        return "/";

    }
}