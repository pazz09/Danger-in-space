package objetos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import calculos.vectores;

public class Laser extends movinObjetos{

	public Laser(vectores posicion, vectores velocidad, double maxVel, double angulo, BufferedImage textura) {
		super(posicion, velocidad, maxVel, textura);
		this.angulo = angulo;
		this.velocidad = velocidad.escala(maxVel);
	}

	@Override
	public void actualizar() {
		posicion = posicion.add(velocidad);
		
	}

	@Override
	public void dibujar(Graphics g) {
		Graphics2D graf = (Graphics2D)g;
		rotacion = AffineTransform.getTranslateInstance(posicion.getX() - width/2, posicion.getY());
		rotacion.rotate(angulo,width/2,0);
		graf.drawImage(textura, rotacion, null);
		
	}
	
	

}
