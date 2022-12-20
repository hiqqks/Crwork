package com.CW.Store.Controllers;

import com.CW.Store.Entity.UserEntity;
import com.CW.Store.repo.RoleRepository;
import com.CW.Store.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPanelController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @GetMapping("/admin-panel/users")
    public String ShowShowAdminPanel(Model model){
        Iterable<UserEntity> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "admin-panel";
    }

}
