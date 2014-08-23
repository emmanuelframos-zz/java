package br.com.headfirst.model;

import java.io.Serializable;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@SuppressWarnings("serial")
public class DummyObject implements Serializable, HttpSessionBindingListener {	
	
	private String dummyDescription;

	public DummyObject(){		
	}

	public String getDummyDescription() {
		return dummyDescription;
	}

	public void setDummyDescription(String dummyDescription) {
		this.dummyDescription = dummyDescription;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		event.getSession().getServletContext().log("Atributo " + this + " adicionado à sessão " + event.getSession().getId());	
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		event.getSession().getServletContext().log("Atributo " + this + " removido da sessão " + event.getSession().getId());	
	} 

	@Override
	public String toString() {
		return "DummyObject -> " + dummyDescription;
	}
}