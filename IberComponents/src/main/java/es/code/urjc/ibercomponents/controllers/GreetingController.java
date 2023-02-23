package es.code.urjc.ibercomponents.controllers;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import es.code.urjc.ibercomponents.entities.Product;
import es.code.urjc.ibercomponents.entities.ShoppingCart;
import es.code.urjc.ibercomponents.entities.User;
import es.code.urjc.ibercomponents.services.ProductService;
import es.code.urjc.ibercomponents.services.ShoppingCartService;
import es.code.urjc.ibercomponents.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;


    @Autowired
    private ShoppingCartService shoppingCart;

    @GetMapping("/")
    public String home(Model model) {
        Optional<User> user = userService.findById(1);
        if(user!=null)
        {
            model.addAttribute("userExists", true);
            model.addAttribute("user", user.get());
        }else {
            model.addAttribute("userExists", false);
        }
    List<Product> productList = productService.findAll();
        if (productList != null)
        {
            model.addAttribute("products", productList);
        }

        model.addAttribute("userLogged", true);
        return "index";
    }

    @GetMapping("/aboutUs")
    public String aboutUs()
    {
        return "aboutUs";
    }
}