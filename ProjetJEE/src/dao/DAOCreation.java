package dao;

import java.util.List;

import modele.Categorie;
import modele.Creation;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAOCreation 
{
	private static Session session;
	private static Transaction tx;
	
	public static void createCreation(Creation c)
	{
		try
		{
			session = HibernateSessionFactory.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			session.save(c);
			
			tx.commit();
		}
		catch(Throwable e)
		{
			System.out.println("Erreur enregistrment creation : " + e);
		}
		finally
		{
			session.close();
		}
	}
	
	public static Creation getCreationById(int id)
	{
		Creation res = null;
		try
		{
			session = HibernateSessionFactory.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			res = (Creation) session.get(Creation.class, id);
			
			tx.commit();
		}
		catch(Throwable e)
		{
			System.out.println("Erreur pour recevoir creation par ID : " + e);
		}
		finally
		{
			session.close();
		}
		return res;
	}
	
	public static Creation getCreationByName(String name)
	{
		String req = "from modele.Creation as c where c.description = '"+name+"'";
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
			System.out.println("Erreur pour recevoir creation par nom : " + e);
		}
		finally
		{
			session.close();
		}
		
		if(!result.isEmpty())
		{
			return (Creation) result.get(0);
		}
		else
		{		
			return null;
		}
	}
	
	public static void changeCategorie(Creation crea, Categorie categ)
	{
		try
		{
			session = HibernateSessionFactory.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			crea.setCategorie(categ);
			
			session.update(crea);
			
			tx.commit();
		}
		catch(Throwable e)
		{
			System.out.println("Erreur changement de categorie : " + e);
		}
		finally
		{
			session.close();
		}
	}
}