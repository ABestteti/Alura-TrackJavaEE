package br.com.caelum.auron.modelo;

import java.util.Collections;
import java.util.List;

public class Sorteador {
	
    private List<Participante> participantes;
	private Sorteio sorteio;
	private int totalDeParticipantes;

    public Sorteador(Sorteio sorteio, List<Participante> participantes) throws SorteioException {
    	
    	if (participantes == null) {
    		throw new SorteioException("Um sorteio nao pode ser criado com a lista de participantes nula.");
    	}
    	
        this.participantes = participantes;
        this.sorteio = sorteio;
        this.totalDeParticipantes = participantes.size();
    }
	
	public void sortear() throws SorteioException {
		verificaTamanhoDaListaDeParticipantes();
		embaralhaParticipante();
				
	    int indiceAtual = 0;
	    while(indiceAtual < totalDeParticipantes) {
	    	if(participanteAtualEhOUltimoDaLista(indiceAtual)) {
	            criaEAdicionaOParNoSorteio(sorteio, indiceAtual, 0);
	            break;
	        }

	        criaEAdicionaOParNoSorteio(sorteio, indiceAtual, ++indiceAtual);
	    }
    }

	private void embaralhaParticipante() {
		Collections.shuffle(participantes);
	}

	private void verificaTamanhoDaListaDeParticipantes() throws SorteioException {
		if (totalDeParticipantes < 2) {
	    	throw new SorteioException("O Numero de participantes nao pode ser menor que dois.");
	    }
	}

	private boolean participanteAtualEhOUltimoDaLista(int indiceAtual) {
		return indiceAtual == totalDeParticipantes - 1;
	}

	private void criaEAdicionaOParNoSorteio(Sorteio sorteio, int indiceAtual, int indiceFinal) {
		sorteio.adicionaPar(new Par(participantes.get(indiceAtual), participantes.get(indiceFinal), sorteio));
	}
}
