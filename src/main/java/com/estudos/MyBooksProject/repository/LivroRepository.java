package com.estudos.MyBooksProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.estudos.MyBooksProject.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>, JpaSpecificationExecutor<Livro>{

	public List<Livro> findByTitulo(String titulo);
	public List<Livro> findByAutor(String autor);
	

}
