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
	private vectores aceleracion;
	private final double acc = 0.2;
	private final double ANGULODELTA = Math.PI/20;
	public jugador(vectores posicion, vectores velocidad, double maxVel, BufferedImage textura) {
		super(posicion, velocidad, maxVel, textura);
		direc = new vectores(0,1);
		aceleracion = new vectores();
	}
	
	

	@Override
	public void actualizar() {
		
		if(teclado.RIGHT) {
			angulo += ANGULODELTA;
		}
		
		if(teclado.LEFT) {
			angulo -= ANGULODELTA;
		}
		
		if (teclado.UP)
		{
			aceleracion = direc.escala(acc);
		}else
		{
			if(velocidad.getMagnitud() != 0)
			{
				aceleracion = velocidad.escala(-1).normalizar().escala(acc);
			}
		}
		velocidad = velocidad.add(aceleracion);
		velocidad.limite(maxVel);
				
		direc = direc.setDireccion(angulo - Math.PI/2);
		posicion = posicion.add(velocidad);
		
	}

	@Override
	public void dibujar(Graphics g) {
		
		Graphics2D graf = (Graphics2D)g;
		rotacion = AffineTransform.getTranslateInstance(posicion.getX(), posicion.getY());
		rotacion.rotate(angulo, recursos.player.getWidth()/2,recursos.player.getHeight()/2);
		graf.drawImage(recursos.player, rotacion, null);
	}

}
