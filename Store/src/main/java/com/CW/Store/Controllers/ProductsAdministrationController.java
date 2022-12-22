package com.CW.Store.Controllers;

import com.CW.Store.Entity.Clothing;
import com.CW.Store.repo.ClothingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ProductsAdministrationController {
    @Autowired
ClothingRepository clothingRepository;
    @GetMapping("/admin-panel/products")
    public String ShowShowAdminPanel(Model model){
        Iterable<Clothing> clothing = clothingRepository.findAll();
        model.addAttribute("clothing", clothing);


        return "admin-panel-products";
    }

    @GetMapping("/admin-panel/products/{ClothingID}/edit")
    public String ProductEdit(@PathVariable(value = "ClothingID")long id, Model model ){
        if(!clothingRepository.existsById(id)){
            return "redirect:/admin-panel/products";
        }
        Optional<Clothing> clothing = clothingRepository.findById(id);
        ArrayList<Clothing> res = new ArrayList<>();
        clothing.ifPresent(res::add);
        model.addAttribute("clothing", res);
        return "admin-panel-product-edit";
    }

    @PostMapping("/admin-panel/products/{ClothingID}/edit")
    public String ProductEditUpdate(@PathVariable(value ="ClothingID")long ClothingID,
                                    @RequestParam String ClothingName,
                                    @RequestParam Double ClothingPrice,
                                    Model model){
        Clothing clothing = clothingRepository.findById(ClothingID).orElseThrow();
        clothing.setClothingName(ClothingName);
        clothing.setClothingPrice(BigDecimal.valueOf(ClothingPrice));
        clothingRepository.save(clothing);
        return "redirect:/admin-panel/products";
    }

}
