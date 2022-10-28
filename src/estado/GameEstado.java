package estado;

import java.awt.Graphics;
import objetos.jugador;
import graficos.recursos;
import calculos.vectores;

public class GameEstado {
	
	private jugador player;
	
	public GameEstado()
	{
		player = new jugador(new vectores(100,500), new vectores(), recursos.player );
	}
	
	public void actualizar()
	{
		player.actualizar();
	}
	
	public void dibujar(Graphics g)
	{
		player.dibujar(g);
	}
	

}
