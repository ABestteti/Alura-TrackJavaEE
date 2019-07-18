package br.com.caelum.auron.modelo;

import java.util.List;

public class Sorteador {
	
    private List<Participante> participantes;
    private int totalDeParticipantes;
	private Sorteio sorteio;

    public Sorteador(Sorteio sorteio, List<Participante> participantes) {
        this.participantes = participantes;
        this.sorteio = sorteio;
    }
	
	public void sortear() {
		int indiceAtual = 0;
	    int totalDeParticipantes = participantes.size();

	    while(indiceAtual < totalDeParticipantes) {
	    	if(indiceAtual == totalDeParticipantes -1) {
	            Par par = new Par(participantes.get(indiceAtual), participantes.get(0), sorteio);
	            sorteio.adicionaPar(par);
	            break;
	        }

	        Par par = new Par(participantes.get(indiceAtual), participantes.get(indiceAtual + 1), sorteio);
	        sorteio.adicionaPar(par);

	        indiceAtual++;
	    }
    }
}
