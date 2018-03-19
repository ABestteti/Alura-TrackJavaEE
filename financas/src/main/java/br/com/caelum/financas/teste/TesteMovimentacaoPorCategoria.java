package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.enumeration.TipoMovimentacaoEnum;
import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoPorCategoria {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		{
			Categoria categoria = new Categoria();
			categoria.setId(2);
			
			String jpql = "select m from MOVIMENTACAO m join m.categoria cat where cat = :pCategoria";
			Query query = em.createQuery(jpql);
			query.setParameter("pCategoria", categoria);
			
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
