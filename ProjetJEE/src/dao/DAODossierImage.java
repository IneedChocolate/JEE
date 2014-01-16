package dao;

import java.util.List;

import modele.Creation;
import modele.DossierImage;
import modele.Utilisateur;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAODossierImage
{
	private static Session session;
	private static Transaction tx;
	
	public static void createDossierImage(DossierImage di)
	{
		try
		{
			session = HibernateSessionFactory.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			session.save(di);
			
			tx.commit();
		}
		catch(Throwable e)
		{
			System.out.println("Erreur lors de l'enregistrement d'un dossier d'images : " + e);
		}
		finally
		{
			session.close();
		}
	}
	
	public static DossierImage getDossierById(int id)
	{
		DossierImage res = null;
		try
		{
			session = HibernateSessionFactory.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			res = (DossierImage) session.get(DossierImage.class, id);
			
			tx.commit();
		}
		catch(Throwable e)
		{
			System.out.println("Erreur pour trouver un utilisateur par ID : " + e);
		}
		finally
		{
			session.close();
		}
		return res;
	}
	
	public static DossierImage getDossierByName(String name)
	{
		String req = "from modele.DossierImage as dossier where dossier.nom='"+name+"'";
		List<Object> result = null;
		try
		{
			session = HibernateSessionFactory.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			Query query = session.createQuery(req);
			result = query.list();
			
			tx.commit();
		}
		catch(Throwable e)
		{
			System.out.println("Erreur pour trouver un dossier : " + e);
		}
		finally
		{
			session.close();
		}
		
		if(result.isEmpty())
		{
			return null;
		}
		else
		{
			DossierImage d = (DossierImage) result.get(0);
			return d;
		}
	}
	
	public static void changerVisibilite(DossierImage base, int visibilite)
	{
		base.setVisibilite(visibilite);
		
		try
		{
			session = HibernateSessionFactory.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			session.update(base);
			
			tx.commit();
		}
		catch(Throwable e)
		{
			System.out.println("Erreur dans la modification de l'utilisateur : " + e);
		}
		finally
		{
			session.close();
		}
	}
	
	public static void deleteDossier(DossierImage d)
	{
		try
		{
			session = HibernateSessionFactory.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			session.delete(d);
			
			tx.commit();
		}
		catch(Throwable e)
		{
			System.out.println("Erreur dans la suppression d'un dossier : " + e);
		}
		finally
		{
			session.close();
		}
	}
	
	public static void addCreation(DossierImage d, Creation c)
	{
		try
		{
			session = HibernateSessionFactory.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			d.getCreations().add(c);
			c.setDossierimage(d);
			
			session.update(d);
			session.update(c);
			
			tx.commit();
		}
		catch(Throwable e)
		{
			System.out.println("Erreur lors de l'ajout d'une creation au dossier : " + e);
		}
		finally
		{
			session.close();
		}
	}
}