package modele;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import dao.DAOCreation;
import dao.DAODossierImage;

public class Upload_creationForm
{
	private static final String CHAMP_FICHIER = "image_name";
	
	public static void Upload(HttpServletRequest request, String tablename, DossierImage d) throws IllegalStateException, IOException, ServletException
	{
		Part part = request.getPart(CHAMP_FICHIER);
		InputStream input = part.getInputStream();
		
		String file_name = getNomFichier(part);
		
		if(file_name != null && !file_name.isEmpty())
		{
			String field_name = part.getName();
			
			UploadCreation(input, d);
			
			request.setAttribute(field_name, file_name);
		}
	}
	
	private static void UploadCreation(InputStream path, DossierImage d) throws IOException
	{
		Creation c = new Creation();
		c.setDatePublication(new Date());
		c.setImage(extractBytes(path));
		c.setDescription("Test enregistrement dans base");
		c.setDossierimage(d);
		
		DAOCreation.createCreation(c);
		DAODossierImage.addCreation(d, c);
	}
	
	private static String getNomFichier(Part part)
	{
		for(String contentDisposition : part.getHeader("content-disposition").split(";"))
		{
			if(contentDisposition.trim().startsWith("filename"))
			{
				return contentDisposition.substring(contentDisposition.indexOf('=') + 1);
			}
		}
		return null;
	}
	
	private static byte[] extractBytes (InputStream ImageName) throws IOException 
	{
		System.out.println(ImageName);
		
		BufferedImage img = ImageIO.read(ImageName);
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ImageIO.write(img, "gif", baos);
	    baos.flush();
	    byte[] b = baos.toByteArray();
	    baos.close();
	    return b;
	}
}