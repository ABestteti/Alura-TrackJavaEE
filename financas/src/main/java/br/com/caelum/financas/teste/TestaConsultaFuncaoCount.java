package br.com.caelum.financas.teste;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;

public class TestaConsultaFuncaoCount {
	public static void main(String[] args) {


		Conta conta = new Conta();
		conta.setId(1521415344145L);
		
		MovimentacaoDao dao = new MovimentacaoDao();
		Long qtde = dao.getQuantidadeMovimentacoes(conta);

		System.out.println("Quantidade de movimentacoes: " + qtde.toString());

	}
}
