package br.com.caelum.livraria.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Usuario;

public class UsuarioDao implements Serializable {

	@Inject
	EntityManager manager;
	
	private static final long serialVersionUID = -5939874474635707787L;

	public boolean existe(Usuario usuario) {
		
        // Comentado em funcao da adocao do CDI
		//EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Usuario> query = manager.createQuery(
				  " select u from Usuario u "
				+ " where u.email = :pEmail and u.senha = :pSenha", Usuario.class);
		
		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());
		try {
			Usuario resultado =  query.getSingleResult();
		} catch (NoResultException ex) {
			return false;
		}
		
		// Comentado em funcao da adocao do CDI
		//em.close();
		
		return true;
	}

}
