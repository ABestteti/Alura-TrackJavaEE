package br.com.caelum;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.caelum.model.Produto;

public class TestaCache {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfigurator.class);
		
		EntityManagerFactory entityManagerFactory =  ctx.getBean(EntityManagerFactory.class);
		
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityManager em2 = entityManagerFactory.createEntityManager();
		
		Produto produto = em.find(Produto.class, 1);
		Produto produto2 = em2.find(Produto.class, 1);
		
		System.out.println("Nome do produto 1: " + produto.getNome());
		System.out.println("Nome do produto 2: " + produto2.getNome());
		em.close();
		
	}

}
