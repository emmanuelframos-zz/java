package br.com.studies.persistence;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.studies.model.Employee;


public class GenericDAO<T> implements IGenericDAO<T> {		
	
	protected static EntityManager entityManager;
	
	public GenericDAO(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("struts2-jpa2");
		entityManager = factory.createEntityManager();
	}

	public void persist(T entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);		
		entityManager.getTransaction().commit();
		entityManager.close();	
	}

	@SuppressWarnings("unchecked")
	public Collection<T> findAll() {	
		String clazz = "FROM " + Employee.class.getName();
		 return (Collection<T>)entityManager.createQuery(clazz).getResultList();
	}	
}