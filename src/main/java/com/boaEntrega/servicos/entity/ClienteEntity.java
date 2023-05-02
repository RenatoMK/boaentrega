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
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CLIENTE")
public class ClienteEntity {

	@GeneratedValue(generator="SEQUENCE_CLIENTE", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="SEQUENCE_CLIENTE",sequenceName="SEQ_CLIENTE", allocationSize=1)
	@Id
	@JsonIgnore
	@Column(name = "ID_CLIENTE")
	private Long idCliente;
	
	@JsonProperty("nomeCliente")
	@Column(name = "NOME_CLIENTE")
	private String nomeCliente;
	
	@JsonProperty("tipoPessoa")
	@Column(name = "TIPO_CLIENTE")
	private String tipoCliente;
	
	@JsonIgnore
	@Column(name = "PERFIL_CLIENTE")
	private Long perfilCliente;
	
	@JsonProperty("numeroDocumento")
	@Column(name = "NUMERO_DOCUMENTO")
	private String numeroDocumento;
	
	@JsonIgnore
	@Column(name = "DATA_EVENTO")
	private Date dataEvento;
	
	@JsonProperty("eMail")
	@Column(name = "EMAIL")
	private String email;
	
	@JsonIgnore
	@Column(name = "SENHA")
	private String senha;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getPerfilCliente() {
		return perfilCliente;
	}

	public void setPerfilCliente(Long perfilCliente) {
		this.perfilCliente = perfilCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
}
