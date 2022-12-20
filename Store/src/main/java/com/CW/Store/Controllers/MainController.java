package com.CW.Store.Controllers;


import com.CW.Store.Entity.Clothing;
import com.CW.Store.repo.ClothingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Optional;


@Controller
public class MainController {
    @Autowired
    private ClothingRepository clothingRepository;


    @GetMapping("/")
    public String showClothing(Model model){
        Iterable<Clothing> clothing = clothingRepository.findAll();
        model.addAttribute("clothing", clothing);
                return "home";
    }

    @GetMapping("/product/{ClothingID}")
    public String ProductDetails(@PathVariable(value = "ClothingID") long ClothingID, Model model){
        if(!clothingRepository.existsById(ClothingID)){
            return "redirect:/ ";
        }
        Optional<Clothing> clothing =  clothingRepository.findById(ClothingID);
        ArrayList<Clothing> res = new ArrayList<>();
        clothing.ifPresent(res::add);
        model.addAttribute("clothing", clothing);
        return "productDetails";
    }

    @PostMapping("/add/{ClothingID}")
    public String addToBasket(@PathVariable(value = "ClothingID") long ClothingID, Model model){
        if(!clothingRepository.existsById(ClothingID)){
            return "redirect:/ ";
        }

        return "redirect:/";
    }


}