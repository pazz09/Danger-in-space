package estado;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import objetos.movinObjetos;
import objetos.tamaños;
import objetos.asteroides;
import objetos.constantes;
import objetos.jugador;
import graficos.recursos;
import calculos.vectores;

public class GameEstado {
	
	private jugador player;
	private ArrayList<movinObjetos> movinObjetoss = new ArrayList<movinObjetos>();
	private int asteroide;
	
	public GameEstado()
	{
		player = new jugador(new vectores(constantes.WIDTH/2 - recursos.player.getWidth()/2, constantes.HEIGHT/2 - recursos.player.getHeight()/2), new vectores(), constantes.PLAYER_MAX_VEL, recursos.player, this);
		movinObjetoss.add(player);
		
		asteroide = 1;
		
		nivel_1();
	}
	
	private void nivel_1() {
		
		double x, y;
		
		for (int i = 0; i < asteroide; i++) {
			x = i % 2 == 0 ? Math.random()*constantes.WIDTH : 0;
			y = i % 2 == 0 ? 0 : Math.random()*constantes.HEIGHT;
			
			BufferedImage textura = recursos.roca[(int)(Math.random()*recursos.roca.length)];
			
			movinObjetoss.add(new asteroides(
					new vectores(x, y),
					new vectores(0, 1).setDireccion(Math.random()*Math.PI*2),
					constantes.ASTEROIDE_VEL*Math.random() + 1,
					textura,
					this,
					tamaños.BIG));
			
			
		}
		
		asteroide ++;
	}
	
	
	
	
	
	public void actualizar()
	{
		for(int i =0; i < movinObjetoss.size(); i++) {
			movinObjetoss.get(i).actualizar();
		}
	}
	
	public void dibujar(Graphics g)
	{
		Graphics2D rotacion1 = (Graphics2D)g;
		
		rotacion1.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR );
		
		for(int i =0; i < movinObjetoss.size(); i++) {
			movinObjetoss.get(i).dibujar(g);
		}
	}

	public ArrayList<movinObjetos> getMovinObjetos() {
		return movinObjetoss;
	}
	

}
