package com.alura.datastructures.conjunto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class ConjuntoTest {
    @Test
    public void addingIsIdempotentAndRemovingRestoresEmptyState() {
        Conjunto conjunto = new Conjunto();
        String estadoVazio = conjunto.toString();

        conjunto.adiciona("java");
        String estadoComElemento = conjunto.toString();
        assertNotEquals(estadoVazio, estadoComElemento);

        conjunto.adiciona("java");
        assertEquals(estadoComElemento, conjunto.toString());

        conjunto.remove("java");
        assertEquals(estadoVazio, conjunto.toString());

        conjunto.remove("ausente");
        assertEquals(estadoVazio, conjunto.toString());
    }
}
