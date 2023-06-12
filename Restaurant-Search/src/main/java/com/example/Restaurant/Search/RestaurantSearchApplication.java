package com.example.Restaurant.Search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class RestaurantSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantSearchApplication.class, args);
	}

}
