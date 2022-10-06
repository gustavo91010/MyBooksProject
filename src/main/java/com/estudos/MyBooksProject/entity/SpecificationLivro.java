package com.estudos.MyBooksProject.entity;

import org.springframework.data.jpa.domain.Specification;

public class SpecificationLivro {

	public static Specification<Livro> autor(String autor) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("autor"), "%" + autor + "%");
	}

	public static Specification<Livro> titulo(String titulo) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("titulo"), "%" + titulo + "%");
	}

	public static Specification<Livro> editora(String editora) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("editora"), "%" + editora + "%");
	}

	public static Specification<Livro> categoria(String categoria) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("categoria"),
				"%" + categoria + "%");
	}

//{public static Specification<TIPO> nome(String nome){// nome sera o atributo da classe mae que sera refebido como parametro
//	return (root, criteriaQuery, criteriaBuilder)-> // esses atributossao padrao do JAVA, nao precisar ser criado
//	criteriaBuilder.like(root.get("nome"), "%"+nome+"%");// pode ser like
////	criteriaBuilder.equal(root.get("nome"), "%"+cpf+"%");// pode ser equals
////  criteriaBuilder.greaterThan(root.get("salario"), salario);// pode ser greaterThan, o maior
//}

}
