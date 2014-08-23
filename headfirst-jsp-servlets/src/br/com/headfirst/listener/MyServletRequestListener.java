package br.com.headfirst.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener{

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		sre.getServletContext().log("Request inicializado.");		
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		sre.getServletContext().log("Request vai ser destruído.");		
	}
}