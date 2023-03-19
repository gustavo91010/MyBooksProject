package com.estudos.MyBooksProject.domain.execao;

public class MensagemExcecao extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MensagemExcecao(String mensagem) {
		super(mensagem);
	}

}
