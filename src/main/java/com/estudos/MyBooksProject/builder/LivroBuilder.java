package com.estudos.MyBooksProject.builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.estudos.MyBooksProject.entity.Livro;

public class LivroBuilder {

String nome= "nome";
	
//	private AtomicLong atm1 = new AtomicLong();

	public Livro umLivro(long ex) {
//	public Livro umLivro() {
//		long ex= atm1.incrementAndGet();
		Livro livro = new Livro();
		livro.setId(ex);
		livro.setAutor("test " + ex);
		livro.setTitulo("test " + ex);
		livro.setEditora("test " + ex);
		livro.setCategoria("test " + ex);
		livro.setSubCategoria("test " + ex);
		livro.setNotas("test " + ex);
		livro.setImage("test " + ex);
		livro.setCompra(new Date());
		livro.setRegistro(new Date());

		return livro;
	}

	public List<Livro> umaListLivros() {

		List<Livro> livros= new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			livros.add(umLivro(i));
			
		}
		return livros;

	}

}
