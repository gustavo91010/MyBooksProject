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
import com.estudos.MyBooksProject.service.LivroServiceVO;


@RestController
@RequestMapping("/LivroVO")
public class LivroControllerVO {
	
	@Autowired
	private LivroServiceVO service;
	private LivroVO LivroVO;

	@RequestMapping(method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LivroVO create(@RequestBody LivroVO LivroVO) {
		return service.create(LivroVO);
	}
	@RequestMapping(value = "/{id}",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LivroVO findById(@PathVariable("id") long id) {
		return service.findById(id);

	}
	
	@RequestMapping(method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LivroVO> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LivroVO update(@RequestBody LivroVO LivroVO) {
//		 livro= LivroVO;
		return service.update(LivroVO);
	}

	@RequestMapping(value = "/delete/{id}",
			method = RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LivroVO delete(@PathVariable("id") long id) {
		LivroVO= service.delete(id);
		return LivroVO;
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
