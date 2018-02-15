package br.com.caelum.financas.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TesteConta {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		
        Conta conta = new Conta();
        conta.setId(calendar.getTimeInMillis());
        conta.setTitular("Leonardo");
        conta.setBanco("Caixa Economica");
        conta.setAgencia("123");
        conta.setNumero("456");
        
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("financas");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
	}

}
