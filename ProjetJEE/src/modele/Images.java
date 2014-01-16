package modele;

import modele.base.BaseImages;

/**
 * This is the object class that relates to the images table.
 * Any customizations belong here.
 */
public class Images extends BaseImages {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*[CONSTRUCTOR MARKER BEGIN]*/
	public Images () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Images (java.lang.Integer _idImage) {
		super(_idImage);
	}

	/**
	 * Constructor for required fields
	 */
	public Images (
		java.lang.Integer _idImage,
		modele.DossierImage _dossierimage,
		java.util.Date _datePublication,
		java.lang.String _categorie) {

		super (
			_idImage,
			_dossierimage,
			_datePublication,
			_categorie);
	}
/*[CONSTRUCTOR MARKER END]*/
}