package com.estudos.MyBooksProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.estudos.MyBooksProject.entity.Livro;
import com.estudos.MyBooksProject.service.LivroService;

//@RestController
//@RequestMapping("/livro")
public class LivroController {

	@Autowired
	private LivroService service;
	private Livro livro;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Livro create(@RequestBody Livro livro) {
		return service.create(livro);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Livro findById(@PathVariable("id") long id) {
		return service.findById(id);

	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Livro> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Livro update(@RequestBody Livro livro) {
		return service.update(livro);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Livro delete(@PathVariable("id") long id) {
		livro = service.delete(id);
		return livro;
	}

	@RequestMapping(value = "/title/{title}",

			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Livro findByTitle(@PathVariable("titulo") String titulo) {
		livro = service.findByTitle(titulo);
		return livro;
	}

}
