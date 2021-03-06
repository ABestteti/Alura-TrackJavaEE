package br.com.caelum.auron.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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
	public void setUp() throws Exception {
		p1 = new Participante();
        p1.setNome("Leonardo");
        
        p2 = new Participante();
        p2.setNome("Nico");
        
        p3 = new Participante();
        p3.setNome("Fábio");
        
        participantes = Arrays.asList(p1, p2, p3);        
        sorteio = new Sorteio();

	}
		
	@Test
	public void aQuantidadeDeParesEParticipantesDeveSerAMesma() throws SorteioException {
		int quantidadeDeParticipantes = participantes.size();

		Sorteador sorteador = new Sorteador(sorteio, participantes);
		sorteador.sortear();

		int quantidadeDePares = sorteio.getQuantidadeDePares();		
		Assert.assertTrue(quantidadeDePares == quantidadeDeParticipantes);
		//Assert.assertEquals(quantidadeDePares, quantidadeDeParticipantes);
		
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
	
	@Test(expected=SorteioException.class)
	public void naoDeveAceitarUmaListaComMenosDeDoisParticipantes() throws SorteioException {
		Sorteador sorteador = new Sorteador(sorteio, new ArrayList<Participante>());
		sorteador.sortear();	
	}

	@Test(expected=SorteioException.class)
	public void naoDeveAceitarUmaListaDeParticipantesNula() throws SorteioException {
		Sorteador sorteador = new Sorteador(sorteio, null);
	}
	
	@Test
	public void naoDeveRepetirUmAmigo() throws SorteioException {
		Sorteador sorteador = new Sorteador(sorteio, participantes);
		sorteador.sortear();
		
		Set<Par> pares = sorteio.getPares();
		Iterator<Par> it = pares.iterator();
		
		Par par1 = it.next();
		Par par2 = it.next();
		Par par3 = it.next();
		
		Participante amigo1 = par1.getAmigo();
		Participante amigo2 = par2.getAmigo();
		Participante amigo3 = par3.getAmigo();
		
		assertFalse(amigo1.equals(amigo2));
		assertFalse(amigo2.equals(amigo3));
		assertFalse(amigo3.equals(amigo1));
	}
	
	@Test
	public void deveVerificarSeAmigoEhDiferenteDeAmigoOculto() throws SorteioException {
		Sorteador sorteador = new Sorteador(sorteio, participantes);
		sorteador.sortear();
		
		Set<Par> pares = sorteio.getPares();
		Iterator<Par> it = pares.iterator();
		
		Par par1 = it.next();
		Par par2 = it.next();
		Par par3 = it.next();
		
		Participante amigo1 = par1.getAmigo();
		Participante amigoOculto1 = par1.getAmigoOculto();
		
		Participante amigo2 = par2.getAmigo();
		Participante amigoOculto2 = par2.getAmigoOculto();

		Participante amigo3 = par3.getAmigo();
		Participante amigoOculto3 = par3.getAmigoOculto();
		
		assertFalse(amigo1.equals(amigoOculto1));
		assertFalse(amigo2.equals(amigoOculto2));
		assertFalse(amigo3.equals(amigoOculto3));
		
	}
	
	@Test
	public void deveVerificarSeAmigoOcultoDoUltimoParEhAmigoDoPrimeiroPar() throws SorteioException {
		Sorteador sorteador = new Sorteador(sorteio, participantes);
		sorteador.sortear();
		
		Set<Par> pares = sorteio.getPares();
		Iterator<Par> it = pares.iterator();
		
		Par par1 = it.next();
		it.next();
		Par par3 = it.next();
		
		Participante primeiro = par1.getAmigo();
		Participante ultimo   = par3.getAmigoOculto();
		
		assertTrue(ultimo.equals(primeiro));
	}
}
