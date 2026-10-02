package com.alura.datastructures.linkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ListaLigadaTest {
    @Test
    public void insertsAtHeadMiddleAndTailAndRemovesHead() {
        ListaLigada lista = new ListaLigada();
        lista.adicionaNoComeco("Bia");
        lista.adiciona("Caio");
        lista.adiciona(1, "Ana");

        assertEquals(3, lista.tamanho());
        assertEquals("Bia", lista.pega(0));
        assertEquals("Ana", lista.pega(1));
        assertEquals("Caio", lista.pega(2));
        assertTrue(lista.contem("Ana"));
        assertFalse(lista.contem("Duda"));

        lista.removeDoComeco();

        assertEquals(2, lista.tamanho());
        assertEquals("Ana", lista.pega(0));
        assertEquals("Caio", lista.pega(1));
    }

    @Test
    public void removingOnlyElementLeavesListEmpty() {
        ListaLigada lista = new ListaLigada();
        lista.adicionaNoComeco("Ana");

        lista.removeDoComeco();

        assertEquals(0, lista.tamanho());
        assertFalse(lista.contem("Ana"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void gettingElementFromEmptyListIsRejected() {
        new ListaLigada().pega(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removingFromEmptyListIsRejected() {
        new ListaLigada().removeDoComeco();
    }
}
