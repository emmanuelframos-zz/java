package br.com.headfirst.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		scab.getServletContext().log(scab.getName() + " - " + scab.getValue().toString());
		scab.getServletContext().log("Atributo adicionado ao contexto.");		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		scab.getServletContext().log("Atributo removido do contexto.");			
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		scab.getServletContext().log("Atributo substituído no contexto.");			
	}
}