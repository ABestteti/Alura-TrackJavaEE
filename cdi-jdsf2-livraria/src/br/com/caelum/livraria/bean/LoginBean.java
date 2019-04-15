package br.com.caelum.livraria.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.UsuarioDao;
import br.com.caelum.livraria.modelo.Usuario;

@Named
@ViewScoped
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	UsuarioDao dao;
	
	@Inject
	FacesContext context;
	
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public String efetuaLogin() {
		System.out.println("fazendo login do usuario "
				+ this.usuario.getEmail());

		//Comentado em funcao da adocao do CDI
		//FacesContext context = FacesContext.getCurrentInstance();
		boolean existe = dao.existe(this.usuario);
		if (existe) {
			context.getExternalContext().getSessionMap()
					.put("usuarioLogado", this.usuario);
			return "livro?faces-redirect=true";
		}

		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Usuario nao encontrado"));

		return "login?faces-redirect=true";
	}

	public String deslogar() {
		//Comentado em funcao da adocao do CDI
		//FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		return "login?faces-redirect=true";
	}
}
