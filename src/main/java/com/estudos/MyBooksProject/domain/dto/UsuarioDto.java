package com.estudos.MyBooksProject.domain.dto;

import com.estudos.MyBooksProject.utils.validacao.usuario.Email;
import com.estudos.MyBooksProject.utils.validacao.usuario.Telefone;

public class UsuarioDto {
	private String nome;
	private Email emial;
	private Telefone telefone;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Email getEmial() {
		return emial;
	}
	public void setEmial(Email emial) {
		this.emial = emial;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	


	
	

}
