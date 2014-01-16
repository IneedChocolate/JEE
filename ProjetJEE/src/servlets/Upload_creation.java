package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAODossierImage;
import modele.DossierImage;
import modele.Upload_creationForm;

/**
 * Servlet implementation class Upload_creation
 */
@WebServlet("/Upload_creation")
@MultipartConfig
public class Upload_creation extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/upload_image.jsp";
	private static final String VUE_CONNEXION = "/WEB-INF/connexion.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload_creation() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getSession(true).getAttribute("CURRENT_USER") != null)
		{
			
			this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
		}
		else
		{
			this.getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DossierImage d = DAODossierImage.getDossierById(2);
		Upload_creationForm.Upload(request, "creation", d);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}