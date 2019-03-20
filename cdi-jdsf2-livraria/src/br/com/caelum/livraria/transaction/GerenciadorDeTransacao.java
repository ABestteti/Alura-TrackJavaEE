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
		manager.getTransaction().begin();
		
		// Chamar os daos que precisam de um contexto
		Object resultado = contexto.proceed();
		
		manager.getTransaction().commit();
		
		return resultado;
	}
	
}
