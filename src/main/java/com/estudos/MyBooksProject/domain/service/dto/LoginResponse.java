package com.estudos.MyBooksProject.domain.service.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.estudos.MyBooksProject.domain.entity.Perfil;

public class LoginResponse {
	private Long id;
	private String email;
	private String nome;
	private String jwtExpirationMs;
	private List<Perfil> perfis = new ArrayList<>();
	private String type = "Bearer";
	S
	private boolean ativo;
	private LocalDate data_expiracao;
	private String token;

}
