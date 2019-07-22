package br.com.caelum.auron.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.auron.dao.ParticipanteDao;
import br.com.caelum.auron.modelo.Participante;

@Named
@RequestScoped
public class ParticipanteBean {
	
	@Inject
	private ParticipanteDao participanteDao;
	
	private Participante participante = new Participante();
	
	public void cadastrar() {
		System.out.println("Gravando participante: " + participante.getNome());
		participanteDao.inserir(participante);
	}

	public Participante getParticipante() {
		return participante;
	}
	
	public List<Participante> getParticipantes() {
		return participanteDao.getParticipantes();
	}
}
