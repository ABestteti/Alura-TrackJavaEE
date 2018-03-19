package br.com.caelum.financas.enumeration;

public enum TipoMovimentacao {
	ENTRADA (0, "Movimentacao de entrada."), 
	SAIDA (1, "Movimentacao de saida.");
	
	private int tipoMovimentacao;
	private String descMovimentacap;
	
	private TipoMovimentacao(int tipoMovimentacao, String descMovimentacap) {
		this.tipoMovimentacao = tipoMovimentacao;
		this.descMovimentacap = descMovimentacap;
	}
}
