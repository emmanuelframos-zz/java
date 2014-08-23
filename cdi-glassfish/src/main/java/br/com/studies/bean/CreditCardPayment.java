package br.com.studies.bean;

import java.math.BigDecimal;

import br.com.studies.service.Payment;

@br.com.studies.annotations.CreditCardPayment
public class CreditCardPayment implements Payment {

	public String pay(BigDecimal amount) {	
		return "payed in credit card " + amount.toString();	
	}
}