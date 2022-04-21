package com.example.demo;

import com.example.demo.entities.Plan;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.services.PlanService;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*@Bean
	CommandLineRunner runner(ProductService productService, PlanService planService, UserService userService) {
		return args -> {

			Product product = Product.builder()
					.id(45)
					.name("mhhm")
					.caloric(5645.5)
					.weight(34.4)
					.build();

			productService.save(product);
			//productService.deleteById();

			Plan plan = Plan.builder()
					.id(39)
					.build();

			planService.save(plan);

			User user = User.builder()
					.id(44)
					.name_us("alla")
					.gender("f")
					.privilege(false)
					.plan(plan)
					.build();

			userService.save(user);
		};

	}*/
}
