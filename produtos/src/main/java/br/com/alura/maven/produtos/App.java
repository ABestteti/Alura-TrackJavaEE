package br.com.alura.maven.produtos;

import br.com.alura.maven.produtos.Produto;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		Produto produto = new Produto("Bala", 0.15);
		
		System.out.println("Produto " + produto.getNome() + " custa " + produto.getPreco());
	}
}
