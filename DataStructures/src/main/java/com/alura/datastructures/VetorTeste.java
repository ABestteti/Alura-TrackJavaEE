package com.alura.datastructures;

public class VetorTeste {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("joao");
		Aluno a2 = new Aluno("Jose");
		
		Vetor lista = new Vetor();
		System.out.println(lista.tamanho());
		lista.adiciona(a1);
		System.out.println(lista.tamanho());
		lista.adiciona(a2);
		System.out.println(lista.tamanho());

		Aluno a3 = new Aluno("Danilo");
		lista.adiciona(1,a3);
		System.out.println(lista.tamanho());
		
		System.out.println(lista.contem(a1));
				
		lista.remove(0);

		System.out.println(lista.toString());
		
	}
}
