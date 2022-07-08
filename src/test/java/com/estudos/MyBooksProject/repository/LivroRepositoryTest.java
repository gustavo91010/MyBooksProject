package com.estudos.MyBooksProject.repository;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import com.estudos.MyBooksProject.builder.LivroBuilder;
import com.estudos.MyBooksProject.controller.LivroController;
import com.estudos.MyBooksProject.entity.Livro;
import com.estudos.MyBooksProject.entity.LivroVO;
import com.estudos.MyBooksProject.exceptions.IsbnExceptions;
import com.estudos.MyBooksProject.exceptions.LivroSemPaginaException;
import com.estudos.MyBooksProject.service.LivroServiceVO;

@RunWith(SpringRunner.class)
@DataJpaTest // anotação para criar  tests no repository
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test") 

public class LivroRepositoryTest {
	
	private LivroBuilder builder = new LivroBuilder();
	private LivroVO livroVO = new LivroVO();
	private LivroServiceVO service = new LivroServiceVO();
	@Autowired
	private LivroRepository repository;
	@Autowired
	private EntityManager em;
	private Livro livro;

	@Before
	public void before() {
		livroVO = builder.umLivroVO(1);
		livro= builder.umLivro(1);

	}

	@After
	public void after() {

	}

	@Test
	public void deveSalvarUmLivro() throws IsbnExceptions, LivroSemPaginaException {

//		em.persist(livro);
//		List<Livro> teste2= repository.findByTitulo(livro.getTitulo());
//		System.out.println(livro.getTitulo()+ teste2.size());
//		Assert.assertNotNull(teste2);
		
		
		em.persist(livroVO);
		LivroVO lv= (LivroVO) repository.findByAutor(livroVO.getAutor());
		Assert.assertNotNull(lv);
		
		
		
		//		// Cenario:
//
//		List<LivroVO> antes = service.findAll();
//		System.out.println("antes: " + antes.size());
//
//		// Ação:
//		service.create(livroVO);
//		List<LivroVO> depois = service.findAll();
//		System.out.println("depois: " + depois.size());
//
//		// Verificação:
//		Assert.assertEquals((antes.size() + 1), depois.size());

	}
	
//	@Test
	public void deveEncontarLivroPeloId() throws IsbnExceptions, LivroSemPaginaException {
		service.create(livroVO);
	LivroVO lt=	service.findById(livroVO.getKey());
		
		assertEquals("Autor: 1777",lt.getAutor() );
		
		
//		service.findById(0)
		
	}

}
