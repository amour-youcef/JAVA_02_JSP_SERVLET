package com.formation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/param")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		out.println("bonjour " + nom + " " + prenom);
		
		// je stock les noms utilisateur dans le context
		
				ServletContext context = getServletContext();
				
				context.setAttribute("name1", nom);
				context.setAttribute("prenom1", prenom);
		
				out.println("<a href='retrieve'> vers Retrieve</a> <br/>");
				
				HttpSession session = request.getSession();
				
				session.setAttribute("name1", nom);
				session.setAttribute("prenom1", prenom);
				
				
				out.println("<a href='session'> vers session</a> <br/>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
