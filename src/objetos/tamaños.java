package objetos;

import java.awt.image.BufferedImage;

import graficos.recursos;

public enum tamaños {
	
	BIG(2, recursos.roca), MED(2, recursos.piedra), SMALL(0, null);
	
	public int cantidad;
	public BufferedImage[] textura;
	private tamaños(int cantidad,BufferedImage[] textura) {
		this.cantidad = cantidad;
		this.textura = textura;
	}

}
