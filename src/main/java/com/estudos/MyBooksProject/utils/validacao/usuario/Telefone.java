package com.estudos.MyBooksProject.utils.validacao.usuario;

public class Telefone {
	
	private String ddd;
	private String numero;
	public Telefone(String ddd, String numero) {
		super();
		this.ddd = ddd;
		this.numero = numero;
	}
	public Telefone() {
	}
	public Telefone(String numero) {
		// TODO Auto-generated constructor stub
	}
	public String getDdd() {
		return ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNumeroCompleto() {
		return getDdd()+"-"+getNumero();
	}
	
	

}
