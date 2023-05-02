package com.boaEntrega.servicos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boaEntrega.servicos.entity.EnderecoEntity;
import com.boaEntrega.servicos.response.CadastroEnderecoResponse;
import com.boaEntrega.servicos.service.EnderecoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/endereco")
public class EnderecoControler {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping
	@ApiOperation(value = "Cadastra um novo endereço para o cliente" )
	public ResponseEntity<CadastroEnderecoResponse> cadastra(@RequestBody EnderecoEntity enderecoEntity) {
		CadastroEnderecoResponse retorno = enderecoService.cadastrar(enderecoEntity);
		return ResponseEntity.ok(retorno);
	}

	@GetMapping
	@ApiOperation(value = "Cadastra um novo endereço para o cliente" )
	public ResponseEntity<CadastroEnderecoResponse> consulta(@RequestBody EnderecoEntity enderecoEntity) {
		CadastroEnderecoResponse retorno = enderecoService.cadastrar(enderecoEntity);
		return ResponseEntity.ok(retorno);
	}
	
	@PutMapping
	@ApiOperation(value = "Consulta uma lista de endereço do cliente" )
	public ResponseEntity<CadastroEnderecoResponse> edita(@RequestParam String email) {
		return ResponseEntity.ok(null);
	}

	@GetMapping("{id}/detalha")
	@ApiOperation(value = "Detalha um endereço do cliente" )
	public ResponseEntity<String> detalha(String valor) {
		return ResponseEntity.ok(null);
	}

}
