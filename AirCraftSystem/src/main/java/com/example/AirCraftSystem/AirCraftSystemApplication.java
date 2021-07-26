package com.example.AirCraftSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com.example.AirCraftSystem.controller")
public class AirCraftSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirCraftSystemApplication.class, args);
	}

}
