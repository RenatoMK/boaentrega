package com.boaEntrega.servicos.response;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConsultaProdutoResponse {

	private String descricaohistorico;
	@Id
	private String dataregistro;
	private String nomedeposito;
	public String getDescricaohistorico() {
		return descricaohistorico;
	}
	public void setDescricaohistorico(String descricaohistorico) {
		this.descricaohistorico = descricaohistorico;
	}
	public String getDataregistro() {
		return dataregistro;
	}
	public void setDataregistro(String dataregistro) {
		this.dataregistro = dataregistro;
	}
	public String getNomedeposito() {
		return nomedeposito;
	}
	public void setNomedeposito(String nomedeposito) {
		this.nomedeposito = nomedeposito;
	}
	

	
}
