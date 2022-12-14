package com.CW.Store.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorizationController {
    @GetMapping ("/authorization")
    public String AuthorizationMain(Model model){
        return "authorization";
    }

}
