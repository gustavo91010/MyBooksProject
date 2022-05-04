package com.estudos.MyBooksProject.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.estudos.MyBooksProject.converter.DozerConverter;
import com.estudos.MyBooksProject.entity.Livro;
import com.estudos.MyBooksProject.entity.LivroVO;
import com.estudos.MyBooksProject.repository.LivroRepository;

@Service
public class LivroServiceVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private LivroRepository repository;

	private LivroVO livroVO = new LivroVO();

	public LivroVO create(LivroVO livroVO) {
		Livro livro = DozerConverter.parseObject(livroVO, Livro.class);
		LivroVO vo = DozerConverter.parseObject(repository.save(livro), LivroVO.class);
		return vo;

	}

	public LivroVO convertToLivro(String titulo) {
		Livro livro= repository.findByTitulo(titulo);
		return DozerConverter.parseObject(livro, LivroVO.class);
	}

	public LivroVO findById(long id) {
		Livro livro = repository.findById(id).orElseThrow();
		return DozerConverter.parseObject(livro, LivroVO.class);
	}
	
	public LivroVO findByTitulo(String titulo) {
	Livro	livro= repository.findByTitulo(titulo);
		
		livroVO.setKey(livro.getId());
		livroVO.setTitulo(livro.getTitulo());
		livroVO.setAutor(livro.getAutor());
		livroVO.setEditora(livro.getEditora());
		livroVO.setCategoria(livro.getCategoria());
		livroVO.setSubCategoria(livro.getSubCategoria());
		livroVO.setNotas(livro.getNotas());
		livroVO.setImage(livro.getImage());
		livroVO.setCompra(livro.getCompra());
		livroVO.setRegistro(livro.getRegistro());
		livroVO.setColecao(livro.getColecao());
		return livroVO;
	}
	
	public List<LivroVO> findByAutor(String autor) {
		List<Livro>	livros= repository.findByAutor(autor);
		List<LivroVO> livrosVO= new ArrayList<>();
		LivroVO livroVO= new LivroVO();
		for(int i=0; i< livros.size(); i++) {
					System.out.println("Entrada service: "+livros.get(i).getId());
					
		livroVO.setKey(livros.get(i).getId());
		livroVO.setTitulo(livros.get(i).getTitulo());
		livroVO.setAutor(livros.get(i).getAutor());
		livroVO.setEditora(livros.get(i).getEditora());
		livroVO.setCategoria(livros.get(i).getCategoria());
		livroVO.setSubCategoria(livros.get(i).getSubCategoria());
		livroVO.setNotas(livros.get(i).getNotas());
		livroVO.setImage(livros.get(i).getImage());
		livroVO.setCompra(livros.get(i).getCompra());
		livroVO.setRegistro(livros.get(i).getRegistro());
		livroVO.setColecao(livros.get(i).getColecao());
		
		livrosVO.add(livroVO);
			System.out.println("Apos a lista service: "+livrosVO.get(i).getKey()+" "+livrosVO.get(i).getTitulo()+"\n");
		
		}
		
		for(int i=0; i< livros.size(); i++) {
		System.out.println("Antes do return: "+livrosVO.get(i).getKey()+" "+livrosVO.get(i).getTitulo()+"\n");
		}
		
		return livrosVO;
	}
	
//	public LivroVO findByAutor(String autor) {
//		Livro	livro= repository.findByAutor(autor);
//		
//		livroVO.setKey(livro.getId());
//		livroVO.setTitulo(livro.getTitulo());
//		livroVO.setAutor(livro.getAutor());
//		livroVO.setEditora(livro.getEditora());
//		livroVO.setCategoria(livro.getCategoria());
//		livroVO.setSubCategoria(livro.getSubCategoria());
//		livroVO.setNotas(livro.getNotas());
//		livroVO.setImage(livro.getImage());
//		livroVO.setCompra(livro.getCompra());
//		livroVO.setRegistro(livro.getRegistro());
//		livroVO.setColecao(livro.getColecao());
//		return livroVO;
//	}
//	
	public Page<LivroVO> findAll(Pageable pageable) {
		var entity = repository.findAll(pageable);
		return entity.map(this::convertToLivro);
	}

	private LivroVO convertToLivro(Livro livro) {

		return DozerConverter.parseObject(livro, LivroVO.class);
	}

	public LivroVO delete(long id) {
		Livro livro = repository.findById(id).orElseThrow();

		repository.delete(livro);
		livroVO = DozerConverter.parseObject(livro, LivroVO.class);
		return livroVO;

	}

	public LivroVO update(LivroVO livroVO) {
		Livro entity = repository.findById(livroVO.getKey()).orElseThrow();
		entity.setTitulo(livroVO.getTitulo());
		entity.setAutor(livroVO.getAutor());
		entity.setCategoria(livroVO.getCategoria());
		entity.setSubCategoria(livroVO.getSubCategoria());
		entity.setNotas(livroVO.getNotas());
		entity.setImage(livroVO.getImage());
		entity.setEditora(livroVO.getEditora());
		entity.setCompra(livroVO.getCompra());
		entity.setRegistro(livroVO.getRegistro());
		entity.setColecao(livroVO.getColecao());
		livroVO = DozerConverter.parseObject(repository.save(entity), LivroVO.class);

		return livroVO;
	}

}
