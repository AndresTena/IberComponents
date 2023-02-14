package es.code.urjc.ibercomponents.controllers;
import java.util.List;
import java.util.Optional;

import es.code.urjc.ibercomponents.entities.Product;
import es.code.urjc.ibercomponents.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

    @Autowired
    private ProductService productService;
    @GetMapping("/")
    public String home(Model model) {
        List<Product> productList = productService.findAll();
        if (productList != null){
            model.addAttribute("products", productList);
        }
        return "index";
    }


    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("name", "Mundo");

        return "login";
    }

    @GetMapping("/signin")
    public String signin(Model model) {

        model.addAttribute("name", "Mundo");

        return "sign-in";
    }

    @GetMapping("/product")
    public String prueba(Model model)
    {
        Optional<Product> product = productService.findById(1);

        if(product.isPresent()) {
            model.addAttribute("product", product.get());
            return "product";
        }else {
            return "index";
        }
    }

    @RequestMapping("/product/{id}")
    public String product(Model model, @PathVariable long id) {

    	Optional<Product> product = productService.findById(id);

        if(product.isPresent()) {
        	model.addAttribute("product", product.get());
        	return "product";
        }else {
        	return "index";
        }
    }
}