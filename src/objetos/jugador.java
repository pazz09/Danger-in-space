package objetos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import calculos.vectores;
import graficos.recursos;
import main.Window;
import movimiento.teclado;

public class jugador extends movinObjetos{


	private vectores direc;
	private vectores aceleracion;
	private final double acc = 0.2;
	private final double ANGULODELTA = Math.PI/20;
	private boolean acelerando;
	
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
			acelerando = true;
		}else
		{
			if(velocidad.getMagnitud() != 0)
				aceleracion = velocidad.escala(-1).normalizar().escala(acc);
			acelerando = false;
		}
		
		velocidad = velocidad.add(aceleracion);
		velocidad = velocidad.limite(maxVel);	
		direc = direc.setDireccion(angulo - Math.PI/2);
		posicion = posicion.add(velocidad);
		
		//Seccion que controla la salida de la pantalla
		//si pasa el alto o ancho aparece en el lado opuesto
		if(posicion.getX() > Window.WIDTH)
			posicion.setX(0);
		if(posicion.getY() > Window.HEIGHT)
			posicion.setY(0);
		if(posicion.getX() < 0)
			posicion.setX(Window.WIDTH);
		if(posicion.getY() < 0)
			posicion.setY(Window.HEIGHT);
		
	}

	@Override
	public void dibujar(Graphics g) {
		
		Graphics2D graf = (Graphics2D)g;
		AffineTransform at1 = AffineTransform.getTranslateInstance(posicion.getX(),posicion.getY()+height);
		at1.rotate(angulo,width/2,-height/2);
		if(acelerando)
		{
			graf.drawImage(recursos.velocidad, at1, null);
		}
		
		
		rotacion = AffineTransform.getTranslateInstance(posicion.getX(), posicion.getY());
		rotacion.rotate(angulo,width/2,height/2);
		graf.drawImage(recursos.player, rotacion, null);
	}

}
