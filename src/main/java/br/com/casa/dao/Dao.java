package br.com.casa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Dao<T> {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ControleVendas");

	private EntityManager em;
	private Class<T> classe;

	public Dao() {
		super();
		em = emf.createEntityManager();
	}

	public Dao(Class<T> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}

	public T buscarPorId(Long id) {
		T entidade = em.find(classe, id);
		return entidade;
	}

	public List<T> buscarObjetos() {
		return this.buscar(0, 10);
	}

	public List<T> buscar(int inicio, int max) {
		if (classe == null) {
			throw new UnsupportedOperationException("Classe não existe");
		}

		TypedQuery<T> query = em.createQuery("select e from " + classe.getName() + " e ", classe);
		query.setFirstResult(inicio);
		query.setMaxResults(max);
		return query.getResultList();
	}

	public T buscarPorNome(String nome) {

		TypedQuery<T> query = em.createQuery("SELECT e FROM " + classe.getName() + " e WHERE e.nome ='" + nome + "'",
				classe);
		return query.getSingleResult();
	}

	public Dao<T> salvar(T entidade) {
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		return this;
	}

	public List<T> salvarTodos(List<T> entidades) {
		em.getTransaction().begin();
		em.persist(entidades);
		em.getTransaction().commit();
		return entidades;
	}

	public T atualizar(T entidade, Long id) {
		buscarPorId(id);
		if (buscarPorId(id) == null) {
			throw new RuntimeException("Id " + id + " não encontrado ");
		}
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		return entidade;
	}

	public void deletar(Long id) {
		T entidade = em.find(classe, id);
		if (entidade == null) {
			throw new RuntimeException("Id " + id + " não encontrado ");
		}
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit();

	}

	public void fecharEM() {
		em.close();
	}

}
