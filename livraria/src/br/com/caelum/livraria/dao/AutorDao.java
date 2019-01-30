package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER) //Opcional
public class AutorDao {
	@PersistenceContext
	private EntityManager manager;

	@PostConstruct
	void aposCriacao() {
		System.out.println("[INFO] AutorDao foi criado.");
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED) //Opcional
	public void salva(Autor autor) {
		System.out.println("[INFO] Salvando o Autor " + autor.getNome());

		manager.persist(autor);
		
		System.out.println("[INFO] Salvou o Autor " + autor.getNome());
		
		//chamada ao serviço externo
		
		throw new RuntimeException("Serviço externo deu erro!");
		
	}

	public List<Autor> todosAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = manager.find(Autor.class, autorId);

		return autor;
	}

}