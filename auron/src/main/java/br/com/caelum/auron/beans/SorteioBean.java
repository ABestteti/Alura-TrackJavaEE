package br.com.caelum.auron.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.caelum.auron.modelo.Sorteador;
import br.com.caelum.auron.modelo.Sorteio;
import br.com.caelum.auron.modelo.SorteioException;
import br.com.caelum.auron.modelo.Participante;

@Named
@RequestScoped
public class SorteioBean {
	private Sorteio sorteio = new Sorteio();

	public Sorteio getSorteio() {
		return sorteio;
	}
	
	public void sortear() throws SorteioException {
		List<Participante> participantes = new ArrayList<>();
		Sorteador sorteador = new Sorteador(sorteio, participantes);
		
		try {
			sorteador.sortear();
		} catch (SorteioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Sorteio: " + sorteio.getNome());
	}
}
