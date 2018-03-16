package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1521220427017L);
		
		conta.setTitular("Carlos Souza");
		conta.setAgencia("5417");
		
		System.out.println("Titular: "+conta.getTitular());
		em.getTransaction().commit();
		em.close();

		
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();

		conta.setTitular("Leonardo Silva Jr");
		System.out.println("Titular: "+conta.getTitular());
		em2.merge(conta);
				
		em2.getTransaction().commit();
		em2.close();
		
		EntityManager em3 = new JPAUtil().getEntityManager();
		em3.getTransaction().begin();

		conta = em3.find(Conta.class, 1521223182763L);
		em3.remove(conta);
		
		em3.getTransaction().commit();
		em3.close();

	}

}
