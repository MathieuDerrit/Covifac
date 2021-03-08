import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Fenetre extends JFrame {
	private JTextField saisie; // zone de saisie du mdp
	private JProgressBar attente; // barre de progression
	private final String mdp = "java"; // Code de validation 

	public Fenetre(String nom) {
		// cr�ation de le fen�tre
		super(nom);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// placement des composants d'interface (3 lignes)
		GridLayout placeur=new GridLayout(3,1,1,1);
		getContentPane().setLayout(placeur);

		// Ajout des composants d'interface
		pack();
		setVisible(true);
	}

	static public void main(String argv[]) { // Lancement
		new Fenetre("Covifac");
	}

}