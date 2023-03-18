package com.estudos.MyBooksProject.api;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "titulo", "autor", "editora", "categoria" })
public class LivroVO extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	private long key;
	private String titulo;
	private String autor;
	private String editora;

	private String categoria;
	private String subCategoria;
	private String notas;
	private String image;

	private Date compra;
	private Date registro;
	private String colecao;

	private String isbn;
	private Integer paginas;

	public LivroVO() {
		// TODO Auto-generated constructor stub
	}

	public LivroVO(String titulo, String autor, String editora, String categoria, String subCategoria, String notas,
			String image, Date compra, String colecao, String isbn, Integer paginas) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.categoria = categoria;
		this.subCategoria = subCategoria;
		this.notas = notas;
		this.image = image;
		this.compra = compra;
		this.colecao = colecao;
		this.isbn = isbn;
		this.paginas = paginas;
	}

	public long getKey() {
		return key;
	}

	public void setKey(long key) {
		this.key = key;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(String subCategoria) {
		this.subCategoria = subCategoria;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCompra() {
		return compra;
	}

	public void setCompra(Date compra) {
		this.compra = compra;
	}

	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}

	public String getColecao() {
		return colecao;
	}

	public void setColecao(String colecao) {
		this.colecao = colecao;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(autor, categoria, colecao, compra, editora, image, isbn, key, notas,
				paginas, registro, subCategoria, titulo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LivroVO other = (LivroVO) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(categoria, other.categoria)
				&& Objects.equals(colecao, other.colecao) && Objects.equals(compra, other.compra)
				&& Objects.equals(editora, other.editora) && Objects.equals(image, other.image)
				&& Objects.equals(isbn, other.isbn) && key == other.key && Objects.equals(notas, other.notas)
				&& paginas == other.paginas && Objects.equals(registro, other.registro)
				&& Objects.equals(subCategoria, other.subCategoria) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "LivroVO [key=" + key + ", titulo=" + titulo + ", autor=" + autor + ", editora=" + editora
				+ ", categoria=" + categoria + ", subCategoria=" + subCategoria + ", notas=" + notas + ", image="
				+ image + ", compra=" + compra + ", registro=" + registro + ", colecao=" + colecao + ", isbn=" + isbn
				+ ", paginas=" + paginas + "]";
	}

}