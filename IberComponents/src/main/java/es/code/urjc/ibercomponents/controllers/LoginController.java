package es.code.urjc.ibercomponents.controllers;

import es.code.urjc.ibercomponents.Producer;
import es.code.urjc.ibercomponents.entities.Order;
import es.code.urjc.ibercomponents.entities.ShoppingCart;
import es.code.urjc.ibercomponents.entities.User;
import es.code.urjc.ibercomponents.services.OrderService;
import es.code.urjc.ibercomponents.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private Producer producer;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("/signin")
    public String signin() {
        return "sign-in";
    }

    @PostMapping("/signin")
    public String signInProcess(Model model, User user) throws IOException
    {
        if(user.getName() != null && user.getGmail() != null && user.getPassword() != null) {
            ShoppingCart cart = new ShoppingCart();
            Order order = new Order();
            order.setUsername(user.getName());
            orderService.save(order);
            user.setShoppingCart(cart);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Collections.singletonList("USER"));
            user.setMoney(100);
            userService.save(user);
            producer.setUser(user.getGmail());
            producer.sendMessage();
            model.addAttribute("User", user);

        }

        return "redirect:/";

    }

    @RequestMapping("/loginError")
    public String loginError()
    {
        return "loginError";
    }
}
