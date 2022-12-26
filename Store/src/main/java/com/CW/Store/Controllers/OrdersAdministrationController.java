package com.CW.Store.Controllers;

import com.CW.Store.Entity.Orders;
import com.CW.Store.repo.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersAdministrationController {

    @Autowired
    private OrdersRepository ordersRepository;
    @GetMapping("/admin-panel/orders")
    public String ShowShowAdminPanel(Model model){
        Iterable<Orders> order = ordersRepository.findAll();
        model.addAttribute("orders", order);
        return "admin-panel-orders";
    }

}
