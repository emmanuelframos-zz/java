package br.com.headfirst.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		se.getSession().getServletContext().log("Atributo adicionado à sessão " + se.getSession().getId());				
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		se.getSession().getServletContext().log("Atributo removido da sessão " + se.getSession().getId());	
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		se.getSession().getServletContext().log("Atributo substituído na sessão " + se.getSession().getId());	
	}
}