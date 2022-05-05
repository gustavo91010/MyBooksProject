package com.estudos.MyBooksProject.converter;

import org.springframework.stereotype.Service;

import com.estudos.MyBooksProject.entity.Livro;
import com.estudos.MyBooksProject.entity.LivroVOV2;

@Service
public class LivroConverterV2 {

	public LivroVOV2 convertLivroToLivroVO(Livro livro) {
		// o VOV2 passou a ser meu antigo VO

		LivroVOV2 vo = new LivroVOV2();

		vo.setId(livro.getId());
		vo.setTitulo(livro.getTitulo());
		vo.setAutor(livro.getAutor());
		vo.setEditora(livro.getEditora());
		vo.setCategoria(livro.getCategoria());
		vo.setSubCategoria(livro.getSubCategoria());
		vo.setNotas(livro.getNotas());
		vo.setImage(livro.getImage());
		vo.setCompra(livro.getCompra());
		vo.setRegistro(livro.getRegistro());
		vo.setColecao(livro.getColecao());
		return vo;

	}

	public Livro convertLivroVOToLivro(LivroVOV2 livroVOV2) {
		// o VOV2 passou a ser meu antigo VO

		Livro livro = new Livro();

		livro.setId(livroVOV2.getId());
		livro.setTitulo(livroVOV2.getTitulo());
		livro.setAutor(livroVOV2.getAutor());
		livro.setEditora(livroVOV2.getEditora());
		livro.setCategoria(livroVOV2.getCategoria());
		livro.setSubCategoria(livroVOV2.getSubCategoria());
		livro.setNotas(livroVOV2.getNotas());
		livro.setImage(livroVOV2.getImage());
		livro.setCompra(livroVOV2.getCompra());
		livro.setRegistro(livroVOV2.getRegistro());
		livro.setColecao(livroVOV2.getColecao());

		return livro;
	}

}
