package com.boaEntrega.servicos.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HISTORICO_PRODUTO")
public class ProdutoHistoricoEntity {

	@GeneratedValue(generator = "SEQUENCE_HISTORICO_PRODUTO", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQUENCE_HISTORICO_PRODUTO", sequenceName = "SEQ_HISTORICO_PRODUTO", allocationSize = 1)
	@Id
	@Column(name = "ID_HISTORICO_PRODUTO")
	private Long idHistoricoProduto;

	@Column(name = "ID_PRODUTO")
	private Long idProduto;

	@Column(name = "ID_DEPOSITO")
	private Long idDeposito;

	@Column(name = "DESCRICAO_HISTORICO")
	private String descricaoHistorico;

	@Column(name = "DATA_REGISTRO")
	private Date dataRegistro;

	public Long getIdHistoricoProduto() {
		return idHistoricoProduto;
	}

	public void setIdHistoricoProduto(Long idHistoricoProduto) {
		this.idHistoricoProduto = idHistoricoProduto;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Long getIdDeposito() {
		return idDeposito;
	}

	public void setIdDeposito(Long idDeposito) {
		this.idDeposito = idDeposito;
	}

	public String getDescricaoHistorico() {
		return descricaoHistorico;
	}

	public void setDescricaoHistorico(String descricaoHistorico) {
		this.descricaoHistorico = descricaoHistorico;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

}
