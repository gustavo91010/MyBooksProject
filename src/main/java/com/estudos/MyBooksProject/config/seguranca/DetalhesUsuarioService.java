package com.estudos.MyBooksProject.config.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.estudos.MyBooksProject.database.repository.UsuarioRepository;
import com.estudos.MyBooksProject.domain.entity.Usuario;

public class DetalhesUsuarioService implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public DetalhesUsuarioImpl loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario não cadastrado."));

		return DetalhesUsuarioImpl.build(usuario);
	}
	
	 public String findLoggedInUsername() {
		 System.err.println(" a gente chamou esse metodo findLoggedInUsername na classe DetalhesUsuarioService? ");
	        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
	        if (userDetails instanceof UserDetails) {
	            return ((UserDetails)userDetails).getUsername();
	        }

	        return null;
	    }

}
