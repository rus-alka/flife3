package com.example.demo.controllers;

import com.example.demo.entities.Exercise;
import com.example.demo.entities.Plan;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.repositories.ExerciseRepository;
import com.example.demo.repositories.PlanRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.PlanService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private PlanService planService;

    @RequestMapping(value = "/products/{userId}", method = RequestMethod.GET)
    public String productsGet(@PathVariable(value="userId") Integer id,
                           Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);

        model.addAttribute("userId", id);
        return "products";
    }

    @RequestMapping(value ="/products/{userId}/{idProduct}", method = RequestMethod.POST)
    public String productsPost(@PathVariable(value="userId") Integer id, @PathVariable(value="idProduct") Integer idProduct,
                        @RequestParam Double weight,
                        Model model) {
        Plan plan = planRepository.getPlan(id-1);
        Product product = productRepository.findById(idProduct).get();

        plan.setPlusCaloric(product.getCaloric()*weight+plan.getPlusCaloric());
        plan.setPlusProtein(product.getProtein()*weight+plan.getPlusProtein());
        plan.setPlusFat(product.getFat()*weight+plan.getPlusFat());
        plan.setPlusCarbohydrates(product.getCarbohydrates()*weight+plan.getPlusCarbohydrates());

        planService.save(plan);
        System.out.println(id.getClass());

        return "redirect:/home/"+id;
    }

    @RequestMapping(value = "/exercises/{userId}", method = RequestMethod.GET)
    public String exercisesGet(@PathVariable(value="userId") Integer id,
                       Model model) {
        Iterable<Exercise> exercises = exerciseRepository.findAll();
        model.addAttribute("exercises", exercises);

        model.addAttribute("userId", id);
        return "exercises";
    }

    @RequestMapping(value ="/exercises/{userId}/{idExercise}", method = RequestMethod.POST)
    public String exercisePost(@PathVariable(value="userId") Integer id, @PathVariable(value="idExercise") Integer idExercise,
                          Model model) {
        Plan plan = planRepository.getPlan(id-1);
        Exercise exercise = exerciseRepository.findById(idExercise).get();

        plan.setMinusCaloric(exercise.getEnergy_consumption()*exercise.getDuration()+plan.getMinusCaloric());
        //plan.setMinusProtein(exercise.getProtein()*weight+plan.getMinusProtein());
        //plan.setMinusFat(exercise.getFat()*weight+plan.getMinusFat());
        //plan.setMinusCarbohydrates(exercise.getCarbohydrates()*weight+plan.getMinusCarbohydrates());

        planService.save(plan);
        System.out.println(id.getClass());

        return "redirect:/home/"+id;
    }

    @RequestMapping(value = "/home/{id}", method = RequestMethod.GET)
    public String homeGet(@PathVariable(value="id") Integer id,
                        Model model) {
        Plan plan = planRepository.getPlan(id-1);
        Double plusCaloric = plan.getPlusCaloric();
        Double plusProtein = plan.getPlusProtein();
        Double plusFat = plan.getPlusFat();
        Double plusCarbohydrates = plan.getPlusCarbohydrates();

        Double minusCaloric = plan.getMinusCaloric();

        model.addAttribute("plusCaloric",plusCaloric);
        model.addAttribute("plusProtein",plusProtein);
        model.addAttribute("plusFat",plusFat);
        model.addAttribute("plusCarbohydrates",plusCarbohydrates);

        model.addAttribute("minusCaloric", minusCaloric);
        model.addAttribute("userId",id);

        return "home";
    }

    @RequestMapping(value = "/home/{id}", method = RequestMethod.POST)
    public String homePost(@PathVariable(value="id") Integer id,
                          Model model) {
        model.addAttribute("userId",id);

        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(@RequestParam String email, @RequestParam String password, Model model) {
        Integer userId = userService.findByEmail(email).get().getId();
        int check = userService.canLogin(userId,password);
        //System.out.println(userId.getClass());
        if (check==2)
            return "redirect:/admin_home/" + userId;
        else if (check == 0)
            return "redirect:/login";

        return "redirect:/home/" + userId;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String PostRegistration(@RequestParam String name_us, @RequestParam String email_us, @RequestParam String password,
                               @RequestParam Double weight, @RequestParam Double height,
                               @RequestParam String phone_number, @RequestParam String gender, Model model) {
        System.out.println(password);

        User user = new User(name_us, gender, height, weight, phone_number, email_us, password);
        Plan plan = new Plan(user.getId()-1);
        userService.save(user);
        planService.save(plan);
        return "redirect:/home/"+ user.getId() + "/" + password;
    }

    @RequestMapping("/profile")
    public String profile(Model model) {
        //model.addAttribute("registration", "Registration");
        return "profile";
    }
}
