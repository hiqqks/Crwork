package com.CW.Store.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasketController {

 /*   @Autowired
    private ClothingRepository clothingRepository;
    @Autowired
    private BasketClothingRepository basketClothingRepository;*/

    @GetMapping("/basket")
    public String ShowBasket(Model model){

        return "basket";
    }
}
