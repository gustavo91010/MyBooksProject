package com.estudos.MyBooksProject.builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.estudos.MyBooksProject.converter.DozerConverter;
import com.estudos.MyBooksProject.entity.Livro;
import com.estudos.MyBooksProject.entity.LivroVO;

public class LivroBuilder {

String nome= "nome";
	

	public Livro umLivro(long ex) {
		Livro livro = new Livro();
		livro.setId(ex);
		livro.setAutor("Autor: " + ex);
		livro.setTitulo("Titulo: " + ex);
		livro.setEditora("Editora: " + ex);
		livro.setCategoria("Categoria: " + ex);
		livro.setSubCategoria("SubCategoria: " + ex);
		livro.setNotas("notas: " + ex);
		livro.setImage("img: " + ex);
		livro.setIsbn("1234567890");
		livro.setPaginas(5);
		livro.setColecao("teste");
		livro.setCompra(new Date());
		livro.setRegistro(new Date());

		return livro;
	}
	public LivroVO livroSemPaginaVO() {
		Livro livro = new Livro();
		long ex= 1567;
		livro.setId(ex);
		livro.setAutor("Autor: " + ex);
		livro.setTitulo("Titulo: " + ex);
		livro.setEditora("Editora: " + ex);
		livro.setCategoria("Categoria: " + ex);
		livro.setSubCategoria("SubCategoria: " + ex);
		livro.setNotas("notas: " + ex);
		livro.setImage("img: " + ex);
		livro.setCompra(new Date());
		livro.setRegistro(new Date());
		livro.setIsbn("1234567890123");
		livro.setPaginas(100);
		LivroVO livroVO= DozerConverter.parseObject(livro, LivroVO.class);
		return livroVO;
	}
	
	
	public LivroVO umLivroVO(long ex) {
		Livro livro= umLivro(ex);
		
		return DozerConverter.parseObject(livro, LivroVO.class);
	}

	public List<Livro> umaListLivros() {

		List<Livro> livros= new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			livros.add(umLivro(i));
			
		}
		return livros;

	}

}
