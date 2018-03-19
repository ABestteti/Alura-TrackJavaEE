package br.com.caelum.financas.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import br.com.caelum.financas.modelo.Movimentacao;

@Entity(name="CONTA")
public class Conta {
	
	@Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="TITULAR", length=100)
    private String titular;
	@Column(name="BANCO", length=100)
    private String banco;
	@Column(name="AGENCIA", length=200)
    private String agencia;
	@Column(name="NUMERO", length=10)
    private String numero;
	
	// Estabelece a relacao com a entidade Movimentacao, criando
	// uma relacao birecional.
	// mappedBy informa ao JPA que o relacionamento ja esta mapeado
	// na classe Movimentacao.java, atributo declarado como "conta".
	// Com mappedBy="conta" conseguimos manter o @OneToMany apenas como 
	// um espelho (bidirecional) evitando que ele crie duas vezes o relacionamento 
	// no banco(chave estrangeira e tabela de relacionamento).
	@OneToMany(mappedBy="conta")
	private List<Movimentacao> movimentacoes;
    
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
	public final List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	public final void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
}
