package com.estudos.MyBooksProject.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.estudos.MyBooksProject.entity.Livro;
import com.estudos.MyBooksProject.repository.LivroRepository;

@Service
public class LivroService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private LivroRepository repository;
	
	private Livro livro= new Livro();
	private List<Livro> livros= new ArrayList<>();
	
	
	public Livro create(Livro livro) {
		return repository.save(livro); 
		
	}
	public Livro findById(long id) {
		return repository.findById(id).orElseThrow();
	}
	
	public List<Livro> findAll(){
		return repository.findAll();
	}
	public Livro delete (long id) {
		livro= findById(id);
		 repository.delete(livro);
		 return livro;
		
	}
	public Livro update(Livro livro) {
		Livro entity= findById(livro.getId());
		
		entity.setTitulo(livro.getTitulo());
		entity.setAutor(livro.getAutor());
		entity.setCategoria(livro.getCategoria());
		entity.setSubCategoria(livro.getSubCategoria());
		entity.setNotas(livro.getNotas());
		entity.setImage(livro.getImage());
		entity.setEditora(livro.getEditora());
		entity.setCompra(livro.getCompra());
		entity.setRegistro(livro.getRegistro());
		
		return repository.save(entity);
	}
	
	public Livro  findByTitle(String title) {
//		String sql= " SELECT * FROM mybooksproject.livros where titulo= ? ";
		livros= findAll();
		
		for( Livro item: livros) {
			if(item.getTitulo().equals(title)) {
//				System.out.println(item.getTitulo());
				livros.clear();
				livros.add(item);
			}else {
				return null;
			}
		}
		
		return livros.get(0);
		
		

		
	}
//	public void findByTitulo(String titulo) {
//		return ResponseEntity.ok().
//	}
	
	

}
