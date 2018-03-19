package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {
	public static void main(String[] args) {

		Conta conta = null;
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		{
			conta = em.find(Conta.class, 1521414596597L);
			conta.setAgencia("321");

			System.out.println("Nome titular: ".concat(conta.getTitular()));
		}
		em.getTransaction().commit();
		em.close();

		em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		{
			conta.setTitular("Leonardo Silva");
			em.merge(conta);
		}
		em.getTransaction().commit();
		em.close();

		em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		{
			conta = em.find(Conta.class, 1521414607588L);
			em.remove(conta);
		}
		em.getTransaction().commit();
		em.close();
	}
}
