package com.example.demo.controllers;

import com.example.demo.entities.Exercise;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.repositories.ExerciseRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;

    private ProductService productService;

    @RequestMapping("/home")
    public String home(Model model) {
        return "home";
    }


    /*@RequestMapping("/")
    public String login(Model model){
        model.addAttribute("title", "Главная страница");
        return "login";
    }*/

    @RequestMapping("/products")
    public String products(Model model) {
        //Iterable<Product> products = productRepository.findAll();
        //model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping("/exercises")
    public String exercises(Model model) {
        //model.addAttribute("exercises", "Exercises");
        return "exercises";
    }

    @RequestMapping(value = "/**")
    public String error(){
        return "not-found";
    }

    /*@RequestMapping("/registration.html")
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") User userDto,
            HttpServletRequest request,
            Errors errors) {

        try {
            User registered = userService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistException uaeEx) {
            mav.addObject("message", "An account for that username/email already exists.");
            return mav;
        }

        // rest of the implementation
    }*/
}