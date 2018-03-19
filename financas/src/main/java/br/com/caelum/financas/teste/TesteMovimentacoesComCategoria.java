package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.enumeration.TipoMovimentacaoEnum;
import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacoesComCategoria {
	public static void main(String[] args) {
		
		Conta cta1 = new Conta();
		cta1.setId(Calendar.getInstance().getTimeInMillis());
		cta1.setBanco("Bradesco");
		cta1.setAgencia("1402");
		cta1.setNumero("321287622");
		cta1.setTitular("Sergio Moreira");
		
		Categoria cat1 = new Categoria("Viagem");
		Categoria cat2 = new Categoria("Negocios");
		Categoria cat3 = new Categoria("Esportes de aventura");
		Categoria cat4 = new Categoria("Lazer");
		
		cat1.setId(1);
		cat2.setId(2);
		cat3.setId(3);
		cat4.setId(4);
		
		Movimentacao mov1 = new Movimentacao();
		Movimentacao mov2 = new Movimentacao();
		
		mov1.setId(Calendar.getInstance().getTimeInMillis());
		mov1.setData(Calendar.getInstance());
		mov1.setDescricao("Viagem a Porto Alegre");
		mov1.setTipoMovimentacao(TipoMovimentacaoEnum.SAIDA);
		mov1.setValor(new BigDecimal("1250.23"));
		mov1.setCategorias(Arrays.asList(cat1, cat2));
		mov1.setConta(cta1);
		
		mov1.setId(Calendar.getInstance().getTimeInMillis());
		mov2.setData(Calendar.getInstance());
		mov2.setDescricao("Viagem ao Canada");
		mov1.setTipoMovimentacao(TipoMovimentacaoEnum.SAIDA);
		mov2.setValor(new BigDecimal("1174.98"));
		mov2.setCategorias(Arrays.asList(cat3, cat4));
		mov2.setConta(cta1);

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
		{
			em.persist(cta1);
			
			em.persist(cat1);
			em.persist(cat2);
			em.persist(cat3);
			em.persist(cat4);

			em.persist(mov1);
			em.persist(mov2);

		}
        em.getTransaction().commit();
        em.close();
	}
}
