package graficos;

import java.awt.image.BufferedImage;

public class recursos {
	
	public static BufferedImage player;
	
	public static void init()
	{
		player = cargar.Imagecargar("/naves/player1.png");
	}

}
