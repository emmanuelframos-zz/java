package br.com.headfirst.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		srae.getServletContext().log("Atributo adicionado ao request " + srae.getServletRequest());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		srae.getServletContext().log("Atributo removido do request " + srae.getServletRequest());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {	
		srae.getServletContext().log("Atributo substituido no request " + srae.getServletRequest());
	}
}