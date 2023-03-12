package com.estudos.MyBooksProject.domain.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.estudos.MyBooksProject.utils.validacao.usuario.Email;
import com.estudos.MyBooksProject.utils.validacao.usuario.Telefone;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	
	private String telefone;
	private LocalDate data_criacao;
	private LocalDate data_atualizacao;
	@ManyToMany
	@JoinTable(name = "usuario_perfil",
		joinColumns = @JoinColumn(name = "usuario_id"),
		inverseJoinColumns = @JoinColumn(name = "perfil_id"))
	private List<Perfil> perfis = new ArrayList<>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		
		this.email = new Email(email).getEndereco();
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = new Telefone(telefone).getNumeroCompleto();
	}
	public LocalDate getData_criacao() {
		return data_criacao;
	}
	public void setData_criacao(LocalDate data_criacao) {
		this.data_criacao = data_criacao;
	}
	public List<Perfil> getPefis() {
		return perfis;
	}
	public void addPefil(Perfil perfis) {
		getPefis().add(perfis);
	}
	public LocalDate getData_atualizacao() {
		return data_atualizacao;
	}
	public void setData_atualizacao(LocalDate data_atualizacao) {
		this.data_atualizacao = data_atualizacao;
	}
	
	
	

}
