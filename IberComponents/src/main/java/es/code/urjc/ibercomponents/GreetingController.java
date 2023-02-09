package es.code.urjc.ibercomponents;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GreetingController {

	private ProductService productService;
    @GetMapping("/home")
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
    @GetMapping("/product/{id}")
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