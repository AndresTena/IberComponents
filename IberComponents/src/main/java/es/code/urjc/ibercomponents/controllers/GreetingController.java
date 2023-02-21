package es.code.urjc.ibercomponents.controllers;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import es.code.urjc.ibercomponents.entities.Product;
import es.code.urjc.ibercomponents.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
    @Autowired
    private ProductService productService;
    @GetMapping("/")
    public String home(Model model) {
        List<Product> productList = productService.findAll();
        if (productList != null)
        {
            model.addAttribute("products", productList);
        }

        model.addAttribute("userLogged", true);
        return "index";
    }
}