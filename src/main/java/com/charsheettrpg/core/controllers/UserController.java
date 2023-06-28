package com.charsheettrpg.core.controllers;

import com.charsheettrpg.core.models.User;
import com.charsheettrpg.core.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping(path = "/registration")
    public String createUser(@Valid @ModelAttribute("user") User user,
                             BindingResult result) {
    if (result.hasErrors()) {
        return "registration";
    }
    userService.createNewUser(user);
    return "/main";
    }

}
