package objetos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import calculos.vectores;

public abstract class GameObjetos {
	
	protected BufferedImage textura;
	protected vectores posicion;
	
	public GameObjetos(vectores posicion, BufferedImage textura)
	{
		this.posicion = posicion;
		this.textura = textura;
	}
	
	public abstract void actualizar();
	public abstract void dibujar(Graphics g);

	public vectores getPosicion() {
		return posicion;
	}

	public void setPosicion(vectores posicion) {
		this.posicion = posicion;
	}
	
	

}
