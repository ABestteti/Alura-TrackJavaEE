package br.com.caelum.livraria.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class LivroBean {

	private Livro livro = new Livro();

	@PostConstruct
	public void posConstrucao () {
		System.out.println("Objeto LivroBean foi criado.");
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void gravar() {
		System.out.println("Gravando o livro " + this.livro.getTitulo());
	}

}
