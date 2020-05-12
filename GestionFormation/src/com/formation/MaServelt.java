package com.formation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MaServelt
 */
@WebServlet("/youcef")
public class MaServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MaServelt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		traitement(request, response);
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
	protected void traitement(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Etape 1 : R�cup�ration des param�tres de la requ�te :
		String login = request.getParameter("loginuser");
		String pwd = request.getParameter("mdpuser");

		// Etape 2 : Soumettre les param�tres de la requ�te � la couche service et pr�parer en fonction la r�ponse � envoyer
		RequestDispatcher dispatcher;
		if (("manga".equalsIgnoreCase(login))
				&& ("aimejava".equalsIgnoreCase(pwd))) {
			dispatcher = request.getRequestDispatcher("Acceuil.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("Login.jsp");
		}

		// Etape 3 : envoyer la R�ponse � l'utilisateur
		dispatcher.forward(request, response);

	}
}
