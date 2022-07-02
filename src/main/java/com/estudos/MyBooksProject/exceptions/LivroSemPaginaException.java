package com.estudos.MyBooksProject.exceptions;

public class LivroSemPaginaException extends Exception {

	private static final long serialVersionUID = 1L;

	public LivroSemPaginaException() {
	}

	public LivroSemPaginaException(String mensagem) {
		super(mensagem);
	}

}
