package objetos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import calculos.vectores;
import estado.GameEstado;
import graficos.recursos;
import main.Window;
import movimiento.teclado;

public class jugador extends movinObjetos{


	private vectores direc;
	private vectores aceleracion;
	private final double acc = 0.2;
	private boolean acelerando;
	private tiempo vel_disparo;
	
	
	public jugador(vectores posicion, vectores velocidad, double maxVel, BufferedImage textura, GameEstado gameEstado) {
		super(posicion, velocidad, maxVel, textura,gameEstado );
		direc = new vectores(0,1);
		aceleracion = new vectores();
		vel_disparo = new tiempo();
		
	}
	
	

	@Override
	public void actualizar() {
		
		if(teclado.DISPARO && !vel_disparo.isRun())
		{
			gameEstado.getMovinObjetos().add(0,new Laser(
					getCentro().add(direc.escala(width / 2)),
					direc,
					10,
					angulo,
					recursos.disparo,
					gameEstado
					));
			vel_disparo.run(constantes.FIRERATE);
			
		}
		
		
		if(teclado.RIGHT) {
			angulo += constantes.DELTAANGLE;
		}
		
		if(teclado.LEFT) {
			angulo -= constantes.DELTAANGLE;
		}
		
		if (teclado.UP)
		{
			aceleracion = direc.escala(constantes.ACC);
			acelerando = true;
		}else
		{
			if(velocidad.getMagnitud() != 0)
				aceleracion = (velocidad.escala(-1).normalizar()).escala(constantes.ACC/2);
			acelerando = false;
		}
		
		velocidad = velocidad.add(aceleracion);
		velocidad = velocidad.limite(maxVel);	
		direc = direc.setDireccion(angulo - Math.PI/2);
		posicion = posicion.add(velocidad);
		
		//Seccion que controla la salida de la pantalla
		//si pasa el alto o ancho aparece en el lado opuesto
		if(posicion.getX() > constantes.WIDTH)
			posicion.setX(0);
		if(posicion.getY() > constantes.HEIGHT)
			posicion.setY(0);
		if(posicion.getX() < 0)
			posicion.setX(constantes.WIDTH);
		if(posicion.getY() < 0)
			posicion.setY(constantes.HEIGHT);
		
		vel_disparo.actualizar();
		collidesWith();
		
	}



	@Override
	public void dibujar(Graphics g) {
		
		Graphics2D graf = (Graphics2D)g;
		AffineTransform rotacion1 = AffineTransform.getTranslateInstance(posicion.getX(), posicion.getY() + height );
		rotacion1.rotate(angulo, width/2, -height/2);
		
		if(acelerando)
		{
			
			graf.drawImage(recursos.velocidad, rotacion1, null);
		}
		
		
		rotacion = AffineTransform.getTranslateInstance(posicion.getX(), posicion.getY());
		rotacion.rotate(angulo,width/2,height/2);
		graf.drawImage(textura, rotacion, null);
	}
	
	

}
