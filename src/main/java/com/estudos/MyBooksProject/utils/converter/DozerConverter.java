package com.estudos.MyBooksProject.utils.converter;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerConverter {
	private static Mapper mapper= DozerBeanMapperBuilder.buildDefault();
	
	// para fazer a conversão de um objeto em outro
	
	public static <O, D> D parseObject( O origem, Class<D> destino) {
		
		return mapper.map(origem, destino);
	}

	public static <O, D> List<D> parseListObjects(List<O> origem, Class<D> destino) {
		List<D> destinoObject= new ArrayList<D>();
		for (Object item : origem) {
			destinoObject.add( mapper.map(item, destino) );
			
		}
		return destinoObject;
	}

}