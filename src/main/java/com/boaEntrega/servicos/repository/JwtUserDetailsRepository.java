package com.boaEntrega.servicos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.boaEntrega.servicos.entity.ClienteEntity;

@Repository
public class JwtUserDetailsRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public ClienteEntity consultarCliente(String email) {

		Query query = em.createQuery(" SELECT v FROM ClienteEntity v WHERE EMAIL= :email", ClienteEntity.class)
				.setParameter("email", email);
		List<ClienteEntity> clienteEntityList = query.getResultList();
		if(clienteEntityList.size() > 0) {
			return clienteEntityList.get(0);
		} else {
			return null;
		}

	}

}
