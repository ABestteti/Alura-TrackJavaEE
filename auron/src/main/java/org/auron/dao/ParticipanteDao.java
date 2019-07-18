package org.auron.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.auron.modelo.Participante;

@Stateless
public class ParticipanteDao {

	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Participante participante) {
		em.persist(participante);
	}

	public List<Participante> getParticipantes() {
		return em.createQuery("select p from Participante p", Participante.class).getResultList();
	}
}