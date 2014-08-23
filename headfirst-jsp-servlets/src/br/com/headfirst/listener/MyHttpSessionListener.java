package br.com.headfirst.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().getServletContext().log("Sessão " + se.getSession().getId() + " inicializada.");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		se.getSession().getServletContext().log("Sessão " + se.getSession().getId() + " vai ser destruída.");		
	}
}