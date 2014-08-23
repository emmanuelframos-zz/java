package br.com.studies.persistence;

import java.util.Collection;

public interface IGenericDAO<T> {	
	 void persist(T entity);	 
	 Collection<T> findAll();  
}
