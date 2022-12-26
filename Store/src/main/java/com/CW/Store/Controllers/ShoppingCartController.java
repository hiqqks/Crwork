package com.CW.Store.Controllers;


import com.CW.Store.Entity.Orders;
import com.CW.Store.Entity.UserEntity;
import com.CW.Store.repo.OrdersRepository;
import com.CW.Store.repo.UserRepository;
import com.CW.Store.service.ClothingService;
import com.CW.Store.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.Optional;

@Controller
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ClothingService clothingService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrdersRepository ordersRepository;
@Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, ClothingService clothingService) {
        this.shoppingCartService = shoppingCartService;
        this.clothingService = clothingService;
    }

    @GetMapping("/shoppingCart")

    public String  shoppingCart(Model model){
        model.addAttribute("clothing", shoppingCartService.getProductsInCart());
        model.addAttribute("total", shoppingCartService.getTotal());
        model.addAttribute("amount", shoppingCartService.getAmountOfItems());


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
        return "redirect:/shoppingCart";
    }

    @GetMapping("/shoppingCart/clear")
    public String clearShoppingCart(){
    shoppingCartService.clearCart();
    return "redirect:/shoppingCart";
    }

    @GetMapping("/shoppingCart/checkout")
    public String saveOrder(@AuthenticationPrincipal UserDetails loggedUser){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = loggedUser.getUsername();
        Optional<UserEntity> users = userRepository.findByUsername(currentPrincipalName);
        Orders order = new Orders();
        order.setCustomerID(users.get().getId());
        order.setDate(new Date());
        order.setAddress(users.get().getAddress());
        order.setFullPrice(shoppingCartService.getTotal());
        order.setAmountItems(shoppingCartService.getAmountOfItems());
       ordersRepository.save(order);
        shoppingCartService.clearCart();
    return "redirect:/";
    }
}
