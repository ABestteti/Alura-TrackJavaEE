package br.com.caelum.financas.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="CLIENTE")
public class Cliente {
	@Id
	@Column(name="ID", nullable=false)
	private Long id;
	@Column(name="NOME", nullable=false, length=100)
	private String nome;
	@Column(name="PROFISSAO", nullable=false, length=80)
	private String profissao;
	@Column(name="ENDERECO", nullable=false, length=256)
	private String endereco;
	
	//Faz que o banco crie uma UK para o atributo, nesse caso, 
	//uma conta so pertence a um cliente.
	//ATENCAO: essa anotacao so funciona na criacao do schema.
	@JoinColumn(unique=true) 
	@OneToOne
	private Conta conta;
	
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
