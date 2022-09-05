package com.estudos.MyBooksProject.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.estudos.MyBooksProject.converter.DozerConverter;
import com.estudos.MyBooksProject.entity.LivroVO;
import com.estudos.MyBooksProject.exceptions.IsbnExceptions;
import com.estudos.MyBooksProject.exceptions.LivroSemPaginaException;
import com.estudos.MyBooksProject.service.LivroServiceVO;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/livro/v2")
public class LivroControllerVO {

	@Autowired
	private LivroServiceVO service;

	

	@Autowired
	private PagedResourcesAssembler<LivroVO> assembler;
	
	@ApiOperation(value = "Salva um novo livro do banco de dados" )
	@PostMapping(produces = { "application/json", "application/xml","application/x-yaml"},
				 consumes = { "application/json", "application/xml","application/x-yaml"})
	public ResponseEntity<LivroVO>  create(@RequestBody LivroVO LivroVO, UriComponentsBuilder uriBuilder) throws IsbnExceptions, LivroSemPaginaException {
		 service.create(LivroVO);
		 
//		 URI uri= uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
//		 return ResponseEntity.created(uri).body(new TopicoDto(topico));
		URI uri=uriBuilder.path("/api/livro/v2/{id}").buildAndExpand(LivroVO).toUri();
		return ResponseEntity.created(uri).body(new LivroVO());
	}
	
	
	
	@ApiOperation(value = "Encontra livro pelo id de registro" )
	@GetMapping(value ="/{id}", produces = { "application/json", "application/xml","application/x-yaml"})
	public LivroVO findById(@PathVariable("id") long id) {
		LivroVO livroVO= service.findById(id);
		livroVO.add(linkTo( methodOn(LivroControllerVO.class)
				.findById(id)).withSelfRel() );
				 return livroVO;
	}
	
	@ApiOperation(value = "Encontra livro pelo titulo " )
	@GetMapping(value ="/titulo/{titulo}", produces = { "application/json", "application/xml","application/x-yaml"})
	public List<LivroVO> findByTitulo(@PathVariable("titulo") String titulo) {
		List<LivroVO> livrosVO= service.findByTitulo(titulo);
		
		for(int i= 0; i<livrosVO.size(); i++) {
			
			livrosVO.get(i).add(linkTo( methodOn(LivroControllerVO.class)
					.findByTitulo(titulo)).withSelfRel() );
		}
		
		return livrosVO;
	}
	@ApiOperation(value = "Encontra livro pelo autor " )
	@GetMapping(value ="/autor/{autor}", produces = { "application/json", "application/xml","application/x-yaml"})
	public List<LivroVO> findByAutor(@PathVariable("autor") String autor) {
		List<LivroVO> livrosVO= service.findByAutor(autor);
		
		for(int i= 0; i<livrosVO.size(); i++) {
			
		livrosVO.get(i).add(linkTo( methodOn(LivroControllerVO.class)
				.findByAutor(autor)).withSelfRel() );
		}
		
		return livrosVO;
	}
	
	@ApiOperation(value = "Chama todos os livros registrados" )
	@GetMapping(produces = { "application/json", "application/xml","application/x-yaml"})
	public ResponseEntity<?> findAll(
								 @RequestParam(value = "page", defaultValue = "0")  int page,
								 @RequestParam(value= "limit", defaultValue = "10")int limit,
								 @RequestParam(value= "direction", defaultValue = "asc") String diretion) {
		Direction sorDirection= "desc".equalsIgnoreCase(diretion)? Direction.DESC : Direction.ASC;
		Pageable pageable= PageRequest.of(page, limit, Sort.by(sorDirection, "titulo"));
		Page<LivroVO> livrosVO= service.findAll(pageable);
		
		livrosVO.stream()
		.forEach(l -> l.add( linkTo(methodOn(LivroControllerVO.class)
				.findById(l.getKey() )).withSelfRel()));
			
		PagedResources<?> resource= assembler.toResource(livrosVO);		
		return new ResponseEntity<>(resource, HttpStatus.OK);
		
		
//				 http://localhost:8080/api/livro/v2?page=2&limit=3
//				 http://localhost:8080/api/livro/v2?page=2&limit=3&direction=desc
	}


	@ApiOperation(value = "Faz a alteração em algum campo do livro registrado" )
	@PutMapping(produces = { "application/json", "application/xml","application/x-yaml"},
				consumes = { "application/json", "application/xml","application/x-yaml"})
	public LivroVO update(@RequestBody LivroVO LivroVO) {
		return service.update(LivroVO);
	}

	@ApiOperation(value = "Exclui o livro do registro" )
	@DeleteMapping("/{id}")
	public LivroVO delete(@PathVariable("id") long id) {
		LivroVO livroVO = DozerConverter.parseObject(service.delete(id), LivroVO.class);
		
		return livroVO;
		
	}

}
