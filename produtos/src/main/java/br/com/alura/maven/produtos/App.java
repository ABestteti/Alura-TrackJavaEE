package br.com.alura.maven.produtos;

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
