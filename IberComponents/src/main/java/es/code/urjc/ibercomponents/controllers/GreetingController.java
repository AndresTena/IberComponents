package es.code.urjc.ibercomponents.controllers;
import java.io.IOException;
import java.security.Principal;
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
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GreetingController {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;


    @ModelAttribute
    public void addAttributes(Model model, HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();

        //System.out.println(principal.getName());
        if (principal != null) {

            model.addAttribute("userExists", true);
            model.addAttribute("userName", principal.getName());
            model.addAttribute("admin", request.isUserInRole("ADMIN"));

            Optional<User> user = userService.findByName(principal.getName())   ;
            System.out.println(user.isPresent());
            if(user!= null)
            {
                System.out.println("hola");
                model.addAttribute("money",user.get().getMoney());
                model.addAttribute("getProducts", user.get().getCart());
            }
        } else {
            model.addAttribute("userExists", false);
        }
    }

    @GetMapping("/")
    public String home(Model model)
    {
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