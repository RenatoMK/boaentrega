package com.boaEntrega.servicos.response;

import java.io.Serializable;

public class ErrorResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3843107060694350753L;
	private String mensagem;
	
	public ErrorResponse(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	

}
