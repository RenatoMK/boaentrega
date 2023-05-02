package com.boaEntrega.servicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.boaEntrega.servicos.entity.EnderecoEntity;
import com.boaEntrega.servicos.repository.EnderecoRepository;
import com.boaEntrega.servicos.response.CadastroEnderecoResponse;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository enderecoRepository;

	public CadastroEnderecoResponse cadastrar(EnderecoEntity enderecoEntity) {
		return enderecoRepository.cadastrar(enderecoEntity);
	}
	
	public ResponseEntity<CadastroEnderecoResponse> consulta(@RequestBody EnderecoEntity enderecoEntity) {
		enderecoRepository.consulta(enderecoEntity);
		return ResponseEntity.ok(null);
	}
	
	public ResponseEntity<CadastroEnderecoResponse> consultaEndereco(@RequestParam String email) {
		enderecoRepository.consultaEndereco(email);
		return ResponseEntity.ok(null);
	}

	public ResponseEntity<String> detalha(String valor) {
		enderecoRepository.detalha(valor);
		return ResponseEntity.ok(null);
	}
}
