package com.estudos.MyBooksProject.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.estudos.MyBooksProject.builder.LivroBuilder;
import com.estudos.MyBooksProject.converter.DozerConverter;
import com.estudos.MyBooksProject.entity.Livro;
import com.estudos.MyBooksProject.entity.LivroVO;
import com.estudos.MyBooksProject.repository.LivroRepository;


@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class LivroServiceVOTest {
	private LivroBuilder lb= new LivroBuilder();
	private LivroVO livroVOTest= DozerConverter.parseObject(lb.umLivro(3), LivroVO.class);

	@Autowired
	private LivroServiceVO service;
	@Autowired
	private LivroRepository repository;
	
	@Test
	public void deveCriarUmLivroNovo(){
		
		// Cenario:
	List<LivroVO> primeiraChamada=	service.findAll();
	int primeiraQnt= primeiraChamada.size();
	
	 service.create(livroVOTest);	
	
	List<LivroVO> segundaChamada=	service.findAll();
	int segundaQnt = segundaChamada.size();
	
	// Verificação:
	
	Assert.assertEquals(primeiraQnt+1, segundaQnt);
	
	
		
	}
	
	
	@Test
	public void buscarLivroPorIdTest() {
		// Cenario:
	LivroVO livro= service.findById(4);
	Assert.assertEquals("Narnia", livro.getTitulo());
	Assert.assertEquals(" Crista", livro.getCategoria());
	Assert.assertEquals("C. S. Lewis", livro.getAutor());
		
	}
	@Test
	public void buscarLivroPorAutorTest() {
		// Cenario:
		List<LivroVO> livros= service.findByAutor("Autor: 3");
		int autorQnt=0;
		
		for(LivroVO autor: livros) {
			if(autor.getAutor().equals("Autor: 3")) {
				autorQnt++;
			}
		}
		Assert.assertEquals(livros.size(), autorQnt);
		
		
	}
	@Test
	public void buscarLivroPorTituloTest() {

		List<LivroVO> titulos= service.findByTitulo("Titulo: 3");
		
		int tituloQnt=0;
		
		for(LivroVO titulo: titulos) {
			if(titulo.getTitulo().equals("Titulo: 3")) {
				tituloQnt++;
			}
		}
		Assert.assertEquals(titulos.size(), tituloQnt);
		
	}
	
	@Test
	public void deletarPorId() {
//		String sql="SELECT MAX(ID) FROM mybooksproject.livros";
		List<LivroVO> consulta=	service.findAll();

	boolean livroDeletado= service.delete( 1011 ) != null;	
	
	Assert.assertTrue(livroDeletado);
		
		
	
}
}
