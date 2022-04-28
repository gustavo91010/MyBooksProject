package com.estudos.MyBooksProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.MyBooksProject.entity.LivroVO;
import com.estudos.MyBooksProject.service.LivroServiceVO;

import io.swagger.annotations.ApiOperation;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
@RequestMapping("/api/livro/v2")
public class LivroControllerVO {

	@Autowired
	private LivroServiceVO service;
	
	@ApiOperation(value = "Salva um novo livro do banco de dados" )
	@PostMapping(produces = { "application/json", "application/xml","application/x-yaml"},
				 consumes = { "application/json", "application/xml","application/x-yaml"})
	public LivroVO  create(@RequestBody LivroVO LivroVO) {
		return service.create(LivroVO);
	}
	
	@ApiOperation(value = "Encontra livro pelo id de registro" )
	@GetMapping(value ="/{id}", produces = { "application/json", "application/xml","application/x-yaml"})
	public LivroVO findById(@PathVariable("id") long id) {
		LivroVO livroVO= service.findById(id);
		livroVO.add(linkTo( methodOn(LivroControllerVO.class)
				.findById(id)).withSelfRel() );
				 return livroVO;
	}

	@ApiOperation(value = "Chama todos os livros registrados" )
	@GetMapping(produces = { "application/json", "application/xml","application/x-yaml"})
	public List<LivroVO> findAll() {
		List<LivroVO> livrosVO= service.findAll();
		livrosVO.stream()
		.forEach(l -> l.add( linkTo(methodOn(LivroControllerVO.class)
				.findById(l.getKey() )).withSelfRel()));
				 return livrosVO;
	}

	
	@ApiOperation(value = "Faz a alteração em algum campo do lovro registrado" )
	@PutMapping(produces = { "application/json", "application/xml","application/x-yaml"},
				consumes = { "application/json", "application/xml","application/x-yaml"})
	public LivroVO update(@RequestBody LivroVO LivroVO) {
		return service.update(LivroVO);
	}

	@ApiOperation(value = "Exclui o livro do registro" )
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
