package com.alura.datastructures.conjunto;

public class TesteConjunto {

	public static void main(String[] args) {
		Conjunto conjunto = new Conjunto();
		
		conjunto.adiciona("Mauricio");
		System.out.println(conjunto);

		conjunto.adiciona("Marli");
		System.out.println(conjunto);
		
		conjunto.adiciona("Anderson");
		System.out.println(conjunto);
		
		conjunto.remove("Mauricio");
		System.out.println(conjunto);
	}

}
