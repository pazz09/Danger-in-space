package objetos;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import calculos.vectores;

public abstract class movinObjetos extends GameObjetos {

	
	protected vectores velocidad;
	protected AffineTransform rotacion;
	protected double angulo;
	
	public movinObjetos(vectores posicion, vectores velocidad, BufferedImage textura) {
		super(posicion, textura);
		this.velocidad = velocidad;
		angulo = 0;
	}
	
	

}
