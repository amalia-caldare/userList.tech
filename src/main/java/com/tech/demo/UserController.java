package com.tech.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

     private UserRepository user;

     public UserController(UserRepository user) {
         this.user=user;
     }

     @GetMapping("/")
     public String allUsers(Model model) {

         List<User> userList = user.findAll();

        model.addAttribute("users", userList);
         return "index";
     }

     @GetMapping("/add")
    public String addUser(Model model) {
         model.addAttribute("user", new User());
         return "add-user";
     }

     @PostMapping("/save")
    public String saveUser(@ModelAttribute User newUser){
         user.save(newUser);
         return "redirect:/";

     }

    }
