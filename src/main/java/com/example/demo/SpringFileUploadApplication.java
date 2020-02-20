package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringFileUploadApplication {

	
	private int max_size_file=5 *1024 *1024; // 5 MB
	
	public static void main(String[] args) {
		SpringApplication.run(SpringFileUploadApplication.class, args);
	}
	
	

	 
	

}
