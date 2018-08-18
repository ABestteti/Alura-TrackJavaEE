package com.alura.datastructures.linkedlist;

public class ListaLigada {

	private Celula primeira  = null;
	private Celula ultimo    = null;
	private int totalElementos = 0;

	public void adicionaNoComeco(Object elemento) {
		Celula nova = new Celula(elemento, this.primeira);
		
		this.primeira = nova;
		
		if (this.ultimo == null) {
			// Memoriza o ultimo elemento da lista
			this.ultimo = this.primeira;
		}
		
		this.totalElementos++;
	}
	
	public void adiciona(Object elemento) {
		
		if (this.totalElementos == 0) {
			// Se a lista esta vazia, inicia com o primeiro elemento.
			adiciona(elemento);
		} else {
			// Adiciona no fim da Lista
			Celula nova = new Celula(elemento, null);

			this.ultimo.setProximo(nova);
			this.ultimo = nova;

			this.totalElementos++;
		}
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalElementos;
	}
	
	private Celula pegaCelula(int posicao) {
		
		if (!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posicao invalida: " + posicao);
		}
		
		Celula atual = primeira;
		
		for(int i = 0; i < posicao; i++) {
			atual = atual.getProximo();
		}
		
		return atual;
	}
	
	public void adiciona(int posicao, Object elemento) {
		if (posicao == 0) {
			adicionaNoComeco(elemento);
		} else if (posicao == totalElementos) {
			adiciona(elemento);
		} else {
			Celula anterior = this.pegaCelula(posicao - 1);
			Celula nova = new Celula(elemento, anterior.getProximo());
			anterior.setProximo(nova);
			this.totalElementos++;
		}
	}
	
	public Object pega(int posicao) {
		return this.pegaCelula(posicao).getElemento();
	}
	
	public void removeDoComeco() {
		if (totalElementos == 0) {
			throw new IllegalArgumentException("A lista está vazia");
		}
		
		this.primeira = this.primeira.getProximo();
		this.totalElementos--;
		
		if (this.totalElementos == 0) {
			this.ultimo = null;
		}
	}
		
	public void remove(int posicao) {
		;
	}
	
	public int tamanho() {
		return this.totalElementos;
	}
	
	public boolean contem(Object elemento) {
		
		Celula atual = this.primeira;
		
		while(atual != null) {
			if (atual.getElemento().equals(elemento)) {
				return true;
			}
			
			atual = atual.getProximo();
		}
		return false;
	}
	
	public String toString() {
		if (this.totalElementos == 0) {
			return "[]";
		}
		
		Celula atual = primeira;
		
		StringBuilder builder = new StringBuilder("[");
		
		for(int i = 0; i < totalElementos; i++) {
			builder.append(atual.getElemento());
			builder.append(",");
			
			atual = atual.getProximo();
		}
		
		builder.append("]");
		
		return builder.toString();
	}
	
}
