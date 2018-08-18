package com.alura.datastructures.vetor;

public class VetorTeste {
	public static void main(String[] args) {
		Aluno a1 = new Aluno("Joao");
		Aluno a2 = new Aluno("Jose");
		Aluno a3 = new Aluno("Danilo");
		Aluno a4 = new Aluno("Daiela");
		
		Vetor lista = new Vetor();
		
		System.out.println(lista.tamanho());
		lista.adiciona(a1);
		
		System.out.println(lista.tamanho());
		lista.adiciona(a2);
		
		System.out.println(lista.toString());
		
		System.out.println(lista.tamanho());
        lista.adiciona(1,a3);
        
        System.out.println(lista.toString());
        
        lista.adiciona(2,a4);
        
        System.out.println(lista.toString());
        
		System.out.println("Tamanho do vertor: " + lista.tamanho());		
		System.out.println("Procurando " + a4.getNome() + " no vetor: " + lista.contem(a4));
		
		System.out.println("Removendo elemento 0: " + lista.pega(0).getNome());
		lista.remove(0);

		System.out.println(lista.toString());
		
	}
}
