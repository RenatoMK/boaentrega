package com.boaEntrega.servicos.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boaEntrega.servicos.entity.ProdutoEntity;
import com.boaEntrega.servicos.repository.ProdutoRepository;
import com.boaEntrega.servicos.response.ConsultaProdutoResponse;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;

	public String cadastrar(ProdutoEntity produtoEntity) {
		produtoEntity.setDataEvento(new Date());
		return produtoRepository.cadastrar(produtoEntity);
	}

	public String alterar(ProdutoEntity produtoEntity) {
		produtoEntity.setDataEvento(new Date());
		return produtoRepository.alterar(produtoEntity);
	}

	public List<ConsultaProdutoResponse> consultarProduto(String codigoRastreio) {
		return produtoRepository.consultarProduto(codigoRastreio);
	}

}
