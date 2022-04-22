package com.estudos.MyBooksProject.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class YanJacksonHttpMessageConverter extends AbstractJackson2HttpMessageConverter{

	public YanJacksonHttpMessageConverter() {
//		super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
		super(new YAMLMapper()
				.setSerializationInclusion(JsonInclude.Include.NON_NULL),
				MediaType.parseMediaType("application/x-yaml"));
	}

}
