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
