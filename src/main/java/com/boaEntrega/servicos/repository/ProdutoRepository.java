package com.boaEntrega.servicos.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.boaEntrega.servicos.entity.ProdutoEntity;
import com.boaEntrega.servicos.entity.ProdutoHistoricoEntity;
import com.boaEntrega.servicos.response.ConsultaProdutoResponse;

@Repository
public class ProdutoRepository {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public String cadastrar(ProdutoEntity produtoEntity) {

		em.persist(produtoEntity);
		produtoEntity.setDataEvento(new Date());
		ProdutoHistoricoEntity produtoHistoricoEntity = new ProdutoHistoricoEntity();
		produtoHistoricoEntity.setDataRegistro(new Date());
		produtoHistoricoEntity.setIdDeposito(produtoEntity.getIdDeposito());
		produtoHistoricoEntity.setDescricaoHistorico(produtoEntity.getDescricao());
		produtoHistoricoEntity.setIdProduto(produtoEntity.getIdProduto());
		em.persist(produtoHistoricoEntity);

		Query query = em.createNativeQuery("Select Max(id_produto) from PRODUTO");
		produtoEntity.setCodigoRastreio(geraCodigoRastreio(query.getSingleResult().toString()));
		em.persist(produtoEntity);

		return "Sucesso";
	}

	private String geraCodigoRastreio(String idProduto) {

		while (idProduto.length() < 10) {
			idProduto = '0' + idProduto;
		}

		idProduto = "NA" + idProduto + "BR";
		return idProduto;
	}

	@Transactional
	public String alterar(ProdutoEntity produtoEntity) {
		Query query = em
				.createNativeQuery("UPDATE PRODUTO SET DESCRICAO = :DESCRICAO,  "
						+ "ID_DEPOSITO = :ID_DEPOSITO, DATA_EVENTO = SYSDATE, "
						+ "ID_CLIENTE = :ID_CLIENTE WHERE ID_PRODUTO = :ID_PRODUTO ")
				.setParameter("DESCRICAO", produtoEntity.getDescricao())
				.setParameter("ID_DEPOSITO", produtoEntity.getIdDeposito())
				.setParameter("COD_CLIENTE", produtoEntity.getCodCliente())
				.setParameter("ID_PRODUTO", produtoEntity.getIdProduto());
		query.executeUpdate();

		ProdutoHistoricoEntity produtoHistoricoEntity = new ProdutoHistoricoEntity();
		produtoHistoricoEntity.setDataRegistro(new Date());
		produtoHistoricoEntity.setIdDeposito(produtoEntity.getIdDeposito());
		produtoHistoricoEntity.setDescricaoHistorico(produtoEntity.getDescricao());
		produtoHistoricoEntity.setIdProduto(produtoEntity.getIdProduto());
		em.persist(produtoHistoricoEntity);

		return "Sucesso";
	}

	public List<ConsultaProdutoResponse> consultarProduto(String codigoRastreio) {

		Query query = em.createNativeQuery(
				" select a.DATA_REGISTRO as dataregistro, a.DESCRICAO_HISTORICO as descricaohistorico, c.NOME_DEPOSITO as nomedeposito from HISTORICO_PRODUTO a  "
						+ " inner join PRODUTO b on a.ID_PRODUTO =  b.ID_PRODUTO "
						+ " inner join DEPOSITO c on b.ID_DEPOSITO =c.ID_DEPOSITO "
						+ " where CODIGO_RASTREIO = :codigoRastreio order by a.ID_HISTORICO_PRODUTO desc")
				.setParameter("codigoRastreio", codigoRastreio);

		List<?> resultList = query.getResultList();
		List<ConsultaProdutoResponse> ConsultaProdutoResponseDTOList = new ArrayList();
		if (!resultList.isEmpty()) {
			for (Object objeto : resultList) {
				Object[] obj = new Object[3];
				ConsultaProdutoResponse consultaProdutoResponseDTO = new ConsultaProdutoResponse();
				obj = (Object[]) objeto;

				consultaProdutoResponseDTO.setDataregistro(obj[0].toString());
				consultaProdutoResponseDTO.setDescricaohistorico(obj[1].toString());
				consultaProdutoResponseDTO.setNomedeposito(obj[2].toString());
				ConsultaProdutoResponseDTOList.add(consultaProdutoResponseDTO);
			}
		}

		return ConsultaProdutoResponseDTOList;

	}

}
