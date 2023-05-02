package com.boaEntrega.servicos.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boaEntrega.servicos.jwt.JwtUserDetailsService;
import com.boaEntrega.servicos.response.JwtResponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class JwtAuthenticationController {

	@Autowired
	private JwtUserDetailsService userDetailsService;

	private final String TOKEN_KEY = "login do batman";
	@ApiOperation(value = "Faz a autenticação do usuário" )
	@RequestMapping(value = "/authenticate", method = RequestMethod.GET)
	public ResponseEntity<?> createAuthenticationToken(@QueryParam(value = "") String email, @QueryParam(value = "") String senha) throws Exception {

		final UserDetails userDetails = userDetailsService.loadUserByUsername(email);
		Map<String, Object> headers = new HashMap<>();
		headers.put("typ", "JWT");
		headers.put("alg", "RS256");
		if (userDetails != null && senha.equals(userDetails.getPassword())) {
			String jwtToken = Jwts.builder().setSubject(email).setHeader(headers)
					.setIssuer("localhost:8080").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, TOKEN_KEY)
					.setExpiration(
							new Date(System.currentTimeMillis() + 30000 ))
					.compact();

			return ResponseEntity.ok(new JwtResponse("Bearer " + jwtToken));
		}

		return new ResponseEntity<String>("Usuário ou Senha inválidos", HttpStatus.UNAUTHORIZED);
	}

}