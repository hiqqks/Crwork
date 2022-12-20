package com.CW.Store.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsAdministrationController {

    @GetMapping("/admin-panel/products")
    public String ShowShowAdminPanel(Model model){
        return "admin-panel-products";
    }
}
