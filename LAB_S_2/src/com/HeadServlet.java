package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Enumeration<String> names = request.getHeaderNames();
		
		while  ( names.hasMoreElements()){
			String name = names.nextElement();
			out.println(name);
			
			Enumeration<String> values = request.getHeaders(name);
			out.print(name + ":"); 
			while (values.hasMoreElements()){
				
				String value = values.nextElement();
				out.print(value + " , ");
			}
			out.println("==============");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
