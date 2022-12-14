package objetos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import calculos.vectores;
import estado.GameEstado;

public class Laser extends movinObjetos{

	public Laser(vectores posicion, vectores velocidad, double maxVel, double angulo, BufferedImage textura, GameEstado gameEstado) {
		super(posicion, velocidad, maxVel, textura, gameEstado);
		this.angulo = angulo;
		this.velocidad = velocidad.escala(maxVel);
	}

	@Override
	public void actualizar() {
		posicion = posicion.add(velocidad);
		if(posicion.getX() < 0 || posicion.getX() > constantes.WIDTH || posicion.getY() < 0 || posicion.getY() > constantes.HEIGHT) {
			destruir();
		}
		
		collidesWith();
		
	}

	@Override
	public void dibujar(Graphics g) {
		Graphics2D graf = (Graphics2D)g;
		rotacion = AffineTransform.getTranslateInstance(posicion.getX() - width/2, posicion.getY());
		rotacion.rotate(angulo,width/2,0);
		graf.drawImage(textura, rotacion, null);
		
	}
	
	@Override
	public vectores getCentro() {
		return new vectores(posicion.getX() + width / 2, posicion.getY() + width/2);
	}
	
	
	

}
