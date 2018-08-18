package com.alura.datastructures.pilha;

public class TestaPilha {

	public static void main(String[] args) {
		Pilha pilha = new Pilha();
		
		System.out.println(pilha);
		pilha.push("Anderson");
		System.out.println(pilha);
		pilha.push("Patricia");
		System.out.println(pilha);
		pilha.push("Livia");
		System.out.println(pilha);

		System.out.println(pilha.pop());
		System.out.println(pilha.isEmpty());
		
		System.out.println(pilha.pop());
		System.out.println(pilha.isEmpty());
		
		System.out.println(pilha);
	}

}
