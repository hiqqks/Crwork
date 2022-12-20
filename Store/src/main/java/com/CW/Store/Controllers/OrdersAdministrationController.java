package com.CW.Store.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersAdministrationController {
    @GetMapping("/admin-panel/orders")
    public String ShowShowAdminPanel(Model model){
        return "admin-panel-orders";
    }

}
