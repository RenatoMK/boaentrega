package com.boaEntrega.servicos.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PRODUTO")
public class ProdutoEntity {

	@GeneratedValue(generator = "SEQUENCE_PRODUTO", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQUENCE_PRODUTO", sequenceName = "SEQ_PRODUTO", allocationSize = 1)
	@Id
	@JsonIgnore
	@Column(name = "ID_PRODUTO")
	private Long idProduto;

	@Column(name = "COD_CLIENTE")
	private String codCliente;

	@Column(name = "ID_ENDERECO")
	private Long idEndereco;
	
	@Column(name = "ID_DEPOSITO")
	private Long idDeposito;

	@JsonIgnore
	@Column(name = "CODIGO_RASTREIO")
	private String codigoRastreio;
	
	@Column(name = "DATA_EVENTO")
	private Date dataEvento;
	
	@Column(name = "DESCRICAO")
	private String descricao;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getCodCliente() {
		return codCliente;
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public Long getIdDeposito() {
		return idDeposito;
	}

	public void setIdDeposito(Long idDeposito) {
		this.idDeposito = idDeposito;
	}

	public String getCodigoRastreio() {
		return codigoRastreio;
	}

	public void setCodigoRastreio(String codigoRastreio) {
		this.codigoRastreio = codigoRastreio;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
