package com.boaEntrega.servicos.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boaEntrega.servicos.entity.ClienteEntity;
import com.boaEntrega.servicos.repository.JwtUserDetailsRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private JwtUserDetailsRepository jwtUserDetailsRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//com.bootstrap.springboot.model.User user = userService.getByEmail(email);
		ClienteEntity clienteEntity = jwtUserDetailsRepository.consultarCliente(email);
		if (clienteEntity != null && email.equals(clienteEntity.getEmail())) {
			return new User(email,clienteEntity.getSenha(),
					//user.getPassword(), 
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with email: " + email);
		}
	}
}