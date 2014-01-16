package modele;


/**
 * This is the object class that relates to the extension table.
 * Any customizations belong here.
 */
public class Extension
{
	private String extension;
	private int idExtension;
	
	public Extension () 
	{
		super();
	}

	public int getIdExtension()
	{
		return idExtension;
	}

	public void setIdExtension(int idExtension)
	{
		this.idExtension = idExtension;
	}

	public String getExtension()
	{
		return extension;
	}

	public void setExtension(String extension)
	{
		this.extension = extension;
	}
}