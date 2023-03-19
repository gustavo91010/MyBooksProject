package com.estudos.MyBooksProject.config.seguranca;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.estudos.MyBooksProject.domain.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;;

public class DetalhesUsuarioImpl implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Long id;
//	private String username;
	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public DetalhesUsuarioImpl(Long id, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
//		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static DetalhesUsuarioImpl build(Usuario usuario) {
		Collection<? extends GrantedAuthority> autorização = usuario.getPefis().stream()
				.map(perfil -> new SimpleGrantedAuthority(perfil.getPerfil().name())).collect(Collectors.toList());
		User user = new User(usuario.getNome(), usuario.getSenha(), autorização);

		return new DetalhesUsuarioImpl(usuario.getId(), user.getUsername(), usuario.getEmail(), user.getPassword(),
				autorização);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public void setUsername(String username) {
//		this.username = username;
//	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorities, email, id, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalhesUsuarioImpl other = (DetalhesUsuarioImpl) obj;
		return Objects.equals(authorities, other.authorities) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(password, other.password);
	}



}
