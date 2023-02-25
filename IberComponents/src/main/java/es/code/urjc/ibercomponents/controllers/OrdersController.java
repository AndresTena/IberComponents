package es.code.urjc.ibercomponents.controllers;

import es.code.urjc.ibercomponents.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersController
{
    @Autowired
    private OrderService orderService;


    @GetMapping("/orders")
    public String getOrders(Model model)
    {
        orderService.findById(1);



        return "/";
    }
}
