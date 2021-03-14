import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


class Fenetre extends JFrame {
	private JPanel pannelBas;				//Panel contenant les boutons situé en bas
	private JPanel pannelDroite;			//Panel de droite contenant les informations des salles
	private JPanel pannelGauche;			//Panel de gauche contenant le simulateur 
	private JButton boutonScenario1;		//Bouton du scenario 1
	private JButton boutonScenario2;		//Bouton du scenario 2
	private JButton boutonScenario3;		//Bouton du scenario 3
	private JButton boutonStop;				//Bouton d'arret des scénarios
	private Dimension dimensionFenetre;		//Dimension des fenêtres
	
	//Tout les éléments dont le simulateur (pannel de droite) va avoir besoin (en public pour pouvoir interagir avec via d'autres classes)
	
	//Les salles
	public static Salle salleCouloir;
	public static Salle salle1;
	public static Salle salle2;
	public static Salle salle3;
	public static Salle salleSimulateur;
	
	//Les portes
	public static Porte porteCouloirSortie; 
	public static Porte porteCouloirEntree; 
	public static Porte porteSalle3Sortie; 
	public static Porte porteSalle3Entree; 
	public static Porte porteSalle2Sortie; 
	public static Porte porteSalle2Entree; 
	public static Porte porteSalle1Sortie; 
	public static Porte porteSalle1Entree; 
 
	//Les capteurs 
	public static Capteur capteurCouloirSortie;   
	public static Capteur capteurCouloirEntree; 
	public static Capteur capteurSalle3Sortie; 
	public static Capteur capteurSalle3Entree;    
	public static Capteur capteurSalle2Sortie;
	public static Capteur capteurSalle2Entree; 
	public static Capteur capteurSalle1Sortie;  
	public static Capteur capteurSalle1Entree; 
	
	//Constructeur de la fenêtre
	public Fenetre(String nomFenetre) {
		// création de le fenêtre
		super(nomFenetre);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		// Layout de la fenêtre
		BorderLayout layout=new BorderLayout();
		getContentPane().setLayout(layout);	
		
		// MISE EN PLACE DES BOUTONS (PANNEL DU BAS)	
			this.pannelBas = new JPanel();							//Initialisation du pannel du bas (pannel des boutons)
			pannelBas.setLayout(new GridLayout(1,5,5,5));			//GridLayout des boutons (pannel du bas)
			getContentPane().add(pannelBas, BorderLayout.SOUTH);	//Ajout du pannel à la fenêtre	
			
				//Création du bouton Scénario 1
				this.boutonScenario1=new JButton("Scénario 1");
				boutonScenario1.addActionListener(new ActionScenario1());
				this.pannelBas.add(this.boutonScenario1);	
				
				//Création du bouton Scénario 2
				this.boutonScenario2=new JButton("Scénario 2");
				boutonScenario2.addActionListener(new ActionScenario2());
				this.pannelBas.add(this.boutonScenario2);
				
				//Création du bouton Scénario 3
				this.boutonScenario3=new JButton("Scénario 3");
				boutonScenario3.addActionListener(new ActionScenario3());
				this.pannelBas.add(this.boutonScenario3);
				
				//Création du bouton Stop
				this.boutonStop=new JButton("Stop");
				boutonStop.addActionListener(new ActionStop());
				this.pannelBas.add(this.boutonStop);

		// MISE EN PLACE DU SIMULATEUR (PANNEL DE GAUCHE)	
			
			//Initialisation des dimensions de la fenêtres 
			this.dimensionFenetre = new Dimension(600,550);
			
			//Initialisation du pannel de gauche (pannel du simulateur)
			this.pannelGauche = new JPanel(){			
			    
				//Ajout du paintComponent pour pouvoir dessiner
	            public void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                
	                //On créer le contour du simulateur
	                salleSimulateur = new Salle(g, Color.BLACK, "",0, 0, 20, 20, 500, 500);                
	                
	                //Couloir
	                salleCouloir = new Salle(g, Color.BLACK, "Couloir 1",250, 15, 220, 20, 100, 500); 
	                
	                //Salle 1
	                salle1 = new Salle(g, Color.BLACK, "Salle 1",100, 50, 20, 20, 200, 500);
	                
	                //Salle 2
	                salle2 = new Salle(g, Color.BLACK, "Salle 2",400, 50, 320, 20, 200, 250);
	                
	                //Salle 3
	                salle3 = new Salle(g, Color.BLACK, "Salle 3",400, 300, 320, 270, 200, 250);
	                       
	                //Portes du couloir
	                porteCouloirSortie = new Porte(g, Color.YELLOW,275, 20, 310, 20);                		
	                porteCouloirEntree = new Porte(g, Color.GREEN, 230, 20, 265, 20 );
	                
	                //Portes salle en bas à droite (salle 3)
	                porteSalle3Sortie = new Porte(g, Color.YELLOW, 320, 320, 320, 380 );
	                porteSalle3Entree = new Porte(g, Color.GREEN, 320, 420, 320, 480);
	                
	                //Portes salle en haut à droite (salle 2)
	                porteSalle2Sortie = new Porte(g, Color.YELLOW, 320, 60, 320, 120 );
	                porteSalle2Entree = new Porte(g, Color.GREEN, 320, 160, 320, 220);
	                
	                //Portes salle à gauche  (salle 1)
	                porteSalle1Sortie = new Porte(g, Color.YELLOW, 220, 160, 220, 220 );
	                porteSalle1Entree = new Porte(g, Color.GREEN, 220, 320, 220, 380);
	                
	                //Capteurs du couloir
	                //Nombre de personnes max possible du couloir
	                int nbPersonnesMaxCouloir = 8;
	                capteurCouloirSortie = new Capteur(g, Color.RED, nbPersonnesMaxCouloir, 230, 25, 35, 20);   
	                capteurCouloirEntree = new Capteur(g, Color.RED, nbPersonnesMaxCouloir, 275, 25, 35, 20);
	                
	                //Capteurs salle en bas à droite (salle 3)
	                //Nombre de personnes max possible de la salle en bas à droite (salle 3)
	                int nbPersonnesMaxSalle3 = 5;
	                capteurSalle3Sortie = new Capteur(g, Color.RED, nbPersonnesMaxSalle3, 325, 320, 20, 60);
	                capteurSalle3Entree = new Capteur(g, Color.RED, nbPersonnesMaxSalle3, 325, 420, 20, 60);   
	                
	                //Capteurs salle en haut à droite (salle 2)
	                //Nombre de personnes max possible de la salle en haut à droite (salle 2)
	                int nbPersonnesMaxSalle2 = 5;
	                capteurSalle2Sortie = new Capteur(g, Color.RED, nbPersonnesMaxSalle2, 325, 60, 20, 60);
	                capteurSalle2Entree = new Capteur(g, Color.RED, nbPersonnesMaxSalle2, 325, 160, 20, 60);
	                
	                //Capteurs salle à gauche  (salle 1)
	                //Nombre de personnes max possible de la salle à gauche  (salle 1)
	                int nbPersonnesMaxSalle1 = 10;
	                capteurSalle1Sortie = new Capteur(g, Color.RED, nbPersonnesMaxSalle1, 195, 160, 20, 60);   
	                capteurSalle1Entree = new Capteur(g, Color.RED, nbPersonnesMaxSalle1, 195, 320, 20, 60);               
	                
	            }
			};								
			pannelGauche.setPreferredSize(this.dimensionFenetre);   	//Ajout des dimension au pannel
			pannelGauche.setBackground(Color.WHITE);					//Ajout d'un fond blanc au pannel
			getContentPane().add(pannelGauche, BorderLayout.CENTER); 	//Ajout du pannel à la fenêtre			
			
		// MISE EN PLACE DE LA "CONSOLE" (PANNEL DE DROITE)	AFFICHANT LES INFORMATIONS DES SALLES
			//Initialisation du pannel de droite (pannel de la "console")
			this.pannelDroite = new JPanel(){
				
				//Ajout du paintComponent pour pouvoir dessiner
	            public void paintComponent(Graphics g) {
	                super.paintComponent(g);      	
	            	g.setColor(Color.GRAY);
	            	g.drawRect(100, 20, 300, 300); //Rectangle gris représentent le cadre de la "console"
	            	
	            	//Informations des salles              
	                Message messageSalle1 = new Message(g, Color.BLACK, "Salle", 1, 10, 0,  120, 50, true); 	//Affiche : Salle 1 : 0/10
	                Message messageSalle2 = new Message(g, Color.BLACK, "Salle", 2, 5, 0,  120, 80, true);		//Affiche : Salle 2 : 0/5
	                Message messageSalle3 = new Message(g, Color.BLACK, "Salle", 3, 5, 0,  120, 110, true);		//Affiche : Salle 3 : 0/5
	                Message messageCouloir = new Message(g, Color.BLACK, "Couloir", 1, 8, 0,  120, 140, true);	//Affiche : Couloir 1 : 0/8
	            }
	        };       
	        pannelDroite.setPreferredSize(this.dimensionFenetre);	//Ajout des dimension au pannel
	        pannelDroite.setBackground(Color.WHITE);				//Ajout d'un fond blanc au pannel
			getContentPane().add(pannelDroite, BorderLayout.EAST);	//Ajout du pannel à la fenêtre	
	
			// Afficher la fenetre
			pack();
			setVisible(true);
	}
	
	//Méthode du bouton scénario 1 : 3 personnes dans la salle 1 , 3 personnes dans les salles 2 et 3 , 1 personne dans le couloir
	private class ActionScenario1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Graphics g = Fenetre.this.getGraphics(); //Récupération du graphique de la fenêtre
			
            int posX = 250; 	// x position ou la personne apparait
            int posY = 76; 		// y position ou la personne apparait
            int rayon = 5; 		//Rayon du cercle qui représente une personne
            
            List<Personne> personnes=new ArrayList<Personne>();      //Liste conteantn toute les personnes créent        
                       
            int nbPersonnes = 10; //Nombres de personnes à créer
            //Ajouter à la liste chauque personnes
            for(int i = 0; i <= nbPersonnes; i++)
            {
            	 personnes.add(new Personne(g, Color.BLUE, posX, posY, rayon));
            }

            //Placement de chaque personnes créent (non blouclé pour créer un effet d'aléatoire)
            //Placer la personne en x,y,salle
            personnes.get(0).deplacer(50, 400, 1);                
            personnes.get(1).deplacer(100, 300, 1);
            personnes.get(2).deplacer(150, 100, 1);
            personnes.get(3).deplacer(400, 100, 2);          
            personnes.get(4).deplacer(450, 150, 2);            
            personnes.get(5).deplacer(420, 200, 2);    
            personnes.get(6).deplacer(420, 350, 3);     
            personnes.get(7).deplacer(460, 400, 3);   
            personnes.get(8).deplacer(480, 450, 3);
            personnes.get(9).deplacer(270, 300, 4);
            
		}
	}
	
	//Méthode du bouton scénario 2 : 2 personnes dans la salle 1, 1 personne dans la salle 2, 5 personnes dans la salle 3 et 2 personnes dans le couloir
	private class ActionScenario2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Graphics g = Fenetre.this.getGraphics(); //Récupération du graphique de la fenêtre
			
            int posX = 250; 	// x position ou la personne apparait
            int posY = 76; 		// y position ou la personne apparait
            int rayon = 5; 		//Rayon du cercle qui représente une personne
            
            List<Personne> personnes=new ArrayList<Personne>();      //Liste conteantn toute les personnes créent               
                            
            int nbPersonnes = 10; //Nombres de personnes à créer
            //Ajouter à la liste chauque personnes
            for(int i = 0; i <= nbPersonnes; i++)
            {
            	 personnes.add(new Personne(g, Color.BLUE, posX, posY, rayon));
            }

            //Placement de chaque personnes créent (non blouclé pour créer un effet d'aléatoire)
            //Placer la personne en x,y,salle
            personnes.get(0).deplacer(50 , 400, 1);                
            personnes.get(1).deplacer(100, 300, 1);              
            personnes.get(2).deplacer(410, 100, 2);                
            personnes.get(3).deplacer(400, 410, 3);          
            personnes.get(4).deplacer(450, 380, 3);            
            personnes.get(5).deplacer(445, 430, 3);    
            personnes.get(6).deplacer(420, 450, 3);    
            personnes.get(7).deplacer(460, 500, 3);                   
            personnes.get(8).deplacer(250, 100, 4);
            personnes.get(9).deplacer(270, 300, 4);
            
		}
	}
	
	//Méthode du bouton scénario 3 : 8 personnes dans la couloir, 2 personnes dans la salle 2
	private class ActionScenario3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Graphics g = Fenetre.this.getGraphics(); //Récupération du graphique de la fenêtre
			
            int posX = 250; 	// x position ou la personne apparait
            int posY = 76; 		// y position ou la personne apparait
            int rayon = 5; 		//Rayon du cercle qui représente une personne
            
            List<Personne> personnes=new ArrayList<Personne>();      //Liste conteantn toute les personnes créent             
            
            int nbPersonnes = 10; //Nombres de personnes à créer
            //Ajouter à la liste chauque personnes
            for(int i = 0; i <= nbPersonnes; i++)
            {
            	 personnes.add(new Personne(g, Color.BLUE, posX, posY, rayon));
            }

            //Placement de chaque personnes créent (non blouclé pour créer un effet d'aléatoire)
            //Placer la personne en x,y,salle                                 
            personnes.get(0).deplacer(450, 150, 2);             
            personnes.get(1).deplacer(410, 100, 2);  
            personnes.get(2).deplacer(290, 500, 4);
            personnes.get(3).deplacer(260, 460, 4);          
            personnes.get(4).deplacer(270, 420, 4);            
            personnes.get(5).deplacer(265, 380, 4);    
            personnes.get(6).deplacer(275, 340, 4);    
            personnes.get(7).deplacer(263, 280, 4);  
            personnes.get(8).deplacer(268, 240, 4);
            personnes.get(9).deplacer(277, 150, 4);
            
		}
	}
	
	//Méthode du bouton stop (reaffiche la fenêtre sans scénario)
	private class ActionStop implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
	
	public static void main(String[] args) {
    	new Fenetre("CoviFac"); //Affiche la fenêtre
    }
};
