package modele.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import modele.dao.UtilisateurDAO;

/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseUtilisateurDAO extends modele.dao._RootDAO {

	public static UtilisateurDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static UtilisateurDAO getInstance () {
		if (null == instance) instance = new UtilisateurDAO();
		return instance;
	}

	/**
	 * modele.dao._RootDAO _RootDAO.getReferenceClass()
	 */
	public Class getReferenceClass () {
		return modele.Utilisateur.class;
	}
	
	public modele.Utilisateur load(java.lang.Integer key)
		throws org.hibernate.HibernateException {
		return (modele.Utilisateur) load(getReferenceClass(), key);
	}

	public modele.Utilisateur load(java.lang.Integer key, Session s)
		throws org.hibernate.HibernateException {
		return (modele.Utilisateur) load(getReferenceClass(), key, s);
	}

	public modele.Utilisateur loadInitialize(java.lang.Integer key, Session s) 
			throws org.hibernate.HibernateException { 
		modele.Utilisateur obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param utilisateur a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(modele.Utilisateur utilisateur)
		throws org.hibernate.HibernateException {
		return (java.lang.Integer) super.save(utilisateur);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param utilisateur a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(modele.Utilisateur utilisateur, Session s)
		throws org.hibernate.HibernateException {
		return (java.lang.Integer) super.save(utilisateur, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param utilisateur a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(modele.Utilisateur utilisateur)
		throws org.hibernate.HibernateException {
		super.saveOrUpdate(utilisateur);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param utilisateur a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(modele.Utilisateur utilisateur, Session s)
		throws org.hibernate.HibernateException {
		super.saveOrUpdate(utilisateur, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param utilisateur a transient instance containing updated state
	 */
	public void update(modele.Utilisateur utilisateur) 
		throws org.hibernate.HibernateException {
		super.update(utilisateur);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param utilisateur a transient instance containing updated state
	 * @param the Session
	 */
	public void update(modele.Utilisateur utilisateur, Session s)
		throws org.hibernate.HibernateException {
		super.update(utilisateur, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.Integer id)
		throws org.hibernate.HibernateException {
		super.delete(load(id));
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param id the instance ID to be removed
	 * @param s the Session
	 */
	public void delete(java.lang.Integer id, Session s)
		throws org.hibernate.HibernateException {
		super.delete(load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param utilisateur the instance to be removed
	 */
	public void delete(modele.Utilisateur utilisateur)
		throws org.hibernate.HibernateException {
		super.delete(utilisateur);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param utilisateur the instance to be removed
	 * @param s the Session
	 */
	public void delete(modele.Utilisateur utilisateur, Session s)
		throws org.hibernate.HibernateException {
		super.delete(utilisateur, s);
	}
	
	/**
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 * For example 
	 * <ul> 
	 * <li>where a database trigger alters the object state upon insert or update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh (modele.Utilisateur utilisateur, Session s)
		throws org.hibernate.HibernateException {
		super.refresh(utilisateur, s);
	}

    public String getDefaultOrderProperty () {
		return null;
    }

}