import java.awt.Color;
import java.awt.Graphics;

public class Message {
	
	private Graphics g;				//Le graphique du message
	private Color c;				//Couleur du message
	private String nom;				//Nom de la salle
	private int salle;				//Numero de la salle 
	private int nbMax; 				//Nombre maximum de personnes autorisé dans la salle
	private int compteur; 			//Nombre de perosnnes actuel dans la salle
	private int x;					//Position x du message
	private int y;					//Position y du message
	private boolean estAddition; 	//True si le message a afficher contient un nombre de personnes actuel dans la salle supérieur à celui d'avant
	
	
	public Message(Graphics g, Color c, String nom, int salle, int nbMax, int compteur, int x, int y, boolean estAddition) {
		
		this.g = g; 
		this.c = c;
		this.nom = nom;
		this.salle = salle;
		this.nbMax = nbMax;
		this.compteur =compteur;
		this.x = x;
		this.y = y;
		this.estAddition = estAddition;
		
		g.setColor(Color.WHITE);											//Couleur blanc (comme le background de la fenêtre pour pouvoir effacer l'ancien message
		
		if(estAddition)
		{
			g.drawString(nom+" "+salle+" : "+(compteur-1)+"/"+nbMax, x,y);	//Efface l'ancien message qui contené un nombre de personnes actuel dans la salle inférieur au nouveau
		}
		else
		{
			g.drawString(nom+" "+salle+" : "+(compteur+1)+"/"+nbMax, x,y);	//Efface l'ancien message qui contené un nombre de personnes actuel dans la salle supérieur au nouveau
		}
		
		g.setColor(c);														//Couleur du nouveau message
		g.drawString(nom+" "+salle+" : "+compteur+"/"+nbMax, x,y);			//Nouveau message
		
	}

}
