package br.com.studies;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.com.studies.model.Employee;

public class Main {

	@Test
	public void insertEmployee(){
		Employee employee = new Employee();
		employee.setFirstName("Emmanuel");
		employee.setLastName("Ramos");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("struts2-jpa2");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
}