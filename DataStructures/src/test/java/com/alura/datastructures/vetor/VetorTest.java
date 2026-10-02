package com.alura.datastructures.vetor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VetorTest {
    @Test
    public void growsInsertsAndRemovesWhilePreservingOrder() {
        Vetor vetor = new Vetor();
        Aluno ana = new Aluno("Ana");
        Aluno bia = new Aluno("Bia");
        Aluno caio = new Aluno("Caio");

        vetor.adiciona(ana);
        vetor.adiciona(caio);
        vetor.adiciona(1, bia);

        assertEquals(3, vetor.tamanho());
        assertEquals(ana, vetor.pega(0));
        assertEquals(bia, vetor.pega(1));
        assertEquals(caio, vetor.pega(2));
        assertTrue(vetor.posicaoOcupada(2));
        assertFalse(vetor.posicaoOcupada(3));
        assertTrue(vetor.contem(bia));

        vetor.remove(1);

        assertEquals(2, vetor.tamanho());
        assertEquals(caio, vetor.pega(1));
        assertFalse(vetor.contem(bia));
    }

    @Test(expected = IllegalArgumentException.class)
    public void pegaRejectsNegativePosition() {
        new Vetor().pega(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pegaRejectsPositionAtSize() {
        new Vetor().pega(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertRejectsPositionBeyondSize() {
        new Vetor().adiciona(1, new Aluno("Ana"));
    }
}
