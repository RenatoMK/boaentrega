package com.boaEntrega.servicos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ENDERECO")
public class EnderecoEntity {

	@GeneratedValue(generator = "SEQUENCE_ENDERECO", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQUENCE_ENDERECO", sequenceName = "SEQ_ENDERECO", allocationSize = 1)
	@Id
	@JsonIgnore
	@Column(name = "ID_ENDERECO")
	private Long idEndereco;

	@JsonProperty("nomeLogradouro")
	@Column(name = "DESCRICAO_LOGRADOURO")
	private String descricaoLogradouro;

	@JsonProperty("numeroLogradouro")
	@Column(name = "NUMERO_LOGRADOURO")
	private String numeroLogradouro;

	@JsonProperty("cep")
	@Column(name = "CEP")
	private String cep;

	@JsonProperty("cidade")
	@Column(name = "CIDADE")
	private String cidade;

	@JsonProperty("estado")
	@Column(name = "ESTADO")
	private String estado;

	@JsonProperty("pais")
	@Column(name = "PAIS")
	private String pais;

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getDescricaoLogradouro() {
		return descricaoLogradouro;
	}

	public void setDescricaoLogradouro(String descricaoLogradouro) {
		this.descricaoLogradouro = descricaoLogradouro;
	}

	public String getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(String numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
