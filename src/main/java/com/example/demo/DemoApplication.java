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

	@Bean
	CommandLineRunner runner(ProductService productService, PlanService planService, UserService userService) {
		return args -> {

			Plan plan = Plan.builder()
					.id(6)
					.build();

			planService.save(plan);


			/*User user = User.builder()
					.name_us("Алла")
					.email_us("alla@gmail.com")
					.password_us("dddddd")
					.weight(60.2)
					.height(172.0)
					.phone_number("89277231825")
					.gender("1")
					.plan(plan)
					.build();

			userService.save(user);*/

			};
	}
}
