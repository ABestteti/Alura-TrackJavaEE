package com.alura.datastructures.vetor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class AlunoTest {
    @Test
    public void exposesAndUpdatesNameAndComparesByName() {
        Aluno aluno = new Aluno("Ana");

        assertEquals("Ana", aluno.getNome());
        assertEquals(new Aluno("Ana"), aluno);
        assertNotEquals(new Aluno("Bia"), aluno);

        aluno.setNome("Amanda");

        assertEquals("Amanda", aluno.getNome());
        assertEquals("Amanda", aluno.toString());
        assertEquals(new Aluno("Amanda"), aluno);
    }
}
