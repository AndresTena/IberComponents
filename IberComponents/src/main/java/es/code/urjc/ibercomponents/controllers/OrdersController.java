package es.code.urjc.ibercomponents.controllers;

import es.code.urjc.ibercomponents.entities.Order;
import es.code.urjc.ibercomponents.entities.User;
import es.code.urjc.ibercomponents.services.OrderService;
import es.code.urjc.ibercomponents.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class OrdersController
{
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

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

    @GetMapping("/order")
    public String getOrders(Model model,HttpServletRequest request)
    {
        Optional<Order> order = orderService.findByName(user.get().getName());
        if(order!= null)
        {
            model.addAttribute("order", order.get());
            return "orders";
        }
        return "/";
    }

    @GetMapping("/orderError")
    public String orderError()
    {
        return "orderError";
    }

}