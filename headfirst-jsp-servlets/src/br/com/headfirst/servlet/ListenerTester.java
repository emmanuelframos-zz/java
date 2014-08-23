package br.com.headfirst.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ListenerTester extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*resp.setContentType("text/html");
		
		/*PrintWriter writer = resp.getWriter();
		writer.println("Conteudo obtido pelo listener");
		writer.println("<br>");
		DummyObject dog = (DummyObject)req.getServletContext().getAttribute("dog");
		writer.println(dog.getBreed());		
		writer.println(req.getSession().getId());		
		
		/** RequestDispatch 
		req.getRequestDispatcher("index.html").forward(req, resp);
		
		/** Redirecionamento **/
		//resp.sendRedirect("index.html");
	}	
}