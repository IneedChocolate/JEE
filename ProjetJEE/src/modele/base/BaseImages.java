package modele.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an object that contains data related to the images table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="images"
 */
public abstract class BaseImages  implements Serializable {

	public static String PROP_DATE_PUBLICATION = "DatePublication";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_ID_IMAGE = "IdImage";
	public static String PROP_IMAGE = "Image";
	public static String PROP_CATEGORIE = "Categorie";
	public static String PROP_DOSSIERIMAGE = "dossierimage";


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _idImage;

	// fields
	private java.util.Date _datePublication;
	private java.lang.String _categorie;
	private java.lang.String _description;
	private byte[] _image;

	// many to one
	private modele.DossierImage _dossierimage;


	// constructors
	public BaseImages () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseImages (java.lang.Integer _idImage) {
		this.setIdImage(_idImage);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseImages (
		java.lang.Integer _idImage,
		modele.DossierImage _dossierimage,
		java.util.Date _datePublication,
		java.lang.String _categorie) {

		this.setIdImage(_idImage);
		this.setDossierimage(_dossierimage);
		this.setDatePublication(_datePublication);
		this.setCategorie(_categorie);
		initialize();
	}

	protected void initialize () {}



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="vm"
     *  column="id_Image"
     */
	public java.lang.Integer getIdImage () {
		return _idImage;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _idImage the new ID
	 */
	public void setIdImage (java.lang.Integer _idImage) {
		this._idImage = _idImage;
		this.hashCode = Integer.MIN_VALUE;
	}


	/**
	 * Return the value associated with the column: date_publication
	 */
	public java.util.Date getDatePublication () {
		return _datePublication;
	}

	/**
	 * Set the value related to the column: date_publication
	 * @param _datePublication the date_publication value
	 */
	public void setDatePublication (java.util.Date _datePublication) {
		this._datePublication = _datePublication;
	}


	/**
	 * Return the value associated with the column: categorie
	 */
	public java.lang.String getCategorie () {
		return _categorie;
	}

	/**
	 * Set the value related to the column: categorie
	 * @param _categorie the categorie value
	 */
	public void setCategorie (java.lang.String _categorie) {
		this._categorie = _categorie;
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
	 * Return the value associated with the column: image
	 */
	public byte[] getImage () {
		return _image;
	}

	/**
	 * Set the value related to the column: image
	 * @param _image the image value
	 */
	public void setImage (byte[] _image) {
		this._image = _image;
	}


	/**
     * @hibernate.property
     *  column=ID_DOSSIERIMAGE
	 * not-null=true
	 */
	public modele.DossierImage getDossierimage () {
		return this._dossierimage;
	}

	/**
	 * Set the value related to the column: ID_DOSSIERIMAGE
	 * @param _dossierimage the ID_DOSSIERIMAGE value
	 */
	public void setDossierimage (modele.DossierImage _dossierimage) {
		this._dossierimage = _dossierimage;
	}


	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof modele.base.BaseImages)) return false;
		else {
			modele.base.BaseImages mObj = (modele.base.BaseImages) obj;
			if (null == this.getIdImage() || null == mObj.getIdImage()) return false;
			else return (this.getIdImage().equals(mObj.getIdImage()));
		}
	}


	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getIdImage()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getIdImage().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}

}