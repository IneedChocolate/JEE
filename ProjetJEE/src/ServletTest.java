

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modele.Utilisateur;
//import modele.dao.HibernateSessionFactory;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    response.setCharacterEncoding( "UTF-8" );
	    PrintWriter out = response.getWriter();
	    
	    String message = "Cri d'une loutre sauvage !";
	    out.println(message);
	    
	    String tab[] = {"Chapo", "Loutre", "Kebab", "Ornythorinque"};

	    Utilisateur user = new Utilisateur();
	    user.setPseudo("Zorg");
	    user.setPasswd("PassZorg");
	    
	    request.setAttribute("test",message);
	    request.setAttribute("utilisateur", user);
	    request.setAttribute("tableau_test",tab);
	    
	    this.getServletContext().getRequestDispatcher("/WEB-INF/test.jsp?auteur=Machin").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
