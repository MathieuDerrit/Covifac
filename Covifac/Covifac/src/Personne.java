import java.awt.*;

public class Personne {
	
	Graphics g; 
	Color c;
	int x; 
	int y;
	int rayon;
	
	public Personne(Graphics g, Color c, int x, int y, int rayon) {
		
		this.g = g; 
		this.c = c; 
		this.x = x;
		this.y = y;
		this.rayon = rayon;
		g.setColor(c);
		g.drawOval(x, y, rayon*2, rayon*2);
	
	}
	
	

	public Graphics getG() {
		return g;
	}



	public void setG(Graphics g) {
		this.g = g;
	}



	public Color getC() {
		return c;
	}



	public void setC(Color c) {
		this.c = c;
	}



	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public int getRayon() {
		return rayon;
	}



	public void setRayon(int rayon) {
		this.rayon = rayon;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
