package com.CW.Store.Controllers;


import com.CW.Store.service.ClothingService;
import com.CW.Store.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShoppingCartController {


    private final ShoppingCartService shoppingCartService;
    private final ClothingService clothingService;
@Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, ClothingService clothingService) {
        this.shoppingCartService = shoppingCartService;
        this.clothingService = clothingService;
    }

    @GetMapping("/shoppingCart/")

    public String  shoppingCart(Model model){
        model.addAttribute("clothing", shoppingCartService.getProductsInCart());
        model.addAttribute("total", shoppingCartService.getTotal());
        return "shoppingCart";
    }

    @GetMapping("/shoppingCart/addProduct/{ClothingID}")
    public String addProductToCart(@PathVariable("ClothingID") long ClothingID) {
    clothingService.findById(ClothingID).ifPresent(shoppingCartService::addProduct);
        return "redirect:/";
    }

    @GetMapping("/shoppingCart/removeProduct/{ClothingID}")
    public String removeProductFromCart(@PathVariable("ClothingID") long ClothingID) {
        clothingService.findById(ClothingID).ifPresent(shoppingCartService::removeProduct);
        return "redirect:/shoppingCart/";
    }

}
