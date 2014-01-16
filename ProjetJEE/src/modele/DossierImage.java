package modele;

import java.util.Set;

public class DossierImage 
{
	private int idDossierImage, visibilite;
	private String Nom;
	private Utilisateur user;
	private Set<Creation> creations;
	
	public DossierImage(){}

	public int getIdDossierImage() 
	{
		return idDossierImage;
	}
	
	public void setIdDossierImage(int idDossierImage)
	{
		this.idDossierImage = idDossierImage;
	}

	public int getVisibilite() 
	{
		return visibilite;
	}

	public void setVisibilite(int visibilite) 
	{
		this.visibilite = visibilite;
	}

	public String getNom() 
	{
		return Nom;
	}

	public void setNom(String nom) 
	{
		Nom = nom;
	}

	public Utilisateur getUser() 
	{
		return user;
	}

	public void setUser(Utilisateur user) 
	{
		this.user = user;
	}

	public Set<Creation> getCreations() {
		return creations;
	}

	public void setCreations(Set<Creation> creations) {
		this.creations = creations;
	}
}
