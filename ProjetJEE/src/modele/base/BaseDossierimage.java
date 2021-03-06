package modele.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an object that contains data related to the dossierimage table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="dossierimage"
 */
public abstract class BaseDossierimage  implements Serializable {

	public static String PROP_ID_DOSSIERIMAGE = "IdDossierimage";
	public static String PROP_UTILISATEUR = "utilisateur";
	public static String PROP_NOM = "Nom";
	public static String PROP_ID_USER = "IdUser";
	public static String PROP_VISIBILITE = "Visibilite";


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _idDossierimage;

	// fields
	private java.lang.String _nom;
	private java.lang.Integer _visibilite;

	// many to one
	private modele.Utilisateur _utilisateur;
	private modele.Utilisateur _idUser;

	// collections
	private java.util.Set _imagesSet;


	// constructors
	public BaseDossierimage () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDossierimage (java.lang.Integer _idDossierimage) {
		this.setIdDossierimage(_idDossierimage);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseDossierimage (
		java.lang.Integer _idDossierimage,
		modele.Utilisateur _idUser,
		java.lang.String _nom,
		java.lang.Integer _visibilite) {

		this.setIdDossierimage(_idDossierimage);
		this.setIdUser(_idUser);
		this.setNom(_nom);
		this.setVisibilite(_visibilite);
		initialize();
	}

	protected void initialize () {}



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="id_dossierimage"
     */
	public java.lang.Integer getIdDossierimage () {
		return _idDossierimage;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _idDossierimage the new ID
	 */
	public void setIdDossierimage (java.lang.Integer _idDossierimage) {
		this._idDossierimage = _idDossierimage;
		this.hashCode = Integer.MIN_VALUE;
	}


	/**
	 * Return the value associated with the column: Nom
	 */
	public java.lang.String getNom () {
		return _nom;
	}

	/**
	 * Set the value related to the column: Nom
	 * @param _nom the Nom value
	 */
	public void setNom (java.lang.String _nom) {
		this._nom = _nom;
	}


	/**
	 * Return the value associated with the column: Visibilite
	 */
	public java.lang.Integer getVisibilite () {
		return _visibilite;
	}

	/**
	 * Set the value related to the column: Visibilite
	 * @param _visibilite the Visibilite value
	 */
	public void setVisibilite (java.lang.Integer _visibilite) {
		this._visibilite = _visibilite;
	}


	/**
     * @hibernate.property
     *  column=id_user
	 */
	public modele.Utilisateur getUtilisateur () {
		return this._utilisateur;
	}

	/**
	 * Set the value related to the column: id_user
	 * @param _utilisateur the id_user value
	 */
	public void setUtilisateur (modele.Utilisateur _utilisateur) {
		this._utilisateur = _utilisateur;
	}


	/**
     * @hibernate.property
     *  column=id_user
	 * not-null=true
	 */
	public modele.Utilisateur getIdUser () {
		return this._idUser;
	}

	/**
	 * Set the value related to the column: id_user
	 * @param _idUser the id_user value
	 */
	public void setIdUser (modele.Utilisateur _idUser) {
		this._idUser = _idUser;
	}


	/**
	 * Return the value associated with the column: ImagesSet
	 */
	public java.util.Set getImagesSet () {
		return this._imagesSet;
	}

	/**
	 * Set the value related to the column: ImagesSet
	 * @param _imagesSet the ImagesSet value
	 */
	public void setImagesSet (java.util.Set _imagesSet) {
		this._imagesSet = _imagesSet;
	}
	
	public void addToImagesSet (Object obj) {
		if (null == this._imagesSet) this._imagesSet = new java.util.HashSet();
		this._imagesSet.add(obj);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof modele.base.BaseDossierimage)) return false;
		else {
			modele.base.BaseDossierimage mObj = (modele.base.BaseDossierimage) obj;
			if (null == this.getIdDossierimage() || null == mObj.getIdDossierimage()) return false;
			else return (this.getIdDossierimage().equals(mObj.getIdDossierimage()));
		}
	}


	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getIdDossierimage()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getIdDossierimage().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}

}