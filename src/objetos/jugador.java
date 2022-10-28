package objetos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import calculos.vectores;
import graficos.recursos;
import movimiento.teclado;

public class jugador extends movinObjetos{


	private vectores direc;
	

	public jugador(vectores posicion, vectores velocidad, BufferedImage textura) {
		super(posicion, velocidad, textura);
		direc = new vectores(0,1);
	}
	
	

	@Override
	public void actualizar() {
		
		if(teclado.RIGHT) {
			angulo += Math.PI/20;
		}
		
		if(teclado.LEFT) {
			angulo -= Math.PI/20;
		}
		direc = direc.setDireccion(angulo - Math.PI/2);
		
	}

	@Override
	public void dibujar(Graphics g) {
		
		Graphics2D graf = (Graphics2D)g;
		rotacion = AffineTransform.getTranslateInstance(posicion.getX(), posicion.getY());
		rotacion.rotate(angulo, recursos.player.getWidth()/2,recursos.player.getHeight()/2);
		graf.drawImage(recursos.player, rotacion, null);
	}

}
