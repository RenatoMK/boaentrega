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

import com.boaEntrega.servicos.entity.ClienteEntity;
import com.boaEntrega.servicos.response.CadastroClienteResponse;
import com.boaEntrega.servicos.service.ClienteService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	@PostMapping
	@ApiOperation(value = "Cadastra um novo cliente" )
	public ResponseEntity<CadastroClienteResponse> cadastro(@RequestBody ClienteEntity dadosCliente) {

		CadastroClienteResponse retorno = clienteService.cadastrar(dadosCliente);

		return ResponseEntity.ok(retorno);
	}

	@PutMapping("{id}/edita")
	@ApiOperation(value = "Edita um cliente" )
	public ResponseEntity<String> edita(@RequestBody ClienteEntity dadosCliente) {

		String retorno = clienteService.alterar(dadosCliente);

		return ResponseEntity.ok(retorno);
	}

	@GetMapping
	@ApiOperation(value = "Consulta uma lista de clientes" )
	public ResponseEntity<ClienteEntity> consultaCliente(@RequestParam String email) {
		return ResponseEntity.ok(clienteService.consultarCliente(email));
	}

	@GetMapping("{id}/detalha")
	@ApiOperation(value = "Detalha um cliente" )
	public ResponseEntity<String> detalha(String valor) {

		String retorno = clienteService.detalhar(valor);

		return ResponseEntity.ok(retorno);
	}

}
