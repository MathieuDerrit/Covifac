import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Fenetre extends JFrame {
	private JPanel pannelBas;					//Panel en bas
	private JPanel pannelDroite;				//Panel de droite
	private JPanel pannelGauche;				//Panel de gauche
	private JButton boutonScenario1;		//Bouton du scenario 1
	private JButton boutonScenario2;		//Bouton du scenario 2
	private JButton boutonScenario3;		//Bouton du scenario 3
	private JButton boutonStop;				//Bouton du scenario 1
	private Dimension dimensionFenetre;		//Dimension des fenêtres
	
	public Fenetre(String nomFenetre) {
		
		// création de le fenêtre
		super(nomFenetre);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Création de "hub", il s'agit du Layout "principal" de la Fenetre
		BorderLayout hub=new BorderLayout();
		getContentPane().setLayout(hub);	

		// Création et placement des composants de gauche (Relatif à l'ajout / retrait d'un personnage)
		this.pannelBas = new JPanel();
		pannelBas.setLayout(new GridLayout(1,5,5,5));		//Marge des boutons
		getContentPane().add(pannelBas, BorderLayout.SOUTH);	//On Ajoute le JPanel de gauche
			
		//MISE EN PLACE DES BOUTONS
			
			//Création du premier bouton
			this.boutonScenario1=new JButton("Scénario 1");
			this.pannelBas.add(this.boutonScenario1);	
			
			//Création du second bouton
			this.boutonScenario2=new JButton("Scénario 2");
			this.pannelBas.add(this.boutonScenario2);
			
			//Création du second bouton
			this.boutonScenario3=new JButton("Scénario 3");
			this.pannelBas.add(this.boutonScenario3);
			
			//Création du second bouton
			this.boutonStop=new JButton("Stop");
			this.pannelBas.add(this.boutonStop);

		//MISE EN PLACE DE LA FENETRE DE GAUCHE (simulateur)
			
			//Initialisation des dimensions des fenêtres 
			this.dimensionFenetre = new Dimension(600,550);	
				
			//Création et placement du composant au centre (salle)		
		    
			this.pannelGauche = new JPanel(){
				
			    
				//On surcharge la création de JPanel avec un "paintComponant" pour pouvoir créer le contour de la fenêtre
	            public void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                
	                //On créer le contour du simulateur
	                Salle salleSimulateur = new Salle(g, Color.BLACK, "",0, 0, 20, 20, 500, 500);                
	                
	                //Couloir
	                Salle salleCouloir = new Salle(g, Color.BLACK, "Couloir",250, 50, 220, 20, 100, 500); 
	                
	                //Salle 1
	                Salle salle1 = new Salle(g, Color.BLACK, "Salle 1",100, 50, 20, 20, 200, 500);
	                
	                //Salle 2
	                Salle salle2 = new Salle(g, Color.BLACK, "Salle 2",400, 50, 320, 20, 200, 250);
	                
	                //Salle 3
	                Salle salle3 = new Salle(g, Color.BLACK, "Salle 3",400, 300, 320, 270, 200, 250);
	                       
	                //Portes du couloir
	                Porte porteCouloirSortie = new Porte(g, Color.RED, 230, 20, 265, 20 );
	                Porte porteCouloirEntree = new Porte(g, Color.GREEN,275, 20, 310, 20);
	                
	                //Portes salle en bas à droite (salle 3)
	                Porte porteSalle3Sortie = new Porte(g, Color.RED, 320, 320, 320, 380 );
	                Porte porteSalle3Entree = new Porte(g, Color.GREEN, 320, 420, 320, 480);
	                
	                //Portes salle en haut à droite (salle 2)
	                Porte porteSalle2Sortie = new Porte(g, Color.RED, 320, 60, 320, 120 );
	                Porte porteSalle2Entree = new Porte(g, Color.GREEN, 320, 160, 320, 220);
	                
	                //Portes salle à gauche  (salle 1)
	                Porte porteSalle1Sortie = new Porte(g, Color.RED, 220, 160, 220, 220 );
	                Porte porteSalle1Entree = new Porte(g, Color.GREEN, 220, 320, 220, 380);

	            }
			};
			
			pannelGauche.setPreferredSize(this.dimensionFenetre);
			getContentPane().add(pannelGauche, BorderLayout.CENTER);			
			
			//Création et placement du composant de droite (console)
			this.pannelDroite = new JPanel(){
				
				//On surcharge la création de JPanel avec un "paintComponant" pour pouvoir créer le contour de la fenêtre
	            public void paintComponent(Graphics g) {
	                super.paintComponent(g);      	
	            	g.setColor(Color.GRAY);
	            	g.drawRect(100, 20, 300, 300);
	            	
	                g.setColor(Color.GRAY);
	                g.drawString("Salle 1 : 0/10", 120,50);
	                g.drawString("Salle 2 : 0/5", 120,80);
	                g.drawString("Salle 3 : 0/5", 120,110);
	                g.drawString("Couloir : 0/8", 120,140);
	            }
	        };
        
	        pannelDroite.setPreferredSize(this.dimensionFenetre);
			getContentPane().add(pannelDroite, BorderLayout.EAST);		
	
			// Afficher la fenetre
			pack();
			setVisible(true);
	}
	 
   
    public static void main(String[] args) {
    	new Fenetre("CoviFac");
    }
};
