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
}
