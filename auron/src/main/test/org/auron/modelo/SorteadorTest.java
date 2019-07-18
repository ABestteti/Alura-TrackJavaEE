package br.com.caelum.auron.modelo;

import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SorteadorTest {
	
	private Participante p1;
    private Participante p2;
    private Participante p3;

    private List<Participante> participantes;
    private Sorteio sorteio;
    
	@Before
	public void setup() {
		p1 = new Participante();
        p1.setNome("Leonardo");
        p2 = new Participante();
        p2.setNome("Nico");
        p3 = new Participante();
        p3.setNome("Fábio");
        
        sorteio = new Sorteio();

        participantes = Arrays.asList(p1, p2, p3);
	}
	
	@Test
    public void test() { 
    
    }
	
	@Test
	public void aQuantidadeDeParesEParticipantesDeveSerAMesma() {
		int quantidadeDeParticipantes = participantes.size();

		Sorteador sorteador = new Sorteador(sorteio, participantes);
		sorteador.sortear();

		int quantidadeDePares = sorteio.getQuantidadeDePares();		
		//Assert.assertTrue(quantidadeDePares == quantidadeDeParticipantes);
		Assert.assertEquals(quantidadeDePares, quantidadeDeParticipantes);
	}
	
	@Test
	public void naoDeveRepetirUmAmigoOculto() throws Exception {
	    Sorteador sorteador = new Sorteador(sorteio, participantes);
	    sorteador.sortear();

	    Set<Par> pares = sorteio.getPares();
	    Iterator<Par> it = pares.iterator();

	    Par par = it.next();
	    Par par2 = it.next();
	    Par par3 = it.next();

	    Participante amigoOculto1 = par.getAmigoOculto();
	    Participante amigoOculto2 = par2.getAmigoOculto();
	    Participante amigoOculto3 = par3.getAmigoOculto();

	    assertFalse(amigoOculto1.equals(amigoOculto2));
	    assertFalse(amigoOculto2.equals(amigoOculto3));
	    assertFalse(amigoOculto3.equals(amigoOculto1));
	}
}
