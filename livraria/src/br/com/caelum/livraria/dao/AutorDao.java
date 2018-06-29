package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.interceptador.LogInterceptador;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
//@Interceptors({ LogInterceptador.class })
public class AutorDao {

	//private Banco banco = new Banco();
	@PersistenceContext
	private EntityManager manager; 

	@PostConstruct
	void aposCriacao() {
		System.out.println("[INFO] AutorDao foi criado.");
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void salva(Autor autor) {
		System.out.println("[INFO] Salvando o Autor " + autor.getNome());
		
		manager.persist(autor);
		
		System.out.println("[INFO] Salvou o Autor " + autor.getNome());
		
		// Simulacao de uma excecao
		//throw new RuntimeException("[ERRO] Serviço externo deu erro.");
	}
	
	public List<Autor> todosAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.manager.find(Autor.class, autorId);
		return autor;
	}
	
}
