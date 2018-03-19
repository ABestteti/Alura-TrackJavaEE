package br.com.caelum.financas.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaContaCliente {
	public static void main(String[] args) {
		Conta cta = new Conta();
		cta.setId(Calendar.getInstance().getTimeInMillis());

		Cliente cli = new Cliente();
		cli.setId(Calendar.getInstance().getTimeInMillis());
		cli.setNome("Sean Jr");
		cli.setEndereco("Rua Dos Andradas 110");
		cli.setProfissao("Professor");
		cli.setConta(cta);
		
		
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
		{
			em.persist(cta);
			em.persist(cli);
		}
        em.getTransaction().commit();
        em.close();

	}
}
