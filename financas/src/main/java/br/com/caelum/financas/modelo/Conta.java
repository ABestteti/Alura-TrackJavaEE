package br.com.caelum.financas.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="CONTA")
public class Conta {
	
	@Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="TITULAR")
    private String titular;
	@Column(name="BANCO")
    private String banco;
	@Column(name="AGENCIA")
    private String agencia;
	@Column(name="NUMERO")
    private String numero;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
