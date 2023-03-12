package com.estudos.MyBooksProject.domain.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.estudos.MyBooksProject.api.LivroVO;
import com.estudos.MyBooksProject.database.repository.LivroRepository;
import com.estudos.MyBooksProject.domain.entity.Livro;
import com.estudos.MyBooksProject.utils.converter.DozerConverter;
import com.estudos.MyBooksProject.utils.verificacao.VerificarValidacaoNovoLivro;

@Service
public class LivroService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	LivroRepository repository;

	public LivroVO create(LivroVO livroVO) throws Exception  {
		
		Livro livro = new Livro();
		VerificarValidacaoNovoLivro verificarValidacaoNovoLivro= new VerificarValidacaoNovoLivro();
		verificarValidacaoNovoLivro.validacaoNovoLivro(livroVO);
		
		livro = DozerConverter.parseObject(livroVO, Livro.class);

//		boolean isNumeric = livro.getIsbn().matches("[+-]?\\d*(\\.\\d+)?");
//
//		if (!isNumeric) {
//			throw new IsbnExceptions("ISBN nao pode conter letras");
//		}
//
//		if (livro.getIsbn().length() < 10) {
//			throw new IsbnExceptions("ISBN tem que ter mais de 10 digitos.");
//		}
//		if (livro.getIsbn().length() > 13) {
//			throw new IsbnExceptions("ISBN tem que ter menos de 13 digitos");
//		}
//		if (livro.getPaginas() < 1) {
//			throw new LivroSemPaginaException("A quantidade de paginas deve ser superior a 0.");
//		}
		repository.save(livro);

		return livroVO;

	}

	public LivroVO findById(long id) {
		Livro livro = repository.findById(id).orElseThrow();
		return DozerConverter.parseObject(livro, LivroVO.class);
	}

	public List<LivroVO> findByTitulo(String titulo) {
		List<Livro> livros = repository.findByTitulo(titulo);

		List<LivroVO> livrosVO2 = new ArrayList<>();

		for (int i = 0; i < livros.size(); i++) {
			LivroVO livroVO1 = new LivroVO();

			livroVO1.setKey(livros.get(i).getId());
			livroVO1.setTitulo(livros.get(i).getTitulo());
			livroVO1.setAutor(livros.get(i).getAutor());
			livroVO1.setEditora(livros.get(i).getEditora());
			livroVO1.setCategoria(livros.get(i).getCategoria());
			livroVO1.setSubCategoria(livros.get(i).getSubCategoria());
			livroVO1.setNotas(livros.get(i).getNotas());
			livroVO1.setImage(livros.get(i).getImage());
			livroVO1.setCompra(livros.get(i).getCompra());
			livroVO1.setRegistro(livros.get(i).getRegistro());
			livroVO1.setColecao(livros.get(i).getColecao());

			livrosVO2.add(livroVO1);

		}
		return livrosVO2;
	}

	public List<LivroVO> findByAutor(String autor) {
		List<Livro> livros = repository.findByAutor(autor);

		List<LivroVO> livrosVO2 = new ArrayList<>();

		for (int i = 0; i < livros.size(); i++) {
			LivroVO livroVO1 = new LivroVO();

			livroVO1.setKey(livros.get(i).getId());
			livroVO1.setTitulo(livros.get(i).getTitulo());
			livroVO1.setAutor(livros.get(i).getAutor());
			livroVO1.setEditora(livros.get(i).getEditora());
			livroVO1.setCategoria(livros.get(i).getCategoria());
			livroVO1.setSubCategoria(livros.get(i).getSubCategoria());
			livroVO1.setNotas(livros.get(i).getNotas());
			livroVO1.setImage(livros.get(i).getImage());
			livroVO1.setCompra(livros.get(i).getCompra());
			livroVO1.setRegistro(livros.get(i).getRegistro());
			livroVO1.setColecao(livros.get(i).getColecao());

			livrosVO2.add(livroVO1);

		}
		return livrosVO2;
	}

	public Page<LivroVO> findAll(Pageable pageable) {
		var entity = repository.findAll(pageable);
		return entity.map(this::convertToLivro);
	}

	public List<LivroVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), LivroVO.class);
	}

	private LivroVO convertToLivro(Livro livro) {

		return DozerConverter.parseObject(livro, LivroVO.class);
	}

	public LivroVO update(LivroVO livroVO) {
		Livro livro = repository.findById(livroVO.getKey()).orElseThrow();
		livro.setId(livroVO.getKey());
		livro.setTitulo(livroVO.getTitulo());
		livro.setEditora(livroVO.getEditora());
		livro.setCategoria(livroVO.getCategoria());
		livro.setSubCategoria(livroVO.getSubCategoria());
		livro.setImage(livroVO.getImage());
		livro.setNotas(livroVO.getNotas());
		livro.setAutor(livroVO.getAutor());
		livro.setCompra(livroVO.getCompra());
		livro.setRegistro(livroVO.getRegistro());
		livro.setColecao(livroVO.getColecao());
		repository.save(livro);

		return DozerConverter.parseObject(livro, LivroVO.class);
	}

	public LivroVO delete(long id) {
		Livro livro = repository.findById(id).orElseThrow();
		repository.delete(livro);
		return DozerConverter.parseObject(livro, LivroVO.class);

	}

}
