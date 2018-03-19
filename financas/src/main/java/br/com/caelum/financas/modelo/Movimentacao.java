package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.caelum.financas.enumeration.TipoMovimentacaoEnum;

@Entity(name="MOVIMENTACAO")
public class Movimentacao {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal valor;
	@Enumerated(EnumType.STRING)
	@Column(length=15)
	private TipoMovimentacaoEnum tipoMovimentacao;
	@Temporal(TemporalType.DATE)
	private Calendar data;
	private String descricao;
	@ManyToMany // Monta uma tabela de ligacao entre as tabelas MOVIMENTACAO e CATEGORIA
	private List<Categoria> categoria;

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategorias(List<Categoria> categoria) {
		this.categoria = categoria;
	}

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

	public TipoMovimentacaoEnum getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacaoEnum tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

}