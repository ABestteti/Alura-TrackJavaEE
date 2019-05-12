package org.auron.beans;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.auron.modelo.Participante;

@Named
@RequestScoped
public class ParticipanteBean {
	private Participante participante = new Participante();
	
	public void cadastrar() {
		System.out.println(participante.getNome());
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	
}
