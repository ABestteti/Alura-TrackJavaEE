package br.com.caelum.livraria.util;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Log
@Interceptor
public class TempoDeExecucaoInterceptor implements Serializable {

	private static final long serialVersionUID = 2473987049320230716L;

	@AroundInvoke
    public Object log(InvocationContext contexto) throws Exception {

        long inicio = System.currentTimeMillis();

        Object proceder = contexto.proceed();

        long fim = System.currentTimeMillis();

        long resultado = fim - inicio;

        System.out.println("M�todo executado: " + 
                           contexto.getMethod().getName() + 
                           " Tempo execu��o: " + resultado);

        return proceder;    
    }
}
