package graficos;

import java.awt.image.BufferedImage;

public class recursos {
	
	public static BufferedImage player;
	
	// efectos
	public static BufferedImage velocidad;
	public static void init()
	{
		player = cargar.Imagecargar("/naves/player1.png");
		velocidad = cargar.Imagecargar("/efectos/fuego.png");
	}

}
