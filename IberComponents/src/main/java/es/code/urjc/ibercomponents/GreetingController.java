package es.code.urjc.ibercomponents;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class GreetingController {

    @Autowired
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
    public String getProduct(Model model,@PathVariable long id) {

    	Optional<Product> product = productService.findById(id);

        if(product.isPresent()) {
        	model.addAttribute("product", product.get());
        	return "product";
        }else {
        	return "index";
        }
    }


    @GetMapping("/newProduct")
    public String newProduct() {

        return "newProduct";
    }

    @PostMapping("/newProduct")
    public String newProductProcess(Model model, Product product, MultipartFile imageField) throws IOException {

        if (!imageField.isEmpty()) {
            //product.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
            //product.setImage(true);
        }


        productService.save(product);

        model.addAttribute("id", product.getId());

        return "redirect:/product/"+product.getId();
    }
}