package com.alura.datastructures.pilha;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PilhaTest {
    @Test
    public void pushAndPopUseLastInFirstOutOrder() {
        Pilha pilha = new Pilha();

        assertTrue(pilha.isEmpty());
        pilha.push("Ana");
        pilha.push("Bia");

        assertFalse(pilha.isEmpty());
        assertEquals("[Ana, Bia]", pilha.toString());
        assertEquals("Bia", pilha.pop());
        assertEquals("Ana", pilha.pop());
        assertTrue(pilha.isEmpty());
    }
}
