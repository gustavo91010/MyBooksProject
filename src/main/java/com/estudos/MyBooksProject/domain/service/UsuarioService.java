package com.estudos.MyBooksProject.domain.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.MyBooksProject.api.exceptions.UsuarioNaoEncontradoException;
import com.estudos.MyBooksProject.database.repository.UsuarioRepository;
import com.estudos.MyBooksProject.domain.entity.EPerfis;
import com.estudos.MyBooksProject.domain.entity.Perfil;
import com.estudos.MyBooksProject.domain.entity.Usuario;
import com.estudos.MyBooksProject.utils.validacao.usuario.Email;
import com.estudos.MyBooksProject.utils.validacao.usuario.Telefone;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario registar(String nome, String emial, String numero) {

		Usuario usuario = usuarioFactor( nome,  emial,  numero);
		Usuario usuarioRegistrado = usuarioRepository.save(usuario);

		return usuarioRegistrado;

	}

	public Usuario buscarPorId(Long id) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario nao encontrado"));

		return usuario;
	}

	public Usuario buscarPorNome(String nome) {
		Usuario usuario = usuarioRepository.findByNome(nome)
				.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario nao encontrado"));

		return usuario;

	}

	public List<Usuario> buscarTodos() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios;

	}

	public void atualizarDados(Long id, String nome, String emial, String numero) {
		Usuario usuario = buscarPorId(id);

		if (!(nome == null)) {
			usuario.setNome(nome);
		}
		if (!(emial == null)) {
			usuario.setEmail(emial);
		}
		if (!(numero == null)) {
			usuario.setTelefone(numero);
		}
		usuario.setData_atualizacao(LocalDate.now());

		usuarioRepository.save(usuario);

	}

	public void remover(Long id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario usuarioFactor(String nome, String emial, String numero) {

		// criar im metodo para destrinchar o ddd do numero;

		Usuario usuario = new Usuario();
		usuario.setData_criacao(LocalDate.now());
		usuario.setEmail(emial);
		usuario.setTelefone(numero);
		Perfil perfil = new Perfil();
		perfil.setPerfil(EPerfis.AMIGOS);
		usuario.addPefil(perfil);

		return usuario;
	}

	protected Usuario atribuirPerfilDono(Usuario usuario) {
		Perfil perfil = new Perfil();
		perfil.setPerfil(EPerfis.DONO);
		usuario.getPefis().add(perfil);
		return usuario;
	}

	protected Usuario atribuirPerfilFamilia(Usuario usuario) {
		Perfil perfil = new Perfil();
		perfil.setPerfil(EPerfis.FAMILIA);
		usuario.getPefis().add(perfil);
		return usuario;
	}

	protected Usuario atribuirPerfilAmigos(Usuario usuario) {
		Perfil perfil = new Perfil();
		perfil.setPerfil(EPerfis.AMIGOS);
		usuario.getPefis().add(perfil);
		return usuario;
	}

}
