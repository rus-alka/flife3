package com.example.demo.controllers;

import com.example.demo.entities.*;
import com.example.demo.repositories.ExerciseRepository;
import com.example.demo.repositories.ImageRepository;
import com.example.demo.repositories.PlanRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.PlanService;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Controller
public class HomeController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private PlanService planService;

    @GetMapping("/home")
    public String home(/*@RequestParam("weight") Double weight,*/ Model model) {
        Iterable<Plan> plan = planRepository.findAll();
        //узнать ид пользователя-ид плана-нужные поля плана
        Iterable<Product> products = productRepository.findAll();
        double count = 0;
        for(Plan item : plan)
        {
            count +=1;//item.getPlusCaloric()*products.;
        }
        planService.addPlan(count);
        model.addAttribute("caloric", count);

        model.addAttribute("plusCaloric", plan);

        return "home";
    }

    /*@PostMapping("/home")
    public String homePost(Model model, @RequestParam("weight") Double weight) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("weight", weight);
        //planService.addPlan(weight);
        System.out.println("++++++++++++++++++++++++++"+weight);
        return "redirect:/home";
    }*/

    @GetMapping("/products")
    public String products(/*@RequestParam("weight") Double weight,*/ Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/exercises")
    public String exercises(Model model) {
        Iterable<Exercise> exercises = exerciseRepository.findAll();
        model.addAttribute("exercises", exercises);
        return "exercises";
    }

    @PostMapping("/products")
    public String productsPost(@RequestParam("weight") Double weight, Model model) {
        Iterable<Product> products = productRepository.findAll();

        //System.out.println("jjjjj");
        this.planService.addPlan(weight);
        return "redirect:/home";
    }

    /*@PostMapping("/products/add")
    public String add(@RequestParam("plusCaloric") Double plusCaloric,
                      Model model) {
        planService.addPlan(plusCaloric);
        return "redirect:/home";
        //return "redirect:/";
    }*/

    /*@RequestMapping("/exercises")
    public String exercises(Model model) {
        //model.addAttribute("exercises", "Exercises");
        return "exercises";
    }*/

    @RequestMapping(value = "/**")
    public String error(){
        return "not-found";
    }

    @RequestMapping("/removeProduct/{id}")
    public String removeItem(@PathVariable("id") Integer id, HttpServletRequest request) {
        String sessionToken = (String) request.getSession(false).getAttribute("sessionToken");
        planService.removeFromPlan(id,sessionToken);
        return "redirect:/home";
    }
}