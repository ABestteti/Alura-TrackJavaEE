package br.com.caelum.financas.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="CATEGORIA")
public class Categoria {

	@Id
	@Column(name="ID", nullable=false)
	private Integer id;
	
	@Column(name="NOME", nullable=false, length=80)
	private String nome;

	public Categoria() {
	}
	
	public Categoria(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
