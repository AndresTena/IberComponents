package es.code.urjc.ibercomponents.controllers;


import es.code.urjc.ibercomponents.entities.Product;
import es.code.urjc.ibercomponents.services.ProductService;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Controller
public class ProductController {

    private static final Path IMAGES_FOLDER = Paths.get(System.getProperty("user.dir"), "images");

    @Autowired
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
    public String newProductProcess(Model model, Product product, String imageName, MultipartFile image) throws IOException {

        if (!image.isEmpty()) {
            product.setImageName(imageName);
            Files.createDirectories(IMAGES_FOLDER);
            Path imagePath = IMAGES_FOLDER.resolve(imageName + ".png");
            image.transferTo(imagePath);
            product.setImageBool(true);
        }

        if((product.getFeatures() != null) &&(product.getName() != null )&& (product.getPrice() > 0)&&(product.getName()!= null) )
        {
            productService.save(product);

            model.addAttribute("id", product.getId());

            return "redirect:/product/"+product.getId();
        }
        else
            return "/newProduct";

    }
}
