package estado;

import java.awt.Graphics;
import java.util.ArrayList;

import objetos.movinObjetos;
import objetos.jugador;
import graficos.recursos;
import calculos.vectores;

public class GameEstado {
	
	private jugador player;
	private ArrayList<movinObjetos> movinObjetoss = new ArrayList<movinObjetos>();
	
	
	public GameEstado()
	{
		player = new jugador(new vectores(100,500), new vectores(), 7, recursos.player, this);
		movinObjetoss.add(player);
	}
	
	public void actualizar()
	{
		for(int i =0; i < movinObjetoss.size(); i++) {
			movinObjetoss.get(i).actualizar();
		}
	}
	
	public void dibujar(Graphics g)
	{
		for(int i =0; i < movinObjetoss.size(); i++) {
			movinObjetoss.get(i).dibujar(g);
		}
	}

	public ArrayList<movinObjetos> getMovinObjetos() {
		return movinObjetoss;
	}
	

}
