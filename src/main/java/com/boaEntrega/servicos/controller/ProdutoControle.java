package com.boaEntrega.servicos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boaEntrega.servicos.entity.ProdutoEntity;
import com.boaEntrega.servicos.response.ConsultaProdutoResponse;
import com.boaEntrega.servicos.service.ProdutoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoControle {

	@Autowired
	private ProdutoService produtoService;

	@PostMapping
	@ApiOperation(value = "Cadastra um novo produto" )
	public ResponseEntity<String> cadastra(@RequestBody ProdutoEntity produtoEntity) {

		String retorno = produtoService.cadastrar(produtoEntity);

		return ResponseEntity.ok(retorno);
	}

	@PutMapping("{id}/alterar")
	@ApiOperation(value = "Edita um produto" )
	public ResponseEntity<String> altera(@RequestBody ProdutoEntity produtoEntity) {

		String retorno = produtoService.alterar(produtoEntity);

		return ResponseEntity.ok(retorno);
	}

	@GetMapping("/consulta")
	@ApiOperation(value = "Consulta um produto" )
	public ResponseEntity<List<ConsultaProdutoResponse>> consultarProduto(@RequestParam String codigoRastreio) {
		System.out.println("Produtos " + codigoRastreio);
		List<ConsultaProdutoResponse> consultaProdutoResponseDTOs = produtoService.consultarProduto(codigoRastreio);
		if (!consultaProdutoResponseDTOs.isEmpty()) {
			return ResponseEntity.ok(consultaProdutoResponseDTOs);
		} else {
			return new ResponseEntity<List<ConsultaProdutoResponse>>(HttpStatus.NOT_FOUND);
		}
	}

}
