package br.com.headfirst.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ParamServlet extends HttpServlet {	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		getServletContext().log("Parâmetro local obtido: " + getServletConfig().getInitParameter("param_local"));
		getServletContext().log("Parâmetro global obtido: " + getServletConfig().getServletContext().getInitParameter("param_global"));		
	}
}