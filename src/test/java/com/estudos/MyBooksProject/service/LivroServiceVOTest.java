package com.estudos.MyBooksProject.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.estudos.MyBooksProject.api.LivroVO;
import com.estudos.MyBooksProject.api.exceptions.IsbnExceptions;
import com.estudos.MyBooksProject.api.exceptions.LivroSemPaginaException;
import com.estudos.MyBooksProject.database.repository.LivroRepository;
import com.estudos.MyBooksProject.domain.entity.Livro;
import com.estudos.MyBooksProject.domain.service.LivroService;
import com.estudos.MyBooksProject.utils.builder.LivroBuilder;

public class LivroServiceVOTest {
	@InjectMocks
	private LivroService service = new LivroService();
	@Mock
	private LivroRepository repository;
	@Before
	 void before() {
		MockitoAnnotations.initMocks(this);

	}

//	@Rule
//	public ExpectedException exception = ExpectedException.none();

	@Test(expected = IsbnExceptions.class) // Minha espectativa é que essa classe de erro seja chamada
	 void naoDeveSalvarObjetoSeOIsbnTiverLetras() throws Exception {

		
		LivroVO livroVO=umLivro();
		String isbnLetras = "isbn567890";
//		String isbnLetras = "1234567890";
		livroVO.setIsbn(isbnLetras);
		Livro livro= new Livro(livroVO);
		
		Mockito.when(repository.save(livro )).thenReturn(livro);
//		Mockito.when(service.create(livroVO)).thenReturn(livroVO);
		
		service.create(livroVO);

	}

	@Test(expected = IsbnExceptions.class)
	 void isbnNaoDeveTerMenosDeDezDigitos() throws Exception {

		
		String noveDigitos = "123456789";
		
		LivroVO livroVO=umLivro();
		livroVO.setIsbn(noveDigitos);
		Livro livro= new Livro(livroVO);
		
		Mockito.when(repository.save(livro )).thenReturn(livro);
//		Mockito.when(service.create(livroVO)).thenReturn(livroVO);
		
		
		service.create(livroVO);
	}

	@Test(expected = IsbnExceptions.class)
	 void isbnNaoDeveTerMaisQueTrezeDigitos() throws Exception {

		// Cenario:
		String quatorzeDigitos = "12345678901234";
		LivroVO livroVO=umLivro();
		livroVO.setIsbn(quatorzeDigitos);
		Mockito.when(service.create(livroVO)).thenReturn(livroVO);
		service.create(livroVO);
		

	}

	@Test(expected = LivroSemPaginaException.class)
	 void deveTerMasQueZeroPaginas() throws Exception {
		// cenario:
		LivroVO livroVO=umLivro();
		livroVO.setPaginas(-6);
		
		Mockito.when(service.create(livroVO)).thenReturn(livroVO);
		service.create(livroVO);
		
		

	}

	LivroVO umLivro() {
		LivroBuilder builder = new LivroBuilder();
		return builder.umLivroVO(1);
	}

	List<LivroVO> listaLivros(int quantidade) {
		LivroBuilder builder = new LivroBuilder();
		List<LivroVO> livros = new ArrayList<>();
		for (int i = 0; i < quantidade; i++) {

			livros.add(builder.umLivroVO(i));

		}
		return livros;
	}
//	private LivroVO livroVO = new LivroVO();
//	private LivroServiceVO service = new LivroServiceVO();
//	private LivroBuilder builder = new LivroBuilder();
//	
//	@Rule
//	public ExpectedException exception = ExpectedException.none();
//	
//	
//	@Test(expected = IsbnExceptions.class) // Minha espectativa é que essa classe de erro seja chamada
//	public void naoDeveSalvarObjetoSeOIsbnTiverLetras() throws Exception {
//		
//		// Cenario:
//		String isbnLetras = "isbn567890";
////		String isbnLetras = "3456567890";
//		livroVO = builder.umLivroVO(1985);
//		livroVO.setIsbn(isbnLetras);
////		ValidacaoNovoLivro validar;
//		
//		// Ação:
////		service.create(livroVO);
//		service.create(livroVO);
//		
//	}
//	
//	@Test(expected = IsbnExceptions.class)
//	public void isbnNaoDeveTerMenosDeDezDigitos() throws Exception {
//		
//		// Cenario:
//		LivroVO l2= new LivroVO();
//		String noveDigitos = "123456789";
//		l2 = builder.umLivroVO(1985);
//		l2.setIsbn(noveDigitos);
//		System.out.println("\nlivro antes "+l2.toString()+"\n");
//		
//		// Ação:
////		service.create(livroVO);
//		service.create(l2);
//		
//		System.out.println("\nlivro depois... "+l2.toString()+"\n");
//	}
//	
//	@Test(expected = IsbnExceptions.class)
//	public void isbnNaoDeveTerMaisQueTrezeDigitos() throws Exception {
//		
//		// Cenario:
//		String quatorzeDigitos = "12345678901234";
//		
//		livroVO = builder.umLivroVO(1985);
//		livroVO.setIsbn(quatorzeDigitos);
//		
//		// Ação:
////		service.create(livroVO);
//		service.create(livroVO);
//		
//	}
//	
//	@Test(expected = LivroSemPaginaException.class)
//	public void deveTerMasQueZeroPaginas() throws IsbnExceptions, LivroSemPaginaException {
//		// cenario:
//		
//		livroVO = builder.livroSemPaginaVO();
//		
//		// Ação:
//		
////		Assert.assertEquals(service.create(livroVO), null);
////		Assert.assertEquals(service.create(livroVO);
//		
//		
//	}

}
