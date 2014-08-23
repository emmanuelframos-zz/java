package br.com.headfirst.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class MyHttpSessionActivationListener implements HttpSessionActivationListener {

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		se.getSession().getServletContext().log("Sessão " + se.getSession().getId() + " se tornará passiva na JVM corrente.");		
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		se.getSession().getServletContext().log("Sessão " + se.getSession().getId() + " migrou de JVM.");			
	}
}