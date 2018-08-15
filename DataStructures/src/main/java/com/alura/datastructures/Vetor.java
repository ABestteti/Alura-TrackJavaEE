package com.alura.datastructures;

import java.util.Arrays;

public class Vetor {
	private Aluno[] alunos = new Aluno[100];
	
	private int totalAlunos = 0;
	
	public void adiciona(Aluno aluno) {
		alunos[totalAlunos++] = aluno;
	}
	
	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= totalAlunos;
	}
	
	public void adiciona(int posicao, Aluno aluno) {
		
		if (!posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posicao invalida " + posicao);
		}
		
		for (int i = totalAlunos -1; i >- posicao; i-=1) {
			alunos[i+1] = alunos[i];
		}
		
		alunos[posicao] = aluno;
		totalAlunos++;
	}
	
	public boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < totalAlunos;
	}
	
	public Aluno pega(int posicao) {
		
		if (!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posicao invalida " + posicao);
		}
		return alunos[posicao];
	}
	
	public void remove(int posicao) {
		for (int i = posicao; i < totalAlunos; i++) {
			alunos[i] = alunos[i+1];
		}
		
		totalAlunos--;
	}
	
	public boolean contem(Aluno aluno) {
		for (int i = 0; i < totalAlunos; i++) {
			if (aluno.equals(alunos[i])) {
				return true;
			}
		}
		return false;
	}
	
	public int tamanho() {
		return totalAlunos;
	}
	
	public String toString() {
		return Arrays.toString(alunos);
	}
}
