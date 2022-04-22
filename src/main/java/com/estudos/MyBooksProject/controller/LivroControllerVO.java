package com.estudos.MyBooksProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.MyBooksProject.entity.LivroVO;
import com.estudos.MyBooksProject.entity.LivroVOV2;
import com.estudos.MyBooksProject.service.LivroServiceVO;

@RestController
@RequestMapping("/livroVO")
public class LivroControllerVO {

	@Autowired
	private LivroServiceVO service;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public LivroVO create(@RequestBody LivroVO LivroVO) {
		return service.create(LivroVO);
	}
	
	@RequestMapping(value = "/v2",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public LivroVOV2 createV2(@RequestBody LivroVOV2 livroVOV2) {
		return service.createV2(livroVOV2);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public LivroVO findById(@PathVariable("id") long id) {
		return service.findById(id);

	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LivroVO> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public LivroVO update(@RequestBody LivroVO LivroVO) {
//		 livro= LivroVO;
		return service.update(LivroVO);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public LivroVO delete(@PathVariable("id") long id) {
		LivroVO livroVO = service.delete(id);
		return livroVO;
	}
//	@RequestMapping(value = "/title/{title}",
//			
//			method = RequestMethod.GET,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	public LivroVO findByTitle(@PathVariable("titulo") String titulo) {
//		LivroVO=service.findByTitle(titulo);
//		return LivroVO;
//	}

}
