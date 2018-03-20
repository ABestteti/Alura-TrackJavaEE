package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteTodasMovimentacoesDasContas {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		{
			String pjql = "select distinct c from CONTA c left join fetch c.movimentacoes";
			Query query = em.createQuery(pjql);
			
			List<Conta> contas = query.getResultList();
			
			for (Conta conta : contas) {
				System.out.println("Titular: " + conta.getTitular());
				System.out.println("Banco..: " + conta.getBanco());				
				System.out.println("Conta..: " + conta.getNumero());
				System.out.println("Movimentacoes: ");
				for (Movimentacao mov : conta.getMovimentacoes()) {
					System.out.println("  Tipo.....: " + mov.getTipoMovimentacao());
					System.out.println("  Data.....: " + mov.getData());
					System.out.println("  Descricao: " + mov.getDescricao());
					System.out.println("  Valor....: " + mov.getValor());
					System.out.println("--------------------------------------------------------------");
				}
				
			}
		}
		em.close();
	}

}
