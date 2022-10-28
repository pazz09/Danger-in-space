package objetos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import calculos.vectores;
import movimiento.teclado;

public class jugador extends GameObjetos{

	public jugador(vectores posicion, BufferedImage textura) {
		super(posicion, textura);
		
	}

	@Override
	public void actualizar() {
		
		if(teclado.RIGHT)
		{
			posicion.setX(posicion.getX() + 1);
		}
		
	}

	@Override
	public void dibujar(Graphics g) {
		
		g.drawImage(textura, (int)posicion.getX(), (int)posicion.getY(), null);
		
		
	}

}
