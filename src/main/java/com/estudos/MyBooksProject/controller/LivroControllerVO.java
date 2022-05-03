package com.estudos.MyBooksProject.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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

import com.estudos.MyBooksProject.entity.LivroVO;
import com.estudos.MyBooksProject.entity.LivroVOV2;
import com.estudos.MyBooksProject.service.LivroServiceVO;

<<<<<<< HEAD
@RestController
@RequestMapping("/livroVO")
=======
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/livro/v2")
>>>>>>> 040bb186dce3143fdfcf6b8a3405fb49023ee539
public class LivroControllerVO {

	@Autowired
	private LivroServiceVO service;
<<<<<<< HEAD

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public LivroVO create(@RequestBody LivroVO LivroVO) {
		return service.create(LivroVO);
	}
	
	@RequestMapping(value = "/v2",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public LivroVOV2 createV2(@RequestBody LivroVOV2 livroVOV2) {
		return service.createV2(livroVOV2);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
=======
	@Autowired
	private PagedResourcesAssembler<LivroVO> assembler;
	
	@ApiOperation(value = "Salva um novo livro do banco de dados" )
	@PostMapping(produces = { "application/json", "application/xml","application/x-yaml"},
				 consumes = { "application/json", "application/xml","application/x-yaml"})
	public LivroVO  create(@RequestBody LivroVO LivroVO) {
		return service.create(LivroVO);
	}
	
	@ApiOperation(value = "Encontra livro pelo id de registro" )
	@GetMapping(value ="/{id}", produces = { "application/json", "application/xml","application/x-yaml"})
>>>>>>> 040bb186dce3143fdfcf6b8a3405fb49023ee539
	public LivroVO findById(@PathVariable("id") long id) {
		LivroVO livroVO= service.findById(id);
		livroVO.add(linkTo( methodOn(LivroControllerVO.class)
				.findById(id)).withSelfRel() );
				 return livroVO;
	}

	@ApiOperation(value = "Chama todos os livros registrados" )
	@GetMapping(produces = { "application/json", "application/xml","application/x-yaml"})
	public ResponseEntity<?> findAll(
					
								 @RequestParam(value = "page", defaultValue = "0")  int page,
								 @RequestParam(value= "limit", defaultValue = "10")int limit,
								 @RequestParam(value= "direction", defaultValue = "asc") String diretion) {
		
		Direction sorDirection= "desc".equalsIgnoreCase(diretion)? Direction.DESC : Direction.ASC;
		Pageable pageable= PageRequest.of(page, limit, Sort.by(sorDirection, "titulo"));
//		List<LivroVO> livrosVO= service.findAll(pageable).getContent();
//		Livro<LivroVO> livro= service.findAll(pageable);
		Page<LivroVO> livrosVO= service.findAll(pageable);
		
		livrosVO.stream()
		.forEach(l -> l.add( linkTo(methodOn(LivroControllerVO.class)
				.findById(l.getKey() )).withSelfRel()));
			
		PagedResources<?> resource= assembler.toResource(livrosVO);		
		return new ResponseEntity<>(resource, HttpStatus.OK);
		
		
//				 http://localhost:8080/api/livro/v2?page=2&limit=3
//				 http://localhost:8080/api/livro/v2?page=2&limit=3&direction=desc
	}

<<<<<<< HEAD
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LivroVO> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
=======
	
	@ApiOperation(value = "Faz a alteração em algum campo do lovro registrado" )
	@PutMapping(produces = { "application/json", "application/xml","application/x-yaml"},
				consumes = { "application/json", "application/xml","application/x-yaml"})
>>>>>>> 040bb186dce3143fdfcf6b8a3405fb49023ee539
	public LivroVO update(@RequestBody LivroVO LivroVO) {
		return service.update(LivroVO);
	}

<<<<<<< HEAD
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
=======
	@ApiOperation(value = "Exclui o livro do registro" )
	@DeleteMapping("/{id}")
>>>>>>> 040bb186dce3143fdfcf6b8a3405fb49023ee539
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
