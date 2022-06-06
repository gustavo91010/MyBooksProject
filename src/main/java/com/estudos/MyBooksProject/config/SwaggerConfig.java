package com.estudos.MyBooksProject.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//	http://localhost:8080/swagger-ui.html

		
		@Bean
		public Docket api() {
			
			
			
		
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.estudos.MyBooksProject"))
					.paths(PathSelectors.any())
					.build()
					.apiInfo(apiInfo());
		}

		private ApiInfo apiInfo() {
			String title= "My Books Aplications";
			String description= "Uma aplicação para registro e controle de livros";
			String version= "V2";

			Contact contato=   new Contact("Gustavo Paes", "Site legal", "gustavo910@gmail.com");
			ApiInfo apiInfo= new ApiInfo(""
					+title,
					description,
					version,
					null,
					contato,
					"lembro nao",
					"nem desse|",
					Collections.emptyList());
			return apiInfo;
		}
	
}
