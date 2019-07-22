package br.com.caelum.auron.modelo;

import java.util.List;

public class Sorteador {
	
    private List<Participante> participantes;
    private int totalDeParticipantes;
	private Sorteio sorteio;

    public Sorteador(Sorteio sorteio, List<Participante> participantes) throws SorteioException {
    	
    	if (participantes == null) {
    		throw new SorteioException("Um sorteio nao pode ser criado com a lista de participantes nula.");
    	}
    	
        this.participantes = participantes;
        this.sorteio = sorteio;
    }
	
	public void sortear() throws SorteioException {
		int indiceAtual = 0;
	    int totalDeParticipantes = participantes.size();
	    
	    if (totalDeParticipantes < 2) {
	    	throw new SorteioException("O Numero de participantes nao pode ser menor que dois.");
	    }

	    while(indiceAtual < totalDeParticipantes) {
	    	if(indiceAtual == totalDeParticipantes - 1) {
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
