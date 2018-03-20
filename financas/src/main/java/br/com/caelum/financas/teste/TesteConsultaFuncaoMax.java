package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		{
			String pjql = "select max(m.valor) from MOVIMENTACAO m";
			Query query = em.createQuery(pjql);
			
			BigDecimal max = (BigDecimal)query.getSingleResult();
			System.out.println("Maximo: " +max.toString());
		}
		em.close();
	}
}
