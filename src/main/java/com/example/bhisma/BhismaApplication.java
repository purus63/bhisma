package com.example.bhisma;

import com.example.bhisma.model.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BhismaApplication {

	public static void main(String[] args) {

		SpringApplication.run(BhismaApplication.class, args);
		System.out.println("the application is running perfectly fine Hurry:");
		Data data = new Data("Joh Doe", 30);
		System.out.println("Name: " + data.getName() + ", Age: " + data.getAge());
	}


}
