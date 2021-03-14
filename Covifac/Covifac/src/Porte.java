import java.awt.*;
import javax.swing.*;

public class Porte extends JPanel {
	
	private Graphics g; //Le graphique de la porte
	private Color c; 	//Couleur de la porte
	private int x1; 	//Position x du premier point (pour dessiner la ligne) de la porte
	private int y1; 	//Position y du premier point (pour dessiner la ligne) de la porte
	private int x2; 	//Position x du deuxieme point (pour dessiner la ligne) de la porte
	private int y2;		//Position y du deuxieme point (pour dessiner la ligne) de la porte
	
	public Porte(Graphics g, Color c, int x1, int y1, int x2, int y2) {
		
		this.g = g; 
		this.c = c; 
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y1 = y1;
		
		g.setColor(c);				//Couleur des dessins
        g.drawLine(x1, y1, x2, y2);	//Dessine la ligne de la porte
	}
	
	//GETTERS & SETTERS
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

}
