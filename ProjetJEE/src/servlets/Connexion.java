package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.ConnexionForm;
import modele.Utilisateur;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/connexion.jsp";

	private static final String ATT_FORM = "form";
	private static final String ATT_USER = "CURRENT_USER";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ConnexionForm cf = new ConnexionForm();
		Utilisateur u = cf.connexionUtilisateur(request);
		
		request.setAttribute(ATT_FORM, cf);
		request.setAttribute(ATT_USER, u);
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}
