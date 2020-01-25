package com.sp.controllers;

import com.sp.entities.User;
import com.sp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/log")
    public String logo(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "log";
    }
}

