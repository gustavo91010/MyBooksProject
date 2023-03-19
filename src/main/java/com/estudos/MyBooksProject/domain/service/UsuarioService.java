package com.estudos.MyBooksProject.domain.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.estudos.MyBooksProject.api.exceptions.UsuarioNaoEncontradoException;
import com.estudos.MyBooksProject.config.seguranca.DetalhesUsuarioImpl;
import com.estudos.MyBooksProject.config.seguranca.DetalhesUsuarioService;
import com.estudos.MyBooksProject.config.seguranca.jwt.JwtUtil;
import com.estudos.MyBooksProject.database.repository.UsuarioRepository;
import com.estudos.MyBooksProject.domain.entity.EPerfis;
import com.estudos.MyBooksProject.domain.entity.Perfil;
import com.estudos.MyBooksProject.domain.entity.Usuario;
import com.estudos.MyBooksProject.domain.execao.MensagemExcecao;
import com.estudos.MyBooksProject.domain.service.dto.LoginDTO;
import com.estudos.MyBooksProject.domain.service.dto.LoginResponse;
import com.estudos.MyBooksProject.domain.service.dto.RegistrarUsuarioDto;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private DetalhesUsuarioService detalhesUsuarioService;
	@Autowired
	AuthenticationManager authenticationManager;

//	public Usuario registar(String nome,String senha, String emial, String numero) {
	public Usuario registar(RegistrarUsuarioDto registrarUsuarioDto) {

		// Verificando se existe um user
		Optional<Usuario> usuarioExiste = usuarioRepository.findByNome(registrarUsuarioDto.getNome());
		if (usuarioExiste.isPresent()) {
			throw new MensagemExcecao("Nome já cadastrado!");
		}
		// Codificando a senha:
		String senhaCodificada = encoder.encode(registrarUsuarioDto.getSenha());

		Usuario usuario = usuarioFactor(registrarUsuarioDto.getNome(), senhaCodificada, registrarUsuarioDto.getEmial(),
				registrarUsuarioDto.getNumero());
		Usuario usuarioRegistrado = usuarioRepository.save(usuario);

		return usuarioRegistrado;

	}

	public LoginResponse login(LoginDTO loginDTO) {
		// Verificando se existe um user
		Usuario usuarioExiste = usuarioRepository.findByEmail(loginDTO.getEmail())
				.orElseThrow(() -> new MensagemExcecao("Nome / Senha  inválido"));

		// checabdo a senha:
		if (encoder.matches(loginDTO.getSenha(), usuarioExiste.getSenha())) {
			throw new BadCredentialsException("Nome / Senha  inválido");
		}
		
		// Fase de autenticação:
		
		jwtUtil = new JwtUtil();
		
		DetalhesUsuarioImpl userDetails = detalhesUsuarioService.loadUserByUsername(loginDTO.getEmail());
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, loginDTO.getSenha(), userDetails.getAuthorities());

		Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		String jwt = jwtUtil.geracaoJwtToken(authentication);


		return null;
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

	public Usuario usuarioFactor(String nome, String senha, String emial, String numero) {

		// criar im metodo para destrinchar o ddd do numero;

		Usuario usuario = new Usuario();
		usuario.setSenha(senha);
		usuario.setData_criacao(LocalDate.now());
		usuario.setEmail(emial);
//		usuario.setTelefone(numero);

		Perfil visitante = new Perfil();
		visitante.setPerfil(EPerfis.VISITANTE);

		usuario.addPefil(visitante);

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

	protected Usuario atribuirPerfilVisitante(Usuario usuario) {
		Perfil perfil = new Perfil();
		perfil.setPerfil(EPerfis.VISITANTE);
		usuario.getPefis().add(perfil);
		return usuario;
	}

}
