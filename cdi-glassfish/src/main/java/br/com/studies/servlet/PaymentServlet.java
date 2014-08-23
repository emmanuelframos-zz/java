package br.com.studies.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.studies.annotations.CashPayment;
import br.com.studies.service.Payment;

@WebServlet(name = "paymentServlet", urlPatterns = {"/paymentServlet"})
public class PaymentServlet extends HttpServlet {

	private static final long serialVersionUID = 2638127270022516617L;
	
	@Inject @CashPayment
	private Payment payment;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {		
		
        PrintWriter out = response.getWriter();
        out.println(payment.pay(new BigDecimal("10")));
        out.close();
    }
}