package es.code.urjc.ibercomponents.controllers;


import es.code.urjc.ibercomponents.entities.Product;
import es.code.urjc.ibercomponents.entities.Review;
import es.code.urjc.ibercomponents.entities.ShoppingCart;
import es.code.urjc.ibercomponents.entities.User;
import es.code.urjc.ibercomponents.services.OrderService;
import es.code.urjc.ibercomponents.services.ProductService;
import es.code.urjc.ibercomponents.services.ReviewService;
import es.code.urjc.ibercomponents.services.UserService;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    private static final Path IMAGES_FOLDER = Paths.get(System.getProperty("user.dir")+"/src/main/resources/static", "/images");

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;


    @Autowired
    private ReviewService reviewService;


    private Optional<User> user;
    @ModelAttribute
    public void addAttributes(Model model, HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();

        if (principal != null) {

            model.addAttribute("userExists", true);
            model.addAttribute("userName", principal.getName());
            model.addAttribute("admin", request.isUserInRole("ADMIN"));

            user = userService.findByName(principal.getName())   ;
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

    @RequestMapping("/product/{id}")
    public String getProduct(Model model, @PathVariable long id)
    {
        Optional<Product> product = productService.findById(id);

        if(product.isPresent()) {
            model.addAttribute("product", product.get());
            model.addAttribute("reviewsSize", product.get().getReviews().size());
            return "product";
        }else {
            return "index";
        }
    }




    @GetMapping("/newProductPage")
    public String newProduct() {

        return "newProduct";
    }




    @PostMapping("/newProduct")
    public String newProductProcess(Model model, Product product, MultipartFile image) throws IOException {
        if((product.getFeatures() != null) &&(product.getName() != null )&& (product.getPrice() > 0)&&(product.getName()!= null) )
        {
            if (!image.isEmpty()) {
                product.setImageBool(true);
            }

            productService.save(product);
            model.addAttribute("id", product.getId());

            if (product.getImageBool()) {
                Files.createDirectories(IMAGES_FOLDER);
                Path imagePath = IMAGES_FOLDER.resolve(product.getId() + ".png");
                image.transferTo(imagePath);
            }


            return "redirect:/product/"+product.getId();
        }
        else
            return "/newProduct";

    }

    @GetMapping("/download_image/{id}")
    public ResponseEntity<Object> downloadImage(Model model, @PathVariable long id) throws MalformedURLException {

        Path imagePath = IMAGES_FOLDER.resolve(id + ".png");

        Resource image = new UrlResource(imagePath.toUri());

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/" + id + "png").body(image);
    }


    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(Model model, @PathVariable String id, HttpServletRequest request)
    {

        Optional<Product> product = productService.findById(Long.parseLong(id));
        if(user!=null) {
            model.addAttribute("user", user.get());
        }
        ShoppingCart carrito = user.get().getCart();
        if((product.get().getFeatures() != null) &&(product.get().getName() != null )&& (product.get().getPrice() > 0)&&(product.get().getName()!= null) )
        {
            productService.delete(product.get());
            user.get().setShoppingCart(carrito);
            userService.save(user.get());
            return "/productDeleted";
        }
        return "/";

    }


    @GetMapping("/newReview/{id}")
    public String newReviewProcess(@PathVariable long id, @RequestParam long score) {

        Optional<Product> product = productService.findById(id);
        if(product.isPresent()) {
            Review review = new Review(score);
            reviewService.save(review);
            product.get().addReview(review);
            product.get().getReviewsMean();
            productService.save(product.get());

        }
        return "redirect:/product/"+product.get().getId();

    }
}
