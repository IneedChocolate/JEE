package modele;

import java.util.Date;

public class Creation
{
	private int id_Creation;
	private String description;
	private Date DatePublication;
	private byte[] image;
	private DossierImage dossierimage;
	private Categorie categorie;
	
	public Creation(){}

	public int getId_Creation() 
	{
		return id_Creation;
	}

	public void setId_Creation(int id_Creation) 
	{
		this.id_Creation = id_Creation;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public Date getDatePublication() 
	{
		return DatePublication;
	}

	public void setDatePublication(Date date_publication) 
	{
		this.DatePublication = date_publication;
	}

	public byte[] getImage() 
	{
		return image;
	}

	public void setImage(byte[] image) 
	{
		this.image = image;
	}

	public DossierImage getDossierimage() 
	{
		return dossierimage;
	}

	public void setDossierimage(DossierImage dossierimage) 
	{
		this.dossierimage = dossierimage;
	}

	public Categorie getCategorie() 
	{
		return categorie;
	}

	public void setCategorie(Categorie categorie)
	{
		this.categorie = categorie;
	}
}
