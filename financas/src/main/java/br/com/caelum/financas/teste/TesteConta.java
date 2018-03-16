package br.com.caelum.financas.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();

		EntityManager em = new JPAUtil().getEntityManager();
		Conta conta = new Conta();

		conta.setId(calendar.getTimeInMillis());
		conta.setTitular("Leonardo");
		conta.setBanco("Caixa Economica");
		conta.setAgencia("123");
		conta.setNumero("456");
		conta.setDtAtliz(new java.sql.Date(Calendar.getInstance().getTime().getTime()));

		em.getTransaction().begin();
		em.persist(conta);
		
		conta.setTitular("Caio Abreu");
		conta.setBanco("Bradesco");
		
		em.getTransaction().commit();

		// A partir do close o objeto conta passa para o estado
		// detached.
		em.close();
	}

}
