package com.example.bhisma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@ComponentScan(" com.example.bhisma.repository")
public class BhismaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BhismaApplication.class, args);
		System.out.println("The application is running perfectly fine! Hurry!");
	}
}