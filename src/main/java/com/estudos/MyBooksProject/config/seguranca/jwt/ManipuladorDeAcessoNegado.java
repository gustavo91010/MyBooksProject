package com.estudos.MyBooksProject.config.seguranca.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class ManipuladorDeAcessoNegado implements AccessDeniedHandler {

	private static final Logger logger = LoggerFactory.getLogger(ManipuladorDeAcessoNegado.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		logger.error(accessDeniedException.getMessage());

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.getWriter().print("{ \"message\": \"" + "Acesso negado" + "\" }");

	}

}
