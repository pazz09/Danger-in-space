package objetos;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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

	protected void collidesWith() {
		
		ArrayList<movinObjetos> movinObjetoss = gameEstado.getMovinObjetos();
		
		for(int i = 0; i < movinObjetoss.size(); i++) {
			
			movinObjetos m = movinObjetoss.get(i);
			
			if(m.equals(this)) {
				continue;
			}
			
			double distancia = m.getCentro().restar(getCentro()).getMagnitud();
			
			if(distancia < m.width/2 + width/2 && movinObjetoss.contains(this)) {
				objectCollision(m, this);
			}
			
			
			
			
		}
	}
	
	private void objectCollision(movinObjetos a, movinObjetos b) {
		if(!(a instanceof asteroides && b instanceof asteroides )) {
			a.destruir();
			b.destruir();
			
		}
	}
	
	
	protected void destruir() {
		gameEstado.getMovinObjetos().remove(this);
	}
	
	protected vectores getCentro() {
		return new vectores(posicion.getX() + width / 2, posicion.getY() + height/2);
	}
	
	

}
