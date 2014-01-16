package dao;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import modele.DossierImage;
import modele.Utilisateur;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAOUtilisateur
{
	private static Session session;
	private static Transaction tx;
	
	public static void createUser(Utilisateur u)
	{
		try
		{
			session = HibernateSessionFactory.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			session.save(u);
			
			tx.commit();
		}
		catch(Throwable e)
		{
			System.out.println("Erreur lors de l'enregistrement d'un utilisateur : " + e);
		}
		finally
		{
			session.close();
		}
	}
	
	public static Utilisateur getUserById(int id)
	{
		Utilisateur res = null;
		try
		{
			session = HibernateSessionFactory.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			res = (Utilisateur) session.get(Utilisateur.class, id);
			
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
	
	public static Utilisateur getUserByName(String pseudo)
	{
		String req = "from modele.Utilisateur as user where user.pseudo='"+pseudo+"'";
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
			System.out.println("Erreur pour trouver un utilisateur par pseudo : " + e);
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
			Utilisateur u = (Utilisateur) result.get(0);
			return u;
		}
	}
	
	public static void updatePasswd(Utilisateur base, String newPass)
	{
		base.setPasswd(newPass);
		
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
	
	public static void updateAvatar(Utilisateur base, String newAvatar) throws IOException
	{
		
		base.setAvatar(extractBytes(newAvatar));
		
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
	
	public static void updateDescription(Utilisateur base, String newDesc)
	{
		base.setDescription(newDesc);
		
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
	
	public static void deleteUser(Utilisateur u)
	{
		try
		{
			session = HibernateSessionFactory.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			session.delete(u);
			
			tx.commit();
		}
		catch(Throwable e)
		{
			System.out.println("Erreur dans la suppression d'un utilisateur : " + e);
		}
		finally
		{
			session.close();
		}
	}
	
	public void addDossier(Utilisateur u, DossierImage d)
	{
		try
		{
			session = HibernateSessionFactory.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			u.getDossiers().add(d);
			d.setUser(u);
			
			session.update(u);
			session.update(d);
			
			tx.commit();
		}
		catch(Throwable e)
		{
			System.out.println("Erreur lors de l'ajout d'un dossier à l'utilisateur : " + e);
		}
		finally
		{
			session.close();
		}
	}
	
	public static byte[] extractBytes (String ImageName) throws IOException 
	{
		BufferedImage img = ImageIO.read(new File(ImageName));
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ImageIO.write(img, "gif", baos);
	    baos.flush();
	    byte[] b = baos.toByteArray();
	    baos.close();
	    return b;
	}
}