package com.boaEntrega.servicos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PERFIL_CLIENTE")
public class PerfilClienteEntity {
	
	@GeneratedValue(generator="SEQUENCE_PERFIL", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="SEQUENCE_PERFIL",sequenceName="SEQ_PERFIL", allocationSize=1)
	@Id
	@Column(name = "ID_PERFIL")
	private Long idPerfil;
	
	@Column(name = "DESCRICAO_PERFIL")
	private String descricaoPerfil;
	
}
