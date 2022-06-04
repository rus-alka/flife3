package com.example.demo.controllers;

import com.example.demo.entities.Plan;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@RequestParam String name_us, @RequestParam String email_us,
                               @RequestParam String password_us, @RequestParam Double weight, @RequestParam Double height,
                               @RequestParam String phone_number,
                               @RequestParam String gender, Model model) {
        User user = new User(name_us, email_us, password_us, weight, height, phone_number, gender);
        userService.save(user);
        return "redirect:/home";
    }

    @RequestMapping("/profile")
    public String profile(Model model) {
        //model.addAttribute("registration", "Registration");
        return "profile";
    }
}