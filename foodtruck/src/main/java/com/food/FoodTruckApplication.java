package com.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FoodTruckApplication {

	public static void main(String[] args) {
		String cwd = System.getProperty("user.dir");
        System.out.println("Current working directory@@@@@@@@@@@@ : " + cwd);
		SpringApplication.run(FoodTruckApplication.class, args);
	}
}
