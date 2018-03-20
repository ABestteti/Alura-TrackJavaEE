package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class MovimentacaoDao {

	private EntityManager em;

	public MovimentacaoDao() {
		this.em = new JPAUtil().getEntityManager();
	}

	public Long getQuantidadeMovimentacoes(Conta pConta) {
		Long qtde = null;
		em.getTransaction().begin();
		{
			Conta conta = em.find(Conta.class, pConta.getId());
			
			String pjql = "select count(*) from MOVIMENTACAO m where m.conta = :pConta";
			Query query = em.createQuery(pjql);
			query.setParameter("pConta", conta);

			qtde = (Long) query.getSingleResult();
		}
		em.close();
		return qtde;
	}

}
