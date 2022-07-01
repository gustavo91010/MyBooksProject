package com.estudos.MyBooksProject.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.estudos.MyBooksProject.builder.LivroBuilder;
import com.estudos.MyBooksProject.entity.LivroVO;
import com.estudos.MyBooksProject.exceptions.IsbnExceptions;
import com.estudos.MyBooksProject.exceptions.LivroSemPaginaException;
import static org.hamcrest.CoreMatchers.is;

public class LivroServiceVOTest {
	private LivroVO livroVO = new LivroVO();
	private LivroServiceVO service = new LivroServiceVO();
	private LivroBuilder builder = new LivroBuilder();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void before() {

	}

	@After
	public void after() {

	}

	@Test(expected = IsbnExceptions.class) // Minha espectativa é que essa classe de erro seja chamada
	public void naoDeveSalvarObjetoSeOIsbnTiverLetras() throws Exception {

		// Cenario:
		String isbnLetras = "isbn567890";
		livroVO = builder.umLivroVO(1985);
		livroVO.setIsbn(isbnLetras);

		// Ação:
		service.create(livroVO);

	}

	@Test(expected = IsbnExceptions.class)
	public void isbnNaoDeveTerMenosDeDezDigitos() throws Exception {

		// Cenario:
		String isbnLetras = "123456789";
		livroVO = builder.umLivroVO(1985);
		livroVO.setIsbn(isbnLetras);

		// Ação:
		service.create(livroVO);

	}

	@Test(expected = IsbnExceptions.class)
	public void isbnNaoDeveTerMaisQueTrezeDigitos() throws Exception {

		// Cenario:
		String isbnLetras = "12345678901234";

		livroVO = builder.umLivroVO(1985);
		livroVO.setIsbn(isbnLetras);

		// Ação:
		service.create(livroVO);

	}

	@Test(expected = LivroSemPaginaException.class)
	public void deveTerMasQueZeroPaginas() throws IsbnExceptions, LivroSemPaginaException {
		// cenario:

		livroVO = builder.livroSemPaginaVO();

		// Ação:

		Assert.assertEquals(service.create(livroVO), null);

	}

}
