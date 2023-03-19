package com.estudos.MyBooksProject.config.seguranca.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class PontoEntradaAuthJwt  implements AuthenticationEntryPoint{
	
	private static final Logger logger = LoggerFactory.getLogger(PontoEntradaAuthJwt.class);


	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().print("{ \"message\": \"" + "Não autorizado" + "\" }");
		logger.error("Usuario não autorizado!");
		
	}

}
