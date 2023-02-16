package es.code.urjc.ibercomponents.controllers;


import es.code.urjc.ibercomponents.entities.Product;
import es.code.urjc.ibercomponents.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
public class ProductController {

    private ProductService productService;

    @RequestMapping("/product/{id}")
    public String getProduct(Model model, @PathVariable long id) {

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

        if((product.getId() != null) && (product.getFeatures() != null) &&(product.getName() != null )&&(product.getPrice() > 0)&& (product.getName()!= null) )
        {
            productService.save(product);

            model.addAttribute("id", product.getId());

            return "redirect:/product/"+product.getId();
        }
        else
            return "/newProduct";

    }
}
