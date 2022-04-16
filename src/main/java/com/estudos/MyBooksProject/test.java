package com.estudos.MyBooksProject;

import java.util.ArrayList;
import java.util.List;

import com.estudos.MyBooksProject.builder.LivroBuilder;
import com.estudos.MyBooksProject.entity.Livro;

public class test {
	public static void main(String[] args) {
		long id = 1;

		LivroBuilder builder = new LivroBuilder();
		Livro livro = builder.umLivro(1);
		List<Livro> livros = new ArrayList<>();

		livros.add(builder.umLivro(id++));
		livros.add(builder.umLivro(id++));
		livros.add(builder.umLivro(id++));
		livros.add(builder.umLivro(id++));
		livros.add(builder.umLivro(3));
		livros.add(builder.umLivro(3));
		livros.add(builder.umLivro(3));
		livros.add(builder.umLivro(id++));
		livros.add(builder.umLivro(id++));

		for (Livro item : livros) {
			if (item.getTitulo().equals("test 1")) {

				System.out.println(item.getTitulo());
			}
		}

		System.out.println("de boa?");

	}

}
