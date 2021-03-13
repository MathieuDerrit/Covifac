import java.awt.Color;
import java.awt.Graphics;



public class Capteur {
	
	private Graphics g;
	private Color c;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	int nbPersonnes;

	
	public Capteur(Graphics g, Color c, int nbPersonnes, int x1, int y1,  int x2, int y2) {
		this.g = g; 
		this.c = c;
		this.nbPersonnes = nbPersonnes;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y1 = y1;	
		g.setColor(c);
		g.fillRect(x1, y1, x2, y2);
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



	public int getX1() {
		return x1;
	}



	public void setX1(int x1) {
		this.x1 = x1;
	}



	public int getY1() {
		return y1;
	}



	public void setY1(int y1) {
		this.y1 = y1;
	}



	public int getX2() {
		return x2;
	}



	public void setX2(int x2) {
		this.x2 = x2;
	}



	public int getY2() {
		return y2;
	}



	public void setY2(int y2) {
		this.y2 = y2;
	}



	public int getNbPersonnes() {
		return nbPersonnes;
	}



	public void setNbPersonnes(int nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
