package br.com.caelum.livraria.transaction;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Transacional
@Interceptor
public class GerenciadorDeTransacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager manager;
	
	@AroundInvoke
	public Object executaTX(InvocationContext contexto) throws Exception {
		
		System.out.println("abrindo tx");
		manager.getTransaction().begin();
		
		// Chamar os daos através do contexto de invocacao da anotação @Transacional
		System.out.println("Executando metodo do DAO: " +contexto.getMethod().getName());
		Object resultado = contexto.proceed();
		
		System.out.println("fechando tx");
		manager.getTransaction().commit();
		
		return resultado;
	}
	
}
