package com.estudos.MyBooksProject.config.seguranca.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.estudos.MyBooksProject.config.seguranca.DetalhesUsuarioImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
//@Value("${app.jwtSecret}")
	private String jwtSecret = "MyBooks";

//@Value("${app.jwtExpirationMs}")
	private String jwtExpirationMs = "2592000000";

	public String geracaoJwtToken(Authentication autenticacao) {
		DetalhesUsuarioImpl usuarioPrincipal = (DetalhesUsuarioImpl) autenticacao.getPrincipal();
		Claims reinvidicacaoDeAutenticacao = Jwts.claims().setSubject(usuarioPrincipal.getUsername());

		reinvidicacaoDeAutenticacao.put("id", usuarioPrincipal.getId());
		reinvidicacaoDeAutenticacao.put("username", usuarioPrincipal.getUsername());

		return Jwts.builder().setClaims(reinvidicacaoDeAutenticacao)
				.setExpiration(new Date((new Date()).getTime() + Long.parseLong(jwtExpirationMs)))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public String getUserNameFromJwt(String token) {
		token = token.replaceAll("Bearer ", "");
		Claims reinvidicacaoDeAutenticacao = Jwts.parser().setSigningKey("MyBooks").parseClaimsJwt(token).getBody();

		return reinvidicacaoDeAutenticacao.getSubject();
	}

	public Long getIdFromJwt(String token) {
		token = token.replaceAll("Bearer ", "");

		Claims reinvidicacaoDeAutenticacao = Jwts.parser().setSigningKey("MyBooks").parseClaimsJwt(token).getBody();
		Long id = Long.parseLong(String.valueOf(reinvidicacaoDeAutenticacao.get("id")));

		return id;
	}

	public boolean validadeJwtToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}

}
//
//	public boolean decoderJwtEmail(String token_jwt, String name) {
//		token_jwt = token_jwt.split(" ")[1];
//
//		Claims jwt_claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token_jwt).getBody();
//
//		if (jwt_claims.getSubject().contentEquals(name)) {
//			return true;
//		} else {
//			throw new NotAuthorizedException("Não autorizado");
//		}
//	}
