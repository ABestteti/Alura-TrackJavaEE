package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.emun.TipoMovimentacaoEnum;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJpaRelacionamento {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		Movimentacao mov = new Movimentacao();
		conta.setId(Calendar.getInstance().getTimeInMillis());
		conta.setAgencia("0102");
		conta.setBanco("Bradesco");
		conta.setNumero("25147887");
		conta.setTitular("Maria Silveira");
		
		
		mov.setId(Calendar.getInstance().getTimeInMillis());
		mov.setDtMov(Calendar.getInstance());
		mov.setDescricao("Supermercado");
		mov.setTipo(TipoMovimentacaoEnum.SAIDA);
		mov.setValor(new BigDecimal("125.34"));
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		{
			em.persist(mov);
		}
		em.getTransaction().commit();
		em.close();

	}

}
