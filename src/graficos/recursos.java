package graficos;

import java.awt.image.BufferedImage;

public class recursos {
	
	public static BufferedImage player;
	public static BufferedImage disparo;
	public static BufferedImage velocidad;
	
	public static BufferedImage[] roca = new BufferedImage[2];
	public static BufferedImage[] piedra = new BufferedImage[2];
	public static BufferedImage[] arena = new BufferedImage[1];
	
	public static void init()
	{
		player = cargar.Imagecargar("/naves/player1.png");
		velocidad = cargar.Imagecargar("/efectos/fuego.png");
		disparo = cargar.Imagecargar("/efectos/disparos.png");
		
		
		for(int i = 0; i < roca.length; i++) {
			roca[i] = cargar.Imagecargar("/asteroides/roca"+(i + 1)+".png");
		}
		
		
		for(int i = 0; i < piedra.length; i++) {
			piedra[i] = cargar.Imagecargar("/asteroides/piedra"+(i + 1)+".png");
		}
		
		for(int i = 0; i < arena.length; i++) {
			arena[i] = cargar.Imagecargar("/asteroides/arena"+(i + 1)+".png");
		}
		
	}

}
