package org.auron.beans;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.auron.dao.ParticipanteDao;
import org.auron.modelo.Participante;

@Named
@RequestScoped
public class ParticipanteBean {
	
	@Inject
	private ParticipanteDao participanteDao;
	
	private Participante participante = new Participante();
	
	public void cadastrar() {
		System.out.println(participante.getNome());
		participanteDao.inserir(participante);
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	
}
