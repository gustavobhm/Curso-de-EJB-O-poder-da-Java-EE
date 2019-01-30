package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;

@Singleton
@Startup
public class AutorDao {

	@Inject
	private Banco banco;

	@PostConstruct
	void aposCriacao() {
		System.out.println("AutorDao foi criado");
	}

	public void salva(Autor autor) {
		banco.save(autor);
	}

	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}

}
