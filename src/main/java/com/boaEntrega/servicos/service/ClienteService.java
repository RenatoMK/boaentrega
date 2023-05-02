package com.boaEntrega.servicos.service;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boaEntrega.servicos.entity.ClienteEntity;
import com.boaEntrega.servicos.repository.ClienteRepository;
import com.boaEntrega.servicos.response.CadastroClienteResponse;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public CadastroClienteResponse cadastrar(ClienteEntity dadosCliente) {
		dadosCliente.setDataEvento(new Date());
		return clienteRepository.cadastrar(dadosCliente);
	}
	
	public String alterar(ClienteEntity dadosCliente) {
		dadosCliente.setDataEvento(new Date());
		return clienteRepository.alterar(dadosCliente);
	}
	
	public ClienteEntity consultarCliente(String email) {
		return clienteRepository.consultarCliente(email);
	}

	public String detalhar(String valor) {
		
		return clienteRepository.detalhar(valor);
	}

}
