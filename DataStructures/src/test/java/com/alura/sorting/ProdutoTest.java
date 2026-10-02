package com.alura.sorting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProdutoTest {
    @Test
    public void exposesNameAndPriceProvidedAtConstruction() {
        Produto produto = new Produto("Livro", 29.90);

        assertEquals("Livro", produto.getNome());
        assertEquals(29.90, produto.getPreco(), 0.0);
    }
}
