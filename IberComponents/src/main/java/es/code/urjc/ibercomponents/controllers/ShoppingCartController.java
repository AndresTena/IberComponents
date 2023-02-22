package es.code.urjc.ibercomponents.controllers;

import es.code.urjc.ibercomponents.entities.Product;
import es.code.urjc.ibercomponents.entities.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.code.urjc.ibercomponents.services.ShoppingCartService;
import es.code.urjc.ibercomponents.services.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCart;
    @GetMapping("/shoppingCart")
    public String shoppingCart(Model model)
    {
        Optional<ShoppingCart> carrito = shoppingCart.findById(1);
        model.addAttribute("shoppingCart", carrito);
        return "shoppingCart";
    }



    @PostMapping("/product/{id}")
    public String addProductShoppingCart(Model model, Product product)
    {

        if((product.getFeatures() != null) &&(product.getName() != null )&& (product.getPrice() > 0)&&(product.getName()!= null) )
        {
            model.addAttribute("product", product);
            return "shoppingCart";
        }
        else
        {

            return "redirect:/product/"+product.getId();
        }

    }
}