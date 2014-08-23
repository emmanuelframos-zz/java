package br.com.studies.bean;

import java.math.BigDecimal;

import br.com.studies.service.Payment;

@br.com.studies.annotations.CashPayment
public class CashPayment implements Payment {	
	
	public String pay(BigDecimal amount) {	
		return "payed in cash " + amount.toString();	
	}
}
