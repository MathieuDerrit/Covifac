import java.awt.*;



public class Salle {
	
	private Graphics g;
	private Color c;
	private String nom;
	private int xNom; 
	private int yNom;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public Salle(Graphics g, Color c, String nom, int xNom, int yNom, int x1, int y1, int x2, int y2) {
		this.g = g; 
		this.c = c; 
		this.nom = nom; 
		this.xNom = xNom;
		this.yNom = yNom;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y1 = y1;
		
		g.setColor(c);
		g.drawString(nom, xNom, yNom);
		g.drawRect(x1, y1, x2, y2);
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getxNom() {
		return xNom;
	}

	public void setxNom(int xNom) {
		this.xNom = xNom;
	}

	public int getyNom() {
		return yNom;
	}

	public void setyNom(int yNom) {
		this.yNom = yNom;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
