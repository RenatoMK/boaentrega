package com.boaEntrega.servicos.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.boaEntrega.servicos.entity.EnderecoEntity;
import com.boaEntrega.servicos.response.CadastroEnderecoResponse;

@Repository
public class EnderecoRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public CadastroEnderecoResponse cadastrar(EnderecoEntity enderecoEntity) {

		em.persist(enderecoEntity);
		Query query = em
				.createNativeQuery(
						"Select Max(id_endereco) from ENDERECO");
		CadastroEnderecoResponse cadastroEnderecoResponse = new CadastroEnderecoResponse();
		
		cadastroEnderecoResponse.setIdEndereco(query.getSingleResult().toString());
		
		return cadastroEnderecoResponse;
	}
	
	public ResponseEntity<CadastroEnderecoResponse> consulta(@RequestBody EnderecoEntity enderecoEntity) {
		return ResponseEntity.ok(null);
	}
	
	public ResponseEntity<CadastroEnderecoResponse> consultaEndereco(@RequestParam String email) {
		return ResponseEntity.ok(null);
	}

	public ResponseEntity<String> detalha(String valor) {
		return ResponseEntity.ok(null);
	}

}
