package com.wad.firstmvc.controllers;

import com.wad.firstmvc.domain.Product;
import com.wad.firstmvc.domain.User;
import com.wad.firstmvc.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // -populate the model with the retrieved products!
    // -select the appropriate view (navigation)
    @GetMapping
    public String viewProducts(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/new")
    public String showAddProductForm(Model model) {
        model.addAttribute("user", new User());
        return "addusers";
    }

    @PostMapping("/new")
    public String addProduct(User user) {
        if (user.getId() == null)
            user.setId(new Random().nextLong());
        userService.save(user);
        return "redirect:/users";
    }

}
