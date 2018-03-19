package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		{
			Movimentacao mov = em.find(Movimentacao.class, 1521468591303L);
			
			Conta conta = mov.getConta();
			
			System.out.println("Banco........: " + conta.getBanco());
			System.out.println("Conta........: " + conta.getId());
			System.out.println("Titula.......: " + conta.getTitular());
			System.out.println("Movimentacoes: " + conta.getMovimentacoes().size());
		}
		em.close();
	}
}
