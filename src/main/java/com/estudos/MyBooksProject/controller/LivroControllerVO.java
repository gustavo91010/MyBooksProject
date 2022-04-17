package com.estudos.MyBooksProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.MyBooksProject.entity.LivroVO;
import com.estudos.MyBooksProject.service.LivroServiceVO;

@RestController
@RequestMapping("/livroVO")
public class LivroControllerVO {

	@Autowired
	private LivroServiceVO service;

	@PostMapping
	public LivroVO create(@RequestBody LivroVO LivroVO) {
		return service.create(LivroVO);
	}

	@GetMapping("/{id}")
	public LivroVO findById(@PathVariable("id") long id) {
		return service.findById(id);

	}

	@GetMapping
	public List<LivroVO> findAll() {
		return service.findAll();
	}

	@PutMapping
	public LivroVO update(@RequestBody LivroVO LivroVO) {
		return service.update(LivroVO);
	}

	@DeleteMapping("/{id}")
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
