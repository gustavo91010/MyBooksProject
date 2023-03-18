package com.estudos.MyBooksProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class MyBooksProjectApplication {
//	http://localhost:8080/swagger-ui.html#/livro-controller-vo

	public static void main(String[] args) {
		SpringApplication.run(MyBooksProjectApplication.class, args);
		
		System.err.println("\nfoi!, vai!!");
//		trabalhar na criaççao da classe estante
	}

}
