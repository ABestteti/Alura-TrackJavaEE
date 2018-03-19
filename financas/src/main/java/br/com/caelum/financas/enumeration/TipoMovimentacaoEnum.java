package br.com.caelum.financas.enumeration;

public enum TipoMovimentacaoEnum {

	ENTRADA (0, "Movimentacao de entrada na conta."),
	SAIDA (1, "Movimentacao de saida da conta.");
	
	private Integer id;
	private String  descricao;
	
	private TipoMovimentacaoEnum(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public String getDescricao(Integer id) {
		String descricao = null;
		for (TipoMovimentacaoEnum tm : TipoMovimentacaoEnum.values()) {
			if (tm.id == id) {
				descricao = tm.descricao;
				break;
			}
		}
		
		return descricao;
	}
}
