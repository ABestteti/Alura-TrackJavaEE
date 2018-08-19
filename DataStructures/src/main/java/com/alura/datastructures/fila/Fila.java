package com.alura.datastructures.fila;

import java.util.LinkedList;
import java.util.List;

public class Fila {
	private List<String> alunos = new LinkedList<String>();
	
	public void adiciona(String aluno) {
		alunos.add(aluno);
	}
	
	public String remove() {
		return alunos.remove(0);
	}
	
	public boolean vazia() {
		return alunos.isEmpty();
	}
	
	public boolean contem(String aluno) {
		return alunos.contains(aluno);
	}
	
 	@Override
	public String toString() {
		return alunos.toString();
	}
}
