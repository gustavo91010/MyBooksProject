package com.estudos.MyBooksProject.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.estudos.MyBooksProject.entity.Livro;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class LivroRepositoryTest {
	
	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private TestEntityManager em;

	
	@Test
	public void deveriaEncontrarUmLivroPeloAutor() {
		Livro livroVO= new Livro();
		livroVO.setAutor("teste234");
		em.persist(livroVO);
		
		String autor=livroVO.getAutor();
		
		List<Livro> lovrp= repository.findByAutor(autor);
		
		Assert.assertNotNull(lovrp);
//		Assert.assertEquals(1, lovrp.size());
		Assert.assertEquals("teste234", lovrp.get(0).getAutor());
	}

}
