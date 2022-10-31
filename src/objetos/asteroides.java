package objetos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import calculos.vectores;
import estado.GameEstado;
import graficos.recursos;

public class asteroides extends movinObjetos {

	private tamaños size;
	
	
	public asteroides(vectores posicion, vectores velocidad, double maxVel, BufferedImage textura,
			GameEstado gameEstado, tamaños size) {
		super(posicion, velocidad, maxVel, textura, gameEstado);
		this.size = size;
	}

	@Override
	public void actualizar() {
		
		posicion = posicion.add(velocidad);
		
		if(posicion.getX() > constantes.WIDTH)
			posicion.setX(0);
		if(posicion.getY() > constantes.HEIGHT)
			posicion.setY(0);
		if(posicion.getX() < 0)
			posicion.setX(constantes.WIDTH);
		if(posicion.getY() < 0)
			posicion.setY(constantes.HEIGHT);
		
		angulo += constantes.DELTAANGLE/2;
		
	}

	@Override
	public void dibujar(Graphics g) {
		
		Graphics2D graf = (Graphics2D)g;
		rotacion = AffineTransform.getTranslateInstance(posicion.getX(), posicion.getY());
		rotacion.rotate(angulo,width/2,height/2);
		graf.drawImage(textura, rotacion, null);
	}
	
	public tamaños getSize() {
		return size;
	}
	
	
	

}
