package br.com.headfirst.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TransferJar extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/jar");	
			
		InputStream is = getServletContext().getResourceAsStream("WEB-INF/resources/jfr.jar");
				
		byte[] bytes = new byte[1024];
		OutputStream os = resp.getOutputStream();
		
		int read = 0;
		while ((read = is.read(bytes))!=-1){
			os.write(bytes, 0, read);
		}			
		
		os.flush();
		os.close();
		
		//java.lang.IllegalStateException: Cannot call sendRedirect() after the response has been committed
		//resp.sendRedirect("index.html");		
	}
}
