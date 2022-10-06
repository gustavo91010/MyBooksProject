package com.estudos.MyBooksProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.estudos.MyBooksProject.From.SpecificationLivroFron;
import com.estudos.MyBooksProject.entity.Livro;
import com.estudos.MyBooksProject.entity.SpecificationLivro;
import com.estudos.MyBooksProject.repository.LivroRepository;

@Service
public class SpecificationLivroService {
	
	@Autowired
	private LivroRepository repository;
	
	public List<Livro> buscarLirvosDinamico(SpecificationLivroFron specificationLivroFron) {
		
		Specification<Livro> specifications= Specification.where(
				SpecificationLivro.autor( specificationLivroFron.getAutor() )
				.or(SpecificationLivro.categoria( specificationLivroFron.getCategoria() ))
				.or(SpecificationLivro.editora(specificationLivroFron.getEditora() ))
				.or(SpecificationLivro.titulo( specificationLivroFron.getTitulo() ) ));
				
		List<Livro> livros= repository.findAll(specifications);
		return livros;
	}
}
	
//	
//	Specification<Livro>  specifications= 
//			Specification.where(
//				SpecificationLivro.autor(autor))
//			.or(SpecificationLivro.titulo(titulo));
//			
//	
//	
//	List<Livro> livros= repository.findAll();
	
	
	
	
//	List<Funcionario> funcionarios= funcionarioRepository.findAll
//			(Specification.where(
//					SpecificationFuncionario.nome(nome))
//					.or(SpecificationFuncionario.cpf(cpf))
//					.or(SpecificationFuncionario.salario(salario))
//					.or(SpecificationFuncionario.dataContratacao(dataContratacao))
//					);
//	funcionarios.forEach(System.out::println);


