package br.com.caelum.financas.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		
        Conta conta = new Conta();
        conta.setId(calendar.getTimeInMillis());
        conta.setTitular("Leonardo");
        conta.setBanco("Caixa Economica");
        conta.setAgencia("123");
        conta.setNumero("456");
        
        EntityManager em = new JPAUtil().getEntityManager();
        
        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
        
        em.close();
	}
}