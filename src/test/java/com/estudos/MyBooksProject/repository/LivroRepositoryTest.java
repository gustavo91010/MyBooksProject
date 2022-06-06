package com.estudos.MyBooksProject.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.estudos.MyBooksProject.builder.LivroBuilder;
import com.estudos.MyBooksProject.entity.Livro;


@DataJpaTest
//@SpringBootTest
public class LivroRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private LivroRepository repository;
//	8:18
	@Test
	public void deveEncontrarLivrosPeloAutor() {
		LivroBuilder lb= new LivroBuilder();
		
		entityManager.persist(lb.umLivro(1));
		entityManager.persist(lb.umLivro(2));
		entityManager.persist(lb.umLivro(3));
	
		
		List<Livro> livros= repository.findByTitulo("1");
		
		Assert.assertEquals(1, livros.size());
	}

}
