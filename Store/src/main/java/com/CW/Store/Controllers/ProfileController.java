package com.CW.Store.Controllers;

import com.CW.Store.Entity.UserEntity;
import com.CW.Store.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ProfileController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public String ShowProfile(@AuthenticationPrincipal UserDetails loggedUser, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = loggedUser.getUsername();
        Optional<UserEntity> users = userRepository.findByUsername(currentPrincipalName);
        ArrayList<UserEntity> res = new ArrayList<>();

        users.ifPresent(res::add);
        model.addAttribute("users", res);

        return "profile";
    }
    @GetMapping("/profile/orders")
    public String ShowOrders(Model model){
        return "profile-orders";
    }

    @GetMapping("profile/edit/{id}")
    public String ProductEdit( @PathVariable(value = "id")int id,Model model ){
        if(!userRepository.existsById(id)){
            return "redirect:/";
        }
        Optional<UserEntity> user = userRepository.findById(id);
        ArrayList<UserEntity> res = new ArrayList<>();
        user.ifPresent(res::add);
        model.addAttribute("user", res);
        return "profile-edit";
    }

    @PostMapping("/profile/edit/{id}")
    public String EditUserInformation(@PathVariable(value ="id")int id,
                                      @RequestParam String address,
                                      @RequestParam String name,
                                      @RequestParam String surname,
                                      @RequestParam int postCode,
                                    Model model){
        UserEntity user = userRepository.findById(id).orElseThrow();
        user.setAddress(address);
        user.setName(name);
        user.setSurname(surname);
        user.setPostCode(postCode);
        userRepository.save(user);
        return "redirect:/profile/";
    }
}
