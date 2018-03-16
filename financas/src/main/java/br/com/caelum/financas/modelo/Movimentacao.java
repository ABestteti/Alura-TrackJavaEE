package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.caelum.financas.emun.TipoMovimentacaoEnum;

@Entity(name="MOVIMENTACAO")
public class Movimentacao {

	@Id
	@Column(name="ID",nullable=false)
	private Long id;
	
	@Column(name="VALOR")
	private BigDecimal valor;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="DT_MOV")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dtMov;
	
	@Column(name="TIPO")
	@Enumerated(EnumType.ORDINAL)
	private TipoMovimentacaoEnum tipo;
	
	@ManyToOne
	private Conta conta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDtMov() {
		return dtMov;
	}

	public void setDtMov(Calendar dtMov) {
		this.dtMov = dtMov;
	}

	public TipoMovimentacaoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacaoEnum tipo) {
		this.tipo = tipo;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
}
