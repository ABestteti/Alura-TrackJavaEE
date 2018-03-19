package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.enumeration.TipoMovimentacaoEnum;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		{
			Conta cta = new Conta();
			cta.setId(1521468591277L);
			
			String jpql = "select m from MOVIMENTACAO m where m.conta = :pCta"
					+ " and m.tipoMovimentacao = :pTipo";
			Query query = em.createQuery(jpql);
			
			query.setParameter("pCta", cta);
			query.setParameter("pTipo", TipoMovimentacaoEnum.SAIDA);
			
			List<Movimentacao> resultados = query.getResultList();
			
			for (Movimentacao mov : resultados) {
				System.out.println("Descricao:" + mov.getDescricao());
				System.out.println("Conta....:" + mov.getConta().getId());
				System.out.println("Titular..:" + mov.getConta().getTitular());
				
			}
		}
		em.getTransaction().commit();
		em.close();

	}

}
