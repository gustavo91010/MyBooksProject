package com.estudos.MyBooksProject.config.seguranca.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.estudos.MyBooksProject.config.seguranca.DetalhesUsuarioImpl;
import com.estudos.MyBooksProject.config.seguranca.DetalhesUsuarioService;

public class FiltroAutenticacaoToken extends OncePerRequestFilter {
	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	private DetalhesUsuarioService userDetailsService;

	private static final Logger logger = LoggerFactory.getLogger(FiltroAutenticacaoToken.class);

	public String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");

		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7, headerAuth.length());
		}

		return null;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwt = parseJwt(request);
			if (jwt != null && jwtUtil.validadeJwtToken(jwt)) {

				// recuperando o usuario atravez do token
				String username = jwtUtil.getUserNameFromJwt(jwt);
				UserDetails DetalhesUsuario = userDetailsService.loadUserByUsername(username);
				
				// criando a autenticação
				UsernamePasswordAuthenticationToken autenticadao = new UsernamePasswordAuthenticationToken(
						DetalhesUsuario, null, DetalhesUsuario.getAuthorities());
				
				autenticadao.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(autenticadao);
			}

		} catch (Exception e) {
			logger.error("Não é possível definir a autenticação do usuario: {}", e);
		}
		filterChain.doFilter(request, response);

	}

}
