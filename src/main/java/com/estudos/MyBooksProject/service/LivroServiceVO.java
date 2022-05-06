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


	public LivroVO create(LivroVO livroVO) {
		Livro livro = DozerConverter.parseObject(livroVO, Livro.class);
		LivroVO vo = DozerConverter.parseObject(repository.save(livro), LivroVO.class);
		return vo;

	}

//	public LivroVO convertToLivro(String titulo) {
//		Livro livro= repository.findByTitulo(titulo);
//		return DozerConverter.parseObject(livro, LivroVO.class);
//	}



	public LivroVO findById(long id) {
		Livro livro = repository.findById(id).orElseThrow();
		return DozerConverter.parseObject(livro, LivroVO.class);
	}

	public List<LivroVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), LivroVO.class);
	}
	
//		public LivroVO findByTitulo(String titulo) {
//	Livro	livro= repository.findByTitulo(titulo);
//	LivroVO livroVO = new LivroVO();
//		
//		livroVO.setKey(livro.getId());
//		livroVO.setTitulo(livro.getTitulo());
//		livroVO.setAutor(livro.getAutor());
//		livroVO.setEditora(livro.getEditora());
//		
//		livroVO.setCategoria(livro.getCategoria());
//		livroVO.setSubCategoria(livro.getSubCategoria());
//		livroVO.setNotas(livro.getNotas());
//		livroVO.setImage(livro.getImage());
//		
//		livroVO.setCompra(livro.getCompra());
//		livroVO.setRegistro(livro.getRegistro());
//		livroVO.setColecao(livro.getColecao());
//		return livroVO;
//	}
	
	public List<LivroVO> findByTitulo(String titulo) {
		List<Livro>	livros= repository.findByTitulo(titulo);
		
		List<LivroVO> livrosVO2= new ArrayList<>();
		
		for(int i=0; i< livros.size(); i++) {
			LivroVO livroVO1= new LivroVO();
			
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
		List<Livro>	livros= repository.findByAutor(autor);
		
		List<LivroVO> livrosVO2= new ArrayList<>();
		
		for(int i=0; i< livros.size(); i++) {
			LivroVO livroVO1= new LivroVO();
					
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

	private LivroVO convertToLivro(Livro livro) {

		return DozerConverter.parseObject(livro, LivroVO.class);
	}


	public LivroVO update(LivroVO livroVO) {
		Livro livro= repository.findById(livroVO.getKey()).orElseThrow();
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
		Livro livro= repository.findById(id).orElseThrow();
		repository.delete(livro);
		return DozerConverter.parseObject(livro, LivroVO.class);

	}


}
