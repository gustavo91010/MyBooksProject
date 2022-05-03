package com.estudos.MyBooksProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class MyBooksProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBooksProjectApplication.class, args);
		
		System.out.println("\nfoi!, vai!!");
	}

}
