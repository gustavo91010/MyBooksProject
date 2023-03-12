package com.estudos.MyBooksProject.utils.validacao.livros;

import com.estudos.MyBooksProject.api.LivroVO;
import com.estudos.MyBooksProject.api.exceptions.IsbnExceptions;

public class IsbnIsNumeric implements ValidacaoNovoLivro {

	@Override
	public LivroVO validar(LivroVO livroVO) throws IsbnExceptions {
		boolean isNumeric = livroVO.getIsbn().matches("[+-]?\\d*(\\.\\d+)?");
		if (!isNumeric) {
			throw new IsbnExceptions("ISBN nao pode conter letras");
		}
		return livroVO;

	}

}
