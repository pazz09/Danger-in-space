package objetos;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import calculos.vectores;
import estado.GameEstado;

public abstract class movinObjetos extends GameObjetos {

	
	protected vectores velocidad;
	protected AffineTransform rotacion;
	protected double angulo;
	protected double maxVel;
	protected int width;
	protected int height;
	protected GameEstado gameEstado;
	
	public movinObjetos(vectores posicion, vectores velocidad, double maxVel, BufferedImage textura, GameEstado gameEstado) {
		super(posicion, textura);
		this.velocidad = velocidad;
		this.maxVel = maxVel;
		this.gameEstado = gameEstado;
		width = textura.getWidth();
		height = textura.getHeight();
		angulo = 0;
	}


	

}
