package br.com.caelum.timer;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class Agendador {

	// Schedule each 10 seconds to run the method
	@Schedule(hour="*", minute="*", second="*/10", persistent=false)
	void agendado() {
		System.out.println("Verificando servico externo periodicamente.");
	}
}
