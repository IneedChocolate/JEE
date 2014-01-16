package modele;

import java.util.HashSet;
import java.util.Set;

public class Utilisateur 
{
	private int idUser,droit;
	private String pseudo, passwd, description;
	private byte[] Avatar;
	private Set<DossierImage> dossiers = new HashSet<DossierImage>();
	private DossierImage di;
	
	public Utilisateur(){}
	
	public String getPasswd() 
	{
		return passwd;
	}
	
	public void setPasswd(String passwd)
	{
		this.passwd = passwd;
	}
	
	public String getPseudo()
	{
		return pseudo;
	}
	
	public void setPseudo(String pseudo)
	{
		this.pseudo = pseudo;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String desription)
	{
		this.description = desription;
	}

	public int getDroit()
	{
		return droit;
	}
	
	public void setDroit(int droit) 
	{
		this.droit = droit;
	}

	public byte[] getAvatar() 
	{
		return Avatar;
	}

	public void setAvatar(byte[] avatar) 
	{
		Avatar = avatar;
	}

	public int getIdUser() 
	{
		return idUser;
	}

	public void setIdUser(int idUser) 
	{
		this.idUser = idUser;
	}

	public Set<DossierImage> getDossiers() 
	{
		return dossiers;
	}

	public void setDossiers(Set<DossierImage> dossiers) 
	{
		this.dossiers = dossiers;
	}
	
	public void addDossier(DossierImage di)
	{
		this.dossiers.add(di);
	}
	
	public void removeDossier(int id)
	{
		for(DossierImage di : this.dossiers)
		{
			if(di.getIdDossierImage() == id)
			{
				this.dossiers.remove(di);
			}
		}
	}
	

	public DossierImage getDi() 
	{
		return di;
	}
	

	public void setDi(DossierImage di) 
	{
		this.di = di;
	}
}
