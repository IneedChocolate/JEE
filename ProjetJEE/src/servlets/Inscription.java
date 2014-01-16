package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.InscriptionForm;
import modele.Utilisateur;

/**
 * Servlet implementation class inscription
 */
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/inscription.jsp";
	
	private static final String ATT_FORM = "form";
	private static final String ATT_USER = "user";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() 
    {
        super();
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
		InscriptionForm Form = new InscriptionForm();
		Utilisateur user = Form.inscrireUtilisateur(request);
		
		request.setAttribute(ATT_FORM, Form);
		request.setAttribute(ATT_USER, user);
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}
