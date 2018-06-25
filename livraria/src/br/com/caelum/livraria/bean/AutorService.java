package br.com.caelum.livraria.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {
	
	@Inject
	AutorDao dao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void adiciona(Autor autor) {
		// mais regras aplicacao podem ser adicionadas aqui.		
		dao.salva(autor);
		
		// Uma regra de negocio falhou e a transacao precisa ser desfeita (rollback)
		throw new LivrariaException();
	}

	public List<Autor> todosAutores() {
		return dao.todosAutores();
	}
}
