package modele;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactory 
{
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	static
	{
		try {            
			/*
			 * Build a SessionFactory object from session-factory configuration 
			 * defined in the hibernate.cfg.xml file. In this file we register 
			 * the JDBC connection information, connection pool, the hibernate 
			 * dialect that we used and the mapping to our hbm.xml file for each 
			 * POJO (Plain Old Java Object).
			 * 
			 */
			Configuration configuration = new Configuration();
		    configuration.configure();
		    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();        
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} 
		catch (Throwable e)
		{
		    System.err.println("Error in creating SessionFactory object."  + e.getMessage());
		    throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
        return sessionFactory;
    }
}