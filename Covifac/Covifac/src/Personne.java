import java.awt.*;

public class Personne {
	
	Graphics g; //Le graphique de la personne
	Color c;	//Couleur de la personne
	int x; 		//Position x de la personne
	int y;		//Position y de la personne
	int rayon;	//Rayon du cercle représentent une personne
	
	public Personne(Graphics g, Color c, int x, int y, int rayon) {
		
		this.g = g; 
		this.c = c; 
		this.x = x;
		this.y = y;
		this.rayon = rayon;
		
		g.setColor(c);						//Couleur de la personne
		g.drawOval(x, y, rayon*2, rayon*2);	//Dessin de la personne
	
	}
	
	//Methode permettant le déplacement des personnes
	public void deplacer(int x, int y, int salle) {
		
		int compteur = 0;	//Compteur pour connaitre le nombre de personnes dans une salle
		
		//Ajoute 1 au nombre de personnes dans le couloir et l'affiche
        Fenetre.capteurCouloirEntree.addCompteur();
        compteur = Fenetre.capteurCouloirEntree.getCompteur();
        new Message(g, Color.BLACK, "Couloir", 1, 8, compteur,  728, 171, true);
        
        //Si le couloir est complet on ferme les porte de sortie des salle est celle de l'entée du couloir
        if(Fenetre.capteurCouloirEntree.estComplet())
        {
            new Porte(g, Color.PINK, 228, 191, 228, 251);
            new Porte(g, Color.PINK, 328, 91, 328, 151);
            new Porte(g, Color.PINK, 328, 351, 328, 411);
            new Porte(g, Color.MAGENTA,238, 51, 273, 51);
        }
        //Sinon les portes de sortie des salles et entrée du couloir sont ouverte
        else
        {
            new Porte(g, Color.YELLOW, 228, 191, 228, 251);
            new Porte(g, Color.YELLOW, 328, 91, 328, 151);
            new Porte(g, Color.YELLOW, 328, 351, 328, 411);
            new Porte(g, Color.GREEN,238, 51, 273, 51 );
        }           
		
        //Si la personne se déplace dans la salle 1
		if(salle == 1)
		{
			//Tant que la position x et y de la personne ne sont pas égale aux positions x et y final donnée
			while(Personne.this.getX() != x && Personne.this.getY() != y)
			{
				//Tant que la personne a une position différente de 375 (devant la porte de la salle 1)
				while(Personne.this.getY() != 375)
				{
					//Effacement de l'ancien placement de la personne et affichage du nouveau (position y augmente de 1)
					new Personne(this.g, Color.WHITE, this.x, this.y, this.rayon);	//Effacement de l'ancienne position de la personne
					Personne.this.setY(Personne.this.getY() + 1);					//Position y + 1 de la personne
					new Personne(this.g, this.c, this.x, this.y, this.rayon);		//Affiche de la personne à sa nouvelle position
					//Processus en attente pour que se soit visible et pas trop rapide
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//Tant que la position x de la personne n'est pas égale a la positon x final donnée
				while(Personne.this.getX() != x)
				{
					//Si la position x de la personne est égale à 220 (celle de la porte)
	                if(Personne.this.getX() == 220)
	                {
	                	//Soustraction d'une personne sur l'affichage du nombre de personnes dans le couloir
	                    Fenetre.capteurCouloirEntree.subCompteur();
	                    compteur = Fenetre.capteurCouloirEntree.getCompteur();
	                    new Message(g, Color.BLACK, "Couloir", 1, 8, compteur,  728, 171, false);	                	
	                    //Addition d'une personne sur l'affichage du nombre de personnes dans la salle 1
	                    Fenetre.capteurSalle1Entree.addCompteur();
	                    compteur = Fenetre.capteurSalle1Entree.getCompteur();
	                    new Message(g, Color.BLACK, "Salle", salle, 10, compteur,  728, 81, true);
	                }
	                //Si la salle est complete
	                if(Fenetre.capteurSalle1Entree.estComplet())
	                {
	                	new Porte(g, Color.MAGENTA, 228, 351, 228, 411); //La porte d'entrée est fermé
	                }
	                else
	                {
	                	new Porte(g, Color.GREEN, 228, 351, 228, 411);	//La porte d'entrée est ouverte
	                }
	                //La personne se déplace sur la gauche (sa position x - 1 )
	                new Capteur(g, Color.RED, 10, 203, 351, 20, 60);				//Reaffichage du capteur sur lequel est passé la personne
					new Personne(this.g, Color.WHITE, this.x, this.y, this.rayon); 	//Effacement de l'ancienne position de la personne
					Personne.this.setX(Personne.this.getX() - 1);					//Position x - 1 de la personne
					new Personne(this.g, this.c, this.x, this.y, this.rayon);		//Affiche de la personne à sa nouvelle position
					//Processus en attente pour que se soit visible et pas trop rapide
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//Tant que la postion y de la personne est supérieur à la position y final donnée
				while(Personne.this.getY() > y)
				{
					//Effacement de l'ancien placement de la personne et affichage du nouveau (position y diminue de 1)
					new Personne(this.g, Color.WHITE, this.x, this.y, this.rayon); 	//Effacement de l'ancienne position de la personne
					Personne.this.setY(Personne.this.getY() - 1);					//Position y - 1 de la personne
					new Personne(this.g, this.c, this.x, this.y, this.rayon);		//Affiche de la personne à sa nouvelle position
					//Processus en attente pour que se soit visible et pas trop rapide
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//Tant que la position y de la personne est inférieur à la position y final donnée
				while(Personne.this.getY() < y)
				{
					//Effacement de l'ancien placement de la personne et affichage du nouveau (position y augmente de 1)
					new Personne(this.g, Color.WHITE, this.x, this.y, this.rayon);	//Effacement de l'ancienne position de la personne
					Personne.this.setY(Personne.this.getY() + 1);					//Position y + 1 de la personne
					new Personne(this.g, this.c, this.x, this.y, this.rayon);		//Affiche de la personne à sa nouvelle position
					//Processus en attente pour que se soit visible et pas trop rapide
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
				
		}
		//Si la personne se déplace dans la salle 2
		if(salle == 2)
		{
			//Tant que la position x et y de la personne ne sont pas égale aux positions x et y final donnée
			while(Personne.this.getX() != x && Personne.this.getY() != y)
			{
				//Tant que la personne a une position différente de 220 (devant la porte de la salle 2)
				while(Personne.this.getY() != 220)
				{
					//Effacement de l'ancien placement de la personne et affichage du nouveau (position y augmente de 1)
					new Personne(this.g, Color.WHITE, this.x, this.y, this.rayon);	//Effacement de l'ancienne position de la personne
					Personne.this.setY(Personne.this.getY() + 1);					//Position y + 1 de la personne
					new Personne(this.g, this.c, this.x, this.y, this.rayon);		//Affiche de la personne à sa nouvelle position
					//Processus en attente pour que se soit visible et pas trop rapide
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//Tant que la position x de la personne n'est pas égale a la positon x final donnée
				while(Personne.this.getX() != x)
				{
					//Si la position x de la personne est égale à 320 (celle de la porte)
	                if(Personne.this.getX() == 320)
	                {
	                	//Soustraction d'une personne sur l'affichage du nombre de personnes dans le couloir
	                	Fenetre.capteurCouloirEntree.subCompteur();
	                    compteur = Fenetre.capteurCouloirEntree.getCompteur();
	                    new Message(g, Color.BLACK, "Couloir", 1, 8, compteur,  728, 171, false);
	                    //Addition d'une personne sur l'affichage du nombre de personnes dans la salle 2
	                    Fenetre.capteurSalle2Entree.addCompteur();
	                    compteur = Fenetre.capteurSalle2Entree.getCompteur();
	                    new Message(g, Color.BLACK, "Salle", salle, 5, compteur,  728, 111, true);
	                }
	                //Si la salle est complete
	                if(Fenetre.capteurSalle2Entree.estComplet())
	                {
	                	new Porte(g, Color.MAGENTA, 328, 191, 328, 251); //La porte d'entrée est fermé
	                }
	                else
	                {
	                	new Porte(g, Color.GREEN, 328, 191, 328, 251); 	//La porte d'entrée est ouverte
	                }
	                //La personne se déplace sur la droite (sa position x + 1 )
	                new Capteur(g, Color.RED, 5, 333, 191, 20, 60);					//Reaffichage du capteur sur lequel est passé la personne
					new Personne(this.g, Color.WHITE, this.x, this.y, this.rayon);	//Effacement de l'ancienne position de la personne
					Personne.this.setX(Personne.this.getX() + 1);					//Position x + 1 de la personne
					new Personne(this.g, this.c, this.x, this.y, this.rayon);		//Affiche de la personne à sa nouvelle position
					//Processus en attente pour que se soit visible et pas trop rapide
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//Tant que la postion y de la personne est supérieur à la position y final donnée
				while(Personne.this.getY() > y)
				{
					//Effacement de l'ancien placement de la personne et affichage du nouveau (position y diminue de 1)
					new Personne(this.g, Color.WHITE, this.x, this.y, this.rayon); 	//Effacement de l'ancienne position de la personne
					Personne.this.setY(Personne.this.getY() - 1);					//Position y - 1 de la personne
					new Personne(this.g, this.c, this.x, this.y, this.rayon);
					//Processus en attente pour que se soit visible et pas trop rapide
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//Tant que la postion y de la personne est inférieur à la position y final donnée
				while(Personne.this.getY() < y)
				{
					//Effacement de l'ancien placement de la personne et affichage du nouveau (position y augmente de 1)
					new Personne(this.g, Color.WHITE, this.x, this.y, this.rayon);	//Effacement de l'ancienne position de la personne
					Personne.this.setY(Personne.this.getY() + 1);					//Position y + 1 de la personne
					new Personne(this.g, this.c, this.x, this.y, this.rayon);		//Affiche de la personne à sa nouvelle position
					//Processus en attente pour que se soit visible et pas trop rapide
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
				
		}
		//Si la personne se déplace dans la salle 3
		if(salle == 3)
		{
			//Tant que la position x et y de la personne ne sont pas égale aux positions x et y final donnée
			while(Personne.this.getX() != x && Personne.this.getY() != y)
			{
				//Tant que la personne a une position différente de 470 (devant la porte de la salle 3)
				while(Personne.this.getY() != 470)
				{
					//Effacement de l'ancien placement de la personne et affichage du nouveau (position y augmente de 1)
					new Personne(this.g, Color.WHITE, this.x, this.y, this.rayon);	//Effacement de l'ancienne position de la personne
					Personne.this.setY(Personne.this.getY() + 1);					//Position y + 1 de la personne
					new Personne(this.g, this.c, this.x, this.y, this.rayon);		//Affiche de la personne à sa nouvelle position
					//Processus en attente pour que se soit visible et pas trop rapide
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//Tant que la position x de la personne n'est pas égale a la positon x final donnée
				while(Personne.this.getX() != x)
				{
					//Si la position x de la personne est égale à 320 (celle de la porte)
	                if(Personne.this.getX() == 320)
	                {
	                	//Soustraction d'une personne sur l'affichage du nombre de personnes dans le couloir
	                	Fenetre.capteurCouloirEntree.subCompteur();
	                    compteur = Fenetre.capteurCouloirEntree.getCompteur();
	                    new Message(g, Color.BLACK, "Couloir", 1, 8, compteur,  728, 171, false);
	                  //Addition d'une personne sur l'affichage du nombre de personnes dans la salle 3
	                    Fenetre.capteurSalle3Entree.addCompteur();
	                    compteur = Fenetre.capteurSalle3Entree.getCompteur();
	                    new Message(g, Color.BLACK, "Salle", salle, 5, compteur,  728, 141, true);
	                }
	                //Si la salle est complete
	                if(Fenetre.capteurSalle3Entree.estComplet())
	                {
	                	new Porte(g, Color.MAGENTA, 328, 451, 328, 511); //La porte d'entrée est fermé
	                }
	                else
	                {
	                	new Porte(g, Color.GREEN, 328, 451, 328, 511); 	//La porte d'entrée est ouverte
	                }
	                //La personne se déplace sur la droite (sa position x + 1 )
	                new Capteur(g, Color.RED, 5, 333, 451, 20, 60);					//Reaffichage du capteur sur lequel est passé la personne
					new Personne(this.g, Color.WHITE, this.x, this.y, this.rayon); 	//Effacement de l'ancienne position de la personne
					Personne.this.setX(Personne.this.getX() + 1);					//Position x + 1 de la personne
					new Personne(this.g, this.c, this.x, this.y, this.rayon);		//Affiche de la personne à sa nouvelle position
					//Processus en attente pour que se soit visible et pas trop rapide
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//Tant que la postion y de la personne est supérieur à la position y final donnée
				while(Personne.this.getY() > y)
				{
					//Effacement de l'ancien placement de la personne et affichage du nouveau (position y diminue de 1)
					new Personne(this.g, Color.WHITE, this.x, this.y, this.rayon);	//Effacement de l'ancienne position de la personne
					Personne.this.setY(Personne.this.getY() - 1);					//Position y - 1 de la personne
					new Personne(this.g, this.c, this.x, this.y, this.rayon);		//Affiche de la personne à sa nouvelle position
					//Processus en attente pour que se soit visible et pas trop rapide
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//Tant que la postion y de la personne est inférieur à la position y final donnée
				while(Personne.this.getY() < y)
				{
					//Effacement de l'ancien placement de la personne et affichage du nouveau (position y augmente de 1)
					new Personne(this.g, Color.WHITE, this.x, this.y, this.rayon);	//Effacement de l'ancienne position de la personne
					Personne.this.setY(Personne.this.getY() + 1);					//Position y + 1 de la personne
					new Personne(this.g, this.c, this.x, this.y, this.rayon);		//Affiche de la personne à sa nouvelle position
					//Processus en attente pour que se soit visible et pas trop rapide
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
				
		}
		
		//Si la personne se déplace dans la salle 4 (le couloir)
		if(salle == 4)
		{
			//Tant que la position x et y de la personne ne sont pas égale aux positions x et y final donnée
			while(Personne.this.getX() != x && Personne.this.getY() != y)
			{
				//Tant que la postion y de la personne est supérieur à la position y final donnée
				while(Personne.this.getY() > y)
				{
					//Effacement de l'ancien placement de la personne et affichage du nouveau (position y diminue de 1)
					new Personne(this.g, Color.WHITE, this.x, this.y, this.rayon);	//Effacement de l'ancienne position de la personne
					Personne.this.setY(Personne.this.getY() - 1);					//Position y - 1 de la personne
					new Personne(this.g, this.c, this.x, this.y, this.rayon);		//Affiche de la personne à sa nouvelle position
					//Processus en attente pour que se soit visible et pas trop rapide
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//Tant que la postion y de la personne est inférieur à la position y final donnée
				while(Personne.this.getY() < y)
				{
					//Effacement de l'ancien placement de la personne et affichage du nouveau (position y augmente de 1)
					new Personne(this.g, Color.WHITE, this.x, this.y, this.rayon);	//Effacement de l'ancienne position de la personne
					Personne.this.setY(Personne.this.getY() + 1);					//Position y + 1 de la personne
					new Personne(this.g, this.c, this.x, this.y, this.rayon);		//Affiche de la personne à sa nouvelle position
					//Processus en attente pour que se soit visible et pas trop rapide
					try {		
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//Tant que la postion x de la personne est inférieur à la position x final donnée
				while(Personne.this.getX() < x)
				{
					//Effacement de l'ancien placement de la personne et affichage du nouveau (position x augmente de 1)
					new Personne(this.g, Color.WHITE, this.x, this.y, this.rayon);	//Effacement de l'ancienne position de la personne
					Personne.this.setX(Personne.this.getX() + 1);					//Position x + 1 de la personne
					new Personne(this.g, this.c, this.x, this.y, this.rayon);		//Affiche de la personne à sa nouvelle position
					//Processus en attente pour que se soit visible et pas trop rapide
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//Tant que la postion x de la personne est inférieur à la position x final donnée
				while(Personne.this.getX() > x)
				{
					//Effacement de l'ancien placement de la personne et affichage du nouveau (position x diminue de 1)
					new Personne(this.g, Color.WHITE, this.x, this.y, this.rayon);	//Effacement de l'ancienne position de la personne
					Personne.this.setX(Personne.this.getX() - 1);					//Position x + 1 de la personne
					new Personne(this.g, this.c, this.x, this.y, this.rayon);		//Affiche de la personne à sa nouvelle position
					//Processus en attente pour que se soit visible et pas trop rapide
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
							
			}
				
		}
				
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

}
