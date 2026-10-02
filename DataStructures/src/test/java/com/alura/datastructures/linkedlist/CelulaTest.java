package com.alura.datastructures.linkedlist;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class CelulaTest {
    @Test
    public void storesElementAndUpdatesLinks() {
        Celula proxima = new Celula("next", null);
        Celula celula = new Celula("current", proxima);
        Celula anterior = new Celula("previous", celula);

        assertSame("current", celula.getElemento());
        assertSame(proxima, celula.getProximo());
        assertNull(celula.getAnterior());

        celula.setAnterior(anterior);
        celula.setProximo(null);

        assertSame(anterior, celula.getAnterior());
        assertNull(celula.getProximo());
    }
}
