package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class cargar {
	
	public static BufferedImage Imagecargar(String path)
	{
		try {
			return ImageIO.read(cargar.class.getResource(path));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}

}
