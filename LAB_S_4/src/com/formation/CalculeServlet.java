package com.formation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculeServlet
 */
@WebServlet("/calcule")
public class CalculeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// recuperation les param

		String num1str = request.getParameter("num1");
		String num2str = request.getParameter("num2");
		String opstr = request.getParameter("op");

		// conversion

		int num1 = Integer.parseInt(num1str);
		int num2 = Integer.parseInt(num2str);

		// calcul

		int result = 0;

		switch (opstr) {

		case "plus":
			result = num1 + num2;
			break;
			
		case "div":
			result = num1 / num2;
			break;
		case "mult":
			result = num1 * num2;
			break;
		case "sub":
			result = num1 - num2;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + opstr);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
