package es.code.urjc.ibercomponents.controllers;

import es.code.urjc.ibercomponents.entities.Order;
import es.code.urjc.ibercomponents.entities.User;
import es.code.urjc.ibercomponents.services.OrderService;
import es.code.urjc.ibercomponents.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class OrdersController
{
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;


    @GetMapping("/orders")
    public String getOrders(Model model)
    {


        Optional<User> user = userService.findById(1);
        if(user!=null) {
            model.addAttribute("user", user.get());
        }
        List<Order> orders = orderService.findAll();
        Order order = orders.get(0);

        if(order!= null)
        {
            model.addAttribute("order", order);
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