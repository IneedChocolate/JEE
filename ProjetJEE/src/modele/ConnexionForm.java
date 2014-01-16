package modele;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.DAOUtilisateur;

public class ConnexionForm
{
	private static final String CHAMP_PSEUDO = "username";
	private static final String CHAMP_MDP = "mdp";
	
	private String resultat;
	private Map<String,String> erreurs = new HashMap<String,String>();
	
	public Utilisateur connexionUtilisateur(HttpServletRequest request)
	{
		String pseudo = getValeurChamp(request, CHAMP_PSEUDO);
		String mdp = getValeurChamp(request, CHAMP_MDP);
		Utilisateur user = DAOUtilisateur.getUserByName(pseudo);
		
		if(user == null)
		{
			return null;
		}
		else
		{
			if(VerifMDP(user, mdp))
			{
				System.out.println("mdp ok");
				return user;	
			}
			else
			{
				System.out.println("mdp failed");
				return null;
			}
		}
	}
	
	private static boolean VerifMDP(Utilisateur u, String mdp)
	{
		return u.getPasswd().equals(mdp);
	}
	
	private static String getValeurChamp(HttpServletRequest request, String champ)
	{
		String res = request.getParameter(champ);
		
		if(res == null || res.trim().length() == 0)
		{
			return null;
		}
		else
		{
			return res;
		}
	}
}