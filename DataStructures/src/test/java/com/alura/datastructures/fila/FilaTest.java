package com.alura.datastructures.fila;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FilaTest {
    @Test
    public void startsEmptyAndRemovesInInsertionOrder() {
        Fila fila = new Fila();

        assertTrue(fila.vazia());
        assertFalse(fila.contem("Ana"));

        fila.adiciona("Ana");
        fila.adiciona("Bia");

        assertFalse(fila.vazia());
        assertTrue(fila.contem("Ana"));
        assertEquals("Ana", fila.remove());
        assertFalse(fila.contem("Ana"));
        assertEquals("Bia", fila.remove());
        assertTrue(fila.vazia());
    }
}
