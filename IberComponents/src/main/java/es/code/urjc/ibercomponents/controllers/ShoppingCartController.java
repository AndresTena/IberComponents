package es.code.urjc.ibercomponents.controllers;

import es.code.urjc.ibercomponents.entities.Order;
import es.code.urjc.ibercomponents.entities.Product;
import es.code.urjc.ibercomponents.entities.ShoppingCart;
import es.code.urjc.ibercomponents.entities.User;
import es.code.urjc.ibercomponents.services.OrderService;
import es.code.urjc.ibercomponents.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.code.urjc.ibercomponents.services.ShoppingCartService;
import es.code.urjc.ibercomponents.services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCart;

    @Autowired
    private UserService userService;


    @Autowired
    private OrderService orderService;


    @Autowired
    private ProductService productService;

    @ModelAttribute
    public void addAttributes(Model model, HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();

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

    @GetMapping("/shoppingCart")
    public String shoppingCart(Model model)
    {
        return "shoppingCart";
    }

    @GetMapping("/shoppingCartError")
    public String shoppingCartError()
    {
        return "shoppingCartError";
    }


    @GetMapping("/deleteProductsShoppingCart")
    public String deleteProductsShoppingCart(Model model)
    {
        Optional<User> user = userService.findById(1);
        if(user!=null) {
            model.addAttribute("user", user.get());
        }
        ShoppingCart carrito = user.get().getCart();

        double money = user.get().getMoney() - carrito.getSumProductPrices();
        List<Order> orders = orderService.findAll();
        Order order = orders.get(0);
        if(money <0 && order != null)
        {
            return "/";
        }

        ShoppingCart carritoAux = new ShoppingCart();
        shoppingCart.save(carritoAux);
        carritoAux.copyProducts(carrito);
        order.addShoppingCart(carritoAux);
        orderService.save(order);
        //el usuario tiene dinero suficiente para pagar los productos
        user.get().setMoney(user.get().getMoney() - carrito.getSumProductPrices());
        carrito.deleteAllProducts();
        user.get().setShoppingCart(carrito);

        userService.save(user.get());
        shoppingCart.save(carrito);
        return "/";

    }



    @GetMapping("/deleteProductShoppingCart/{id}")
    public String deleteProductShoppingCart(Model model, @PathVariable String id)
    {
        Optional<Product> product = productService.findById(Long.parseLong(id));
        Optional<User> user = userService.findById(1);
        if(user!=null) {
            model.addAttribute("user", user.get());
        }
        ShoppingCart carrito = user.get().getCart();
        if((product.get().getFeatures() != null) &&(product.get().getName() != null )&& (product.get().getPrice() > 0)&&(product.get().getName()!= null) )
        {
            carrito.deleteProduct(product.get());
            user.get().setShoppingCart(carrito);
            userService.save(user.get());
            shoppingCart.save(carrito);
            return "/shoppingCart";
        }
        return "/";

    }


    @GetMapping("/addProduct/{id}")
    public String addProductShoppingCart(Model model, @PathVariable String id)
    {

        Optional<Product> product = productService.findById(Long.parseLong(id));
        Optional<User> user = userService.findById(1);
        if(user!=null) {
            model.addAttribute("user", user.get());
        }

        //no se puede comprar un producto que ya est?? en el carrito
        boolean condition =(product.get().getName() != null )&& (product.get().getPrice() > 0);
        if(condition)
        {
            ShoppingCart carrito = user.get().getCart();
            carrito.addProduct(product.get());
            user.get().setShoppingCart(carrito);
            userService.save(user.get());
            shoppingCart.save(carrito);
            return "/shoppingCart";
        }
        return "/";

    }
}