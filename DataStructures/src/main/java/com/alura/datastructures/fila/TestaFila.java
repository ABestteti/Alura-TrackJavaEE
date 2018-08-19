package com.alura.datastructures.fila;

public class TestaFila {
	public static void main(String[] args) {
		Fila fila = new Fila();
		
		fila.adiciona("Mauricio");
		fila.adiciona("Guilherme");
		
		System.out.println(fila);
		
		System.out.println(fila.remove());
		System.out.println(fila);
	}
}
