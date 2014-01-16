import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modele.Creation;
import modele.DossierImage;
import modele.Utilisateur;


public class TestBase 
{
	private static Session session;
	private static Transaction tx;
	
	public static void main(String[] args) throws IOException, SQLException 
	{
		
	}
	
	public static void SetAjoutImage() throws IOException
	{
		byte[] image = extractBytes("C:/Users/jcollinet/workspace/ProjetJEE/src/miles_trumpet.gif");
		Creation c = new Creation();
			c.setDatePublication(new Date());
			c.setDescription("Une trompette");
			c.setImage(image);
		
		DossierImage dossierTest;
			
		session = HibernateSessionFactory.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		dossierTest = (DossierImage) session.get(DossierImage.class, 1);
		
		c.setDossierimage(dossierTest);
		dossierTest.getCreations().add(c);
		
		session.save(c);
		
		tx.commit();
		session.close();
		
		System.out.println("Fin d'ajout d'une image");
	}
	
	public static void SetAjoutDeuxiemeDossier()
	{
		DossierImage di = new DossierImage();
		di.setNom("Zorg");
		di.setVisibilite(1);
		
	session = HibernateSessionFactory.getSessionFactory().openSession();
	tx = session.beginTransaction();
	
	Utilisateur us = getUtilisateur(1);
	Object dossier[] = us.getDossiers().toArray();
	for(Object d : dossier)
	{
		DossierImage doss = (DossierImage) d;
		System.out.println(doss.getNom());
	}
	
	di.setUser(us);
	us.addDossier(di);
	
	session.save(di);
	
	tx.commit();
	session.close();
	System.out.println("Fin de d'ajout d'un autre dossier");
	}
	
	public static void SetDossierTest()
	{
		session = HibernateSessionFactory.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		Utilisateur testdossier = new Utilisateur();
		testdossier.setPseudo("TestDossier");
		testdossier.setPasswd("passDossier");
		testdossier.setDroit(0);

		session.save(testdossier);
		
		DossierImage testdi = new DossierImage();
		testdi.setNom("DossierTest");
		testdi.setVisibilite(0);
		
		testdi.setUser(testdossier);
		testdossier.addDossier(testdi);
		System.out.println("tables reli�es");
		
		session.save(testdi);
		System.out.println("testdi saved");
		
		tx.commit();
		session.close();
		System.out.println("Fin d'ajout de dossier");
	}
	
	public static void SetAjoutUser() throws IOException, SQLException
	{
		session = HibernateSessionFactory.getSessionFactory().openSession();
		tx = session.beginTransaction();
		Utilisateur us1 = new Utilisateur();
		us1.setPseudo("User 1");
		us1.setPasswd("motdepasse");
		us1.setDescription("");
		us1.setDroit(0);
		
		byte[] image = extractBytes("C:/Users/jcollinet/workspace/ProjetJEE/src/miles_trumpet.gif");
		
		us1.setAvatar(image);
		
		File f = new File("C:/Users/jcollinet/workspace/ProjetJEE/src/miles_trumpet.gif");
		BufferedImage IMG_BASE = ImageIO.read(f);
		Utilisateur usertest = getUtilisateur(1);
		System.out.println(usertest.getPseudo() + " : " + usertest.getPasswd());
		ImageIcon avatar = getImage(usertest.getAvatar());
		
		session.save(us1);
		tx.commit();
		session.close();
		AjouterUtilisateur("Gniargh", "ONche", 0);
		JLabel img = new JLabel();
		img.setIcon(avatar);
		
		JLabel imgbase = new JLabel(new ImageIcon(IMG_BASE));
		JFrame jf = new JFrame("TestImage");
			jf.setLayout(new GridLayout(1,2));
			jf.add(img);
			jf.add(imgbase);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setVisible(true);
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
	
	protected static void AjouterUtilisateur(String pseudo, String passwd, int droit)
	{
		Utilisateur u = new Utilisateur();
		u.setPseudo(pseudo);
		u.setPasswd(passwd);
		u.setDroit(droit);
		u.setDescription("");
		
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(u);
		
		tx.commit();
		session.close();
	}
	
	protected static void EnleverUtilisateur(Utilisateur u)
	{
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(u);
		
		tx.commit();
		session.close();
	}
	
	protected static void ModifierPass(Utilisateur u, String passwd)
	{
		u.setPasswd(passwd);
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(u);
		
		tx.commit();
		session.close();
	}
	
	protected static Utilisateur getUtilisateur(int id)
	{
		Utilisateur user;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		user = (Utilisateur) session.get(Utilisateur.class, id);
		
		tx.commit();
		session.close();
		
		return user;
	}
	
	protected static ImageIcon getImage(byte[] Avatar) throws IOException, SQLException
	{
		return new ImageIcon(Avatar);
	}
}
