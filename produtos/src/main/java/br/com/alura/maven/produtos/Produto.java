package br.com.alura.maven.produtos;

public class Produto {
	private final String nome;
	private final double preco;
	public Produto(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}
	
}
