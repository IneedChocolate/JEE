package modele;

import java.util.Set;

public class Categorie 
{
	private int id_categorie;
	private String nom;
	private Set<Creation> creations;
	
	public Categorie(){}

	public int getId_categorie() 
	{
		return id_categorie;
	}

	public void setId_categorie(int id_categorie) 
	{
		this.id_categorie = id_categorie;
	}

	public String getNom() 
	{
		return nom;
	}

	public void setNom(String nom) 
	{
		this.nom = nom;
	}

	public Set<Creation> getCreations() 
	{
		return creations;
	}

	public void setCreations(Set<Creation> creations)
	{
		this.creations = creations;
	}
}