package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {
	
	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception  {
		long millis = System.currentTimeMillis();
		
		Object o = context.proceed();
		
		System.out.println("[INFO] Tempo de acesso ao DB: "
				+ (System.currentTimeMillis() - millis) + "ms \n"
				+ context.getMethod().getName());
		
		return o;
	}
}
