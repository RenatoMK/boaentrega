package com.boaEntrega.servicos.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.boaEntrega.servicos.entity.ClienteEntity;
import com.boaEntrega.servicos.response.CadastroClienteResponse;

@Repository
public class ClienteRepository {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public CadastroClienteResponse cadastrar(ClienteEntity dadosCliente) {

		em.persist(dadosCliente);
		Query query = em
				.createNativeQuery(
						"Select Max(id_cliente) from CLIENTE");
		CadastroClienteResponse cadastroClienteResponse = new CadastroClienteResponse();
		
		cadastroClienteResponse.setIdCliente(query.getSingleResult().toString());
		
		return cadastroClienteResponse;
	}

	@Transactional
	public String alterar(ClienteEntity dadosCliente) {
		Query query = em
				.createNativeQuery(
						"UPDATE CLIENTE SET " + "NOME_CLIENTE = :NOME_CLIENTE, TIPO_CLIENTE = :TIPO_CLIENTE, "
								+ "NUMERO_DOCUMENTO = :NUMERO_DOCUMENTO, DATA_EVENTO = SYSDATE, "
								+ "PERFIL_CLIENTE = :PERFIL_CLIENTE WHERE ID_CLIENTE = :ID_CLIENTE ")
				.setParameter("NOME_CLIENTE", dadosCliente.getNomeCliente())
				.setParameter("TIPO_CLIENTE", dadosCliente.getTipoCliente())
				.setParameter("NUMERO_DOCUMENTO", dadosCliente.getNumeroDocumento())
				.setParameter("PERFIL_CLIENTE", dadosCliente.getPerfilCliente())
				.setParameter("ID_CLIENTE", dadosCliente.getIdCliente());
		
		query.getSingleResult();

		return "Sucesso";
	}

//	public ClienteEntity consultar(String atributoBusca, String valor) {
//		Query query = em.createNativeQuery(
//				"SELECT ID_CLIENTE AS idCliente, " + " NOME_CLIENTE AS nomeCliente, " + " TIPO_CLIENTE AS tipoCliente, "
//						+ " NUMERO_DOCUMENTO AS perfilCliente, " + " DATA_EVENTO AS numeroDocumento, "
//						+ " PERFIL_CLIENTE AS dataEvento " + " FROM CLIENTE WHERE " + atributoBusca + " = " + valor,
//				ClienteEntity.class);
//		ClienteEntity clienteEntity = (com.boaEntrega.servicos.entity.ClienteEntity) query.getSingleResult();
//
//		return clienteEntity;
//	}

	public ClienteEntity consultarCliente(String email) {

		Query query = em.createQuery(" SELECT v FROM ClienteEntity v WHERE EMAIL= :email", ClienteEntity.class)
				.setParameter("email", email);

		return (ClienteEntity) query.getSingleResult();

	}

	@Transactional
	public String detalhar(String valor) {
		Query query = em.createNativeQuery("DELETE FROM CLIENTE WHERE ID_CLIENTE = " + valor);
		query.executeUpdate();
		return "Sucesso";
	}
}
