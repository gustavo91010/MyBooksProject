package com.estudos.MyBooksProject.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private EPerfis perfil;

	@ManyToMany(mappedBy = "perfis")
	private List<Usuario> usuarios = new ArrayList<>();;
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	private EPerfis perfil;
//
//	@ManyToMany(mappedBy = "perfis")
//	private List<Usuario> usuarios = new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EPerfis getPerfil() {
		return perfil;
	}

	public void setPerfil(EPerfis perfil) {
		this.perfil = perfil;
	}

}
