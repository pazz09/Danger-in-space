package calculos;

public class vectores {
	
	private double x,y;
	public vectores(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public vectores()
	{
		x = 0;
		y = 0;
	}
	
	public vectores add(vectores v)
	{
		return new vectores(x + v.getX(),y + v.getY());
	}
	
	public vectores escala(double valor)
	{
		return new vectores(x*valor, y*valor);
	}
	
	public vectores limite(double valor)
	{
		
		if(getMagnitud() > valor)
		{
			return this.normalizar().escala(valor);
		}
		return this;
	}
	
	public vectores normalizar()
	{
		double magnitud = getMagnitud();
		return new vectores(x / magnitud, y / magnitud);
	}
	
	public double getMagnitud()
	{
		return Math.sqrt(x*x + y*y);
	}
	
	public vectores setDireccion(double angulo)
	{
		double magnitud = getMagnitud();
		return new vectores(Math.cos(angulo)*magnitud, Math.sin(angulo)*magnitud);
	}
	
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	

}
