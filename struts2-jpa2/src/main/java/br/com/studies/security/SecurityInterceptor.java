package br.com.studies.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SecurityInterceptor extends AbstractInterceptor {
	
	private static final long serialVersionUID = 1L;
	
	private Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);	
	
	public String intercept(ActionInvocation paramActionInvocation) throws Exception {
		logger.info("Doing security...");
		
		return "sucess";
	}
}