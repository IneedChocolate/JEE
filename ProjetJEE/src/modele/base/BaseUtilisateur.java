package modele.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an object that contains data related to the utilisateur table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="utilisateur"
 */
public abstract class BaseUtilisateur  implements Serializable {

	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_ID_USER = "IdUser";
	public static String PROP_AVATAR = "Avatar";
	public static String PROP_DROIT = "Droit";
	public static String PROP_PASSWD = "Passwd";
	public static String PROP_PSEUDO = "pseudo";


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _idUser;

	// fields
	private java.lang.String _passwd;
	private java.lang.String _description;
	private java.lang.String _pseudo;
	private byte[] _avatar;
	private java.lang.Integer _droit;

	// collections
	private java.util.Set _dossiers;


	// constructors
	public BaseUtilisateur () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUtilisateur (java.lang.Integer _idUser) {
		this.setIdUser(_idUser);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUtilisateur (
		java.lang.Integer _idUser,
		java.lang.String _passwd,
		java.lang.String _pseudo,
		java.lang.Integer _droit) {

		this.setIdUser(_idUser);
		this.setPasswd(_passwd);
		this.setPseudo(_pseudo);
		this.setDroit(_droit);
		initialize();
	}

	protected void initialize () {}



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="id_user"
     */
	public java.lang.Integer getIdUser () {
		return _idUser;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _idUser the new ID
	 */
	public void setIdUser (java.lang.Integer _idUser) {
		this._idUser = _idUser;
		this.hashCode = Integer.MIN_VALUE;
	}


	/**
	 * Return the value associated with the column: passwd
	 */
	public java.lang.String getPasswd () {
		return _passwd;
	}

	/**
	 * Set the value related to the column: passwd
	 * @param _passwd the passwd value
	 */
	public void setPasswd (java.lang.String _passwd) {
		this._passwd = _passwd;
	}


	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return _description;
	}

	/**
	 * Set the value related to the column: description
	 * @param _description the description value
	 */
	public void setDescription (java.lang.String _description) {
		this._description = _description;
	}


	/**
	 * Return the value associated with the column: pseudo
	 */
	public java.lang.String getPseudo () {
		return _pseudo;
	}

	/**
	 * Set the value related to the column: pseudo
	 * @param _pseudo the pseudo value
	 */
	public void setPseudo (java.lang.String _pseudo) {
		this._pseudo = _pseudo;
	}


	/**
	 * Return the value associated with the column: avatar
	 */
	public byte[] getAvatar () {
		return _avatar;
	}

	/**
	 * Set the value related to the column: avatar
	 * @param _avatar the avatar value
	 */
	public void setAvatar (byte[] _avatar) {
		this._avatar = _avatar;
	}


	/**
	 * Return the value associated with the column: droit
	 */
	public java.lang.Integer getDroit () {
		return _droit;
	}

	/**
	 * Set the value related to the column: droit
	 * @param _droit the droit value
	 */
	public void setDroit (java.lang.Integer _droit) {
		this._droit = _droit;
	}


	/**
	 * Return the value associated with the column: dossiers
	 */
	public java.util.Set getDossiers () {
		return this._dossiers;
	}

	/**
	 * Set the value related to the column: dossiers
	 * @param _dossiers the dossiers value
	 */
	public void setDossiers (java.util.Set _dossiers) {
		this._dossiers = _dossiers;
	}
	
	public void addToDossiers (Object obj) {
		if (null == this._dossiers) this._dossiers = new java.util.HashSet();
		this._dossiers.add(obj);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof modele.base.BaseUtilisateur)) return false;
		else {
			modele.base.BaseUtilisateur mObj = (modele.base.BaseUtilisateur) obj;
			if (null == this.getIdUser() || null == mObj.getIdUser()) return false;
			else return (this.getIdUser().equals(mObj.getIdUser()));
		}
	}


	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getIdUser()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getIdUser().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}

}