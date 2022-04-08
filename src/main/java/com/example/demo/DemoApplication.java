package com.example.demo;

import com.example.demo.entities.Plan;
import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;
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
	CommandLineRunner runner(ProductService productService) {
		return args -> {

			Product product = Product.builder()
					.id(34)
					.name("mmfffm")
					.caloric(5645.5)
					.weight(34.4)
					.build();

			//productService.save(product);
			productService.deleteById(7);

		};
	}
}
