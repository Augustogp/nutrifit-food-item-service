package com.augustogp.nutrifit.food_item;

import org.springframework.boot.SpringApplication;

public class TestFoodItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(FoodItemServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
