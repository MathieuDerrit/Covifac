import java.awt.Color;
import java.awt.Graphics;



public class Capteur {
	
	private Graphics g;			//Le graphique du capteur
	private Color c;			//Couleur du capteur
	private int x1;				//Position x du premier point (pour dessiner le rectangle) du capteur
	private int y1;				//Position y du premier point (pour dessiner le rectangle) du capteur
	private int x2;				//Position x du deuxieme point (pour dessiner le rectangle) du capteur
	private int y2;				//Position y du deuxieme point (pour dessiner le rectangle) du capteur
	private int nbPersonnes;	//Nombre de personnes maximum autoriser à rentrer dans la salle
	private int compteur = 0;	//Nombre de personnes actuel dans la salle
		
	public Capteur(Graphics g, Color c, int nbPersonnes, int x1, int y1,  int x2, int y2) {
		
		this.g = g; 
		this.c = c;
		this.nbPersonnes = nbPersonnes;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y1 = y1;
		
		g.setColor(c);				//Couleur des dessins
		g.fillRect(x1, y1, x2, y2);	//Dessine le contour du capteur
	}
	
	//Methode d'incrementation du compteur
	public void addCompteur()
	{		
		compteur++;		
	}
	
	//Methode de decrementation du compteur
	public void subCompteur()
	{		
		compteur--;		
	}
	
	//Methode qui renvoi true si le nombre de personnes entrée est égale au nombre de personnes maximum autorisé
	public boolean estComplet() 
	{		
		return(compteur >= nbPersonnes) ? true : false;	
	}	
	
	//GETTERS & SETTERS
	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
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

}
