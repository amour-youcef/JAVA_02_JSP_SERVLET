package com.formation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculeServlet
 */
@WebServlet("/Calcule")
public class CalculeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// recuperation les param
		String num1str = request.getParameter("num1");
		String num2str = request.getParameter("num2");
		String opstr = request.getParameter("op");
		
		
		//conversion
		
		int num1 = Integer.parseInt(num1str);
		int num2 = Integer.parseInt(num2str);
		
		//calcul
		int result = 0  ;
		
		switch (opstr) {
		
		case "plus": result = num1+num2;
			
			break;
		case "div": result = num1/num2;
		
		break;
		case "mult": result = num1*num2;
		
		break;
		case "sub": result = num1-num2;
		
		break;
		default:
			break;
		}
	 //stockage de result
		request.setAttribute("res", result);
		//redirection vers la page result.jsp
		RequestDispatcher disp = request.getRequestDispatcher("result.jsp");
		disp.forward(request, response);
		
//		//afficher
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.print("result " +result);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
