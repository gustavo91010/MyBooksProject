package com.estudos.MyBooksProject.utils.validacao.livros;

import com.estudos.MyBooksProject.api.LivroVO;

public interface ValidacaoNovoLivro {
	
	public LivroVO validar(LivroVO livro) throws Exception;

}
