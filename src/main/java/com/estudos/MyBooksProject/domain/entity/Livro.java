package com.estudos.MyBooksProject.domain.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.estudos.MyBooksProject.api.LivroVO;

@Entity
@Table(name = "livros")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String titulo;

	@Column(nullable = false)
	private String autor;

	@Column(nullable = false)
	private String editora;

	@Column(nullable = false)
	private String categoria;

	@Column
	private String subCategoria;
	@Column
	private String isbn;
	@Column
	private Integer paginas;
	@Column
	private String notas;
	@Column
	private String image;

	private Date compra;

	@Column
	private Date registro;
	@Column
	private String colecao;

	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public Livro(LivroVO livroVO) {
		super();
		this.titulo = livroVO.getTitulo();
		this.autor = livroVO.getAutor();
		this.editora = livroVO.getAutor();
		this.categoria = livroVO.getAutor();
		this.subCategoria = livroVO.getSubCategoria();
		this.isbn = livroVO.getIsbn();
		this.paginas = livroVO.getPaginas();
		this.notas = livroVO.getNotas();
		this.image = livroVO.getImage();
		this.compra = livroVO.getCompra();
		this.registro = livroVO.getRegistro();
		this.colecao = livroVO.getColecao();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return Objects.hash(autor, categoria, colecao, compra, editora, id, image, isbn, notas, paginas, registro,
				subCategoria, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(categoria, other.categoria)
				&& Objects.equals(colecao, other.colecao) && Objects.equals(compra, other.compra)
				&& Objects.equals(editora, other.editora) && id == other.id && Objects.equals(image, other.image)
				&& Objects.equals(isbn, other.isbn) && Objects.equals(notas, other.notas) && paginas == other.paginas
				&& Objects.equals(registro, other.registro) && Objects.equals(subCategoria, other.subCategoria)
				&& Objects.equals(titulo, other.titulo);
	}

}
