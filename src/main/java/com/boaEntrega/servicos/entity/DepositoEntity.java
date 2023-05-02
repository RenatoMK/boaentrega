package com.boaEntrega.servicos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEPOSITO")
public class DepositoEntity {
	
	@GeneratedValue(generator="SEQUENCE_DEPOSITO", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="SEQUENCE_DEPOSITO",sequenceName="SEQ_DEPOSITO", allocationSize=1)
	@Id
	@Column(name = "ID_DEPOSITO")
	private Long idDeposito;

	@Column(name = "NOME_DEPOSITO")
	private String nomeDeposito;

	@Column(name = "ID_CLIENTE")
	private Long idCliente;

}
