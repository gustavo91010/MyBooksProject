package com.estudos.MyBooksProject.utils.validacao.usuario;

import javax.persistence.Column;

import org.hibernate.annotations.Type;

public class Email {
	
	private String endereco;
	
	
	public Email(String endereco) {
		super();
		this.endereco = endereco;
	}
	public Email() {
		// TODO Auto-generated constructor stub
	}
	

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	

}
