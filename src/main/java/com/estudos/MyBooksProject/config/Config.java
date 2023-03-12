package com.estudos.MyBooksProject.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.estudos.MyBooksProject.utils.converter.YanJacksonHttpMessageConverter;


@Configuration
//@EnableWebMvc
public class Config implements WebMvcConfigurer {

	private static final MediaType MEDIA_TYPE_YML= MediaType.valueOf("application/x-yaml");
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer
		 .favorPathExtension(false)
		 .favorParameter(false)
		 .ignoreAcceptHeader(true)
		 .useRegisteredExtensionsOnly(false)
		 .defaultContentType(MediaType.APPLICATION_JSON)
		 .mediaType("json", MediaType.APPLICATION_JSON)
		 .mediaType("x-yml",MEDIA_TYPE_YML); // se for para yml
	}
	

public void extendMessageConverters( List<HttpMessageConverter<?>> converters) {
		converters.add(new YanJacksonHttpMessageConverter());
	}

}
