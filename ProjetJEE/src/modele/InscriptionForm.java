package modele;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class InscriptionForm
{
	private static final String CHAMP_PSEUDO = "username";
	private static final String CHAMP_MDP = "mdp";
	private static final String CHAMP_CONFIRM = "confirm";
	
	private String resultat;
	private Map<String,String> erreurs = new HashMap<String,String>();
	
	public String getResultat()
	{
		return this.resultat;
	}
	
	public Map<String,String> getErreurs()
	{
		return this.erreurs;
	}
	
	public Utilisateur inscrireUtilisateur(HttpServletRequest request)
	{
		String pseudo = getValeurChamp(request, CHAMP_PSEUDO);
		String mdp = getValeurChamp(request, CHAMP_MDP);
		String confirm = getValeurChamp(request, CHAMP_CONFIRM);
		Utilisateur u = new Utilisateur();
		
		try
		{
			verifNom(pseudo);
		}
		catch(Throwable e)
		{
			setErreur(CHAMP_PSEUDO, e.getMessage());
		}
		u.setPseudo(pseudo);
		
		try
		{
			verifPass(mdp, confirm);
		}
		catch(Throwable e)
		{
			setErreur(CHAMP_MDP, e.getMessage());
			setErreur(CHAMP_CONFIRM, null);
		}
		u.setPasswd(mdp);
		
		if(this.erreurs.isEmpty())
		{
			this.resultat = "Succès de l'inscription";
			
			//enregistrement de l'utilisateur dans la base
			Session session = HibernateSessionFactory.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(u);
			
			tx.commit();
			session.close();
		}
		else
		{
			this.resultat = "Echec de l'inscription";
		}
		
		return u;
	}
	
	private void setErreur(String nom, String message)
	{
		this.erreurs.put(nom, message);
	}
	
	private static void verifNom(String nom) throws Exception
	{
		if(nom!=null)
		{
			if(nom.trim().length()<3)
			{
				throw new Exception("Le nom doit être long d'au moins 3 caractères.");
			}
		}
		else
		{
			throw new Exception("Veuillez entrer un nom d'utilsiateur.");
		}
	}
	
	private static void verifPass(String mdp, String confirm) throws Exception
	{
		if(mdp!=null)
		{
			if(mdp.length()>3)
			{
				if(!mdp.equals(confirm))
				{
					throw new Exception("Les mots de passe entrés sont différents.");
				}
			}
			else
			{
				throw new Exception("La longueur du mot de passe doit être supérieur à 3 caractères.");
			}
		}
		else
		{
			throw new Exception("Veuillez entrer un mot de passe");
		}
	}
	
	private static String getValeurChamp(HttpServletRequest request, String champ)
	{
		String valeur = request.getParameter(champ);
		
		if(valeur == null || valeur.trim().length() == 0)
		{
			return null;
		}
		else
		{
			return valeur.trim();			
		}
	}
}