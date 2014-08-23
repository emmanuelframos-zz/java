package br.com.headfirst.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.com.headfirst.model.DummyObject;

public class MyServletContextListener implements ServletContextListener {	

	@Override
	public void contextInitialized(ServletContextEvent event) {
		event.getServletContext().log("Contexto inicializado.");
		
		ServletContext sc = event.getServletContext();
		
		DummyObject dummy = new DummyObject();
		dummy.setDummyDescription("Dummy");
		
		sc.setAttribute("dummy", dummy);
		
		event.getServletContext().log("Objeto " + dummy + " adicionado ao contexto.");
	}	
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		event.getServletContext().log("Contexto vai ser destruído.");
	}
}