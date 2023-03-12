package com.estudos.MyBooksProject.utils.validacao.livros;

import com.estudos.MyBooksProject.api.LivroVO;
import com.estudos.MyBooksProject.api.exceptions.LivroSemPaginaException;

public class IsbnPaginas implements ValidacaoNovoLivro {

	@Override
	public LivroVO validar(LivroVO livro) throws LivroSemPaginaException {
		if (livro.getPaginas() < 1) {
			throw new LivroSemPaginaException("A quantidade de paginas deve ser superior a 0.");
		}
		return livro;
	}

}
