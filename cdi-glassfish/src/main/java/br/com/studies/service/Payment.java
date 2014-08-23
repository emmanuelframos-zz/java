package br.com.studies.service;

import java.math.BigDecimal;

public interface Payment {	
	String pay(BigDecimal amount);
}