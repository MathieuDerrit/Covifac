import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Fenetre extends JFrame {
	private JTextPane simulation = new JTextPane();
	private JTextPane donnee = new JTextPane();
	private JButton arreter = new JButton("stop");

	public Fenetre(String nom) {
		// cr�ation de le fen�tre
		super(nom);
		setSize(800,600); // dimensionnement de cette fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// définition des objets utilisés pour placer les composants
		 GridBagLayout placeur=new GridBagLayout(); // objet de placement des composants
		 GridBagConstraints contraintes=new GridBagConstraints(); // regles de placement
		 getContentPane().setLayout(placeur); // utiliser cet objet de placement pour la fenêtre
		 
		 // placement de la zone simulation
		 contraintes.gridx=0; contraintes.gridy=0; // coordonnées 0,0
		 contraintes.gridwidth=1; contraintes.gridheight=1; // 1 cases
		 contraintes.fill=GridBagConstraints.BOTH;
		 contraintes.anchor=GridBagConstraints.CENTER;
		 contraintes.weightx=50; contraintes.weighty=50;
		 contraintes.insets=new Insets(5,5,5,5);
		 contraintes.ipadx=2; contraintes.ipady=2;
		 placeur.setConstraints(simulation, contraintes);
		 getContentPane().add(simulation);
		 
		 // placement de la zone données
		 contraintes.gridx=550; contraintes.gridy=0; // coordonnées 0,2
		 contraintes.gridwidth=1; contraintes.gridheight=1; // occupe 1 case
		 contraintes.fill=GridBagConstraints.BOTH;
		 contraintes.anchor=GridBagConstraints.CENTER;
		 contraintes.weightx=10; contraintes.weighty=10;
		 contraintes.insets=new Insets(5,5,5,5);
		 contraintes.ipadx=2; contraintes.ipady=2;
		 placeur.setConstraints(donnee, contraintes);
		 getContentPane().add(donnee);
		 
		 // placement du bouton arreter la simulation
		 contraintes.gridx=550; contraintes.gridy=550; // coordonnées 2,0 
		 contraintes.gridwidth=1; contraintes.gridheight=3; // 3 cases en hauteur
		 contraintes.fill=GridBagConstraints.BOTH;
		 contraintes.anchor=GridBagConstraints.CENTER;
		 contraintes.weightx=0; contraintes.weighty=0;
		 contraintes.insets=new Insets(5,5,5,5);
		 contraintes.ipadx=10; contraintes.ipady=3;
		 placeur.setConstraints(arreter, contraintes);
		 getContentPane().add(arreter); 

		// Ajout des composants d'interface
		setVisible(true);
	}

	static public void main(String argv[]) { // Lancement
		new Fenetre("Covifac");
	}

}