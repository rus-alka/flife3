package com.example.demo.controllers;

import com.example.demo.entities.Exercise;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.repositories.ExerciseRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ExerciseService;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ExerciseService exerciseService;

    @RequestMapping("/admin")
    public String admin_home(Model model) {
        return "admin_home";
    }

    @GetMapping("/admin/products")
    public String admin_products(/*@RequestParam("weight") Double weight,*/ Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "admin_products";
    }

    @RequestMapping(value = "/admin/products", method = RequestMethod.POST)
    public String admin_products(@RequestParam String name, @RequestParam Double caloric,
                                 @RequestParam Double protein, @RequestParam Double fat,
                                 @RequestParam Double carbohydrates, @RequestParam String image_product, Model model) {
        Product product = new Product(name, caloric, protein, fat, carbohydrates, image_product);
        productService.save(product);
        return "redirect:/admin";
    }

    @GetMapping("/admin/exercises")
    public String admin_exercises(Model model) {
        Iterable<Exercise> exercises = exerciseRepository.findAll();
        model.addAttribute("exercises", exercises);
        return "admin_exercises";
    }

    @RequestMapping(value = "/admin/exercises", method = RequestMethod.POST)
    public String admin_exercises(@RequestParam String name, @RequestParam Double energy_consumption,
                                  @RequestParam Integer duration, @RequestParam String image_exercise, Model model) {
        Exercise exercise = new Exercise(name, energy_consumption, duration, image_exercise);
        exerciseService.save(exercise);
        return "redirect:/admin";
    }

}
