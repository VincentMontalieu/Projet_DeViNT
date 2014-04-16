package jeu;

import javax.swing.*;
import javax.swing.border.LineBorder;

import devintAPI.FenetreAbstraite;

import java.awt.*;
import java.awt.event.*;

/**
 * Etend DevintFrame pour avoir un Frame et reagir aux evenements claviers
 * Contient un exemple d'affichage d'image proportionnel e la taille de l'ecran
 * 
 * @author helene
 * 
 */

public class UneImage extends FenetreAbstraite {

	public UneImage(String title) {
		super(title);
		init();
	}

	// renvoie le fichier wave contenant le message d'accueil
	protected String wavAccueil() {
		return "../ressources/sons/accueilImage.wav";
	}

	// renvoie le fichier wave contenant la regle du jeu
	protected String wavRegleJeu() {
		return "../ressources/sons/accueilImage.wav";
	}

	// renvoie le fichier wave contenant la regle du jeu
	protected String wavAide() {
		return "../ressources/sons/aide.wav";
	}

	// initialise le frame
	protected void init() {
		// FlowLayout : les composants ont leur taille fixee par
		// setPreferredSize
		// et sont ajoutes de gauche e droite, de haut en bas
		setLayout(new FlowLayout());

		// la largeur et la hauteur actuelle de la fenetre
		// si vous fixez la taille des elements graphiques
		// faites le en utilisant des valeurs proportionnelles e la taille
		// de la fenetre pour que differentes resolutions d'ecran soient
		// possibles
		int largeur = Toolkit.getDefaultToolkit().getScreenSize().width;
		int hauteur = Toolkit.getDefaultToolkit().getScreenSize().height;

		String texte = "\nIci le layout est un \"FlowLayout\". Les composants sont ajoutes de gauche e droite et de haut en bas.";
		texte += "\nLa taille des composants est celle de \"setPreferredSize\" ou bien la taille optimale pour obtenir un frame le plus petit possible.";
		texte += "\n\nVoici les personnages du jeu Lea et Theo, 2007.";
		JTextArea theoTexte = new JTextArea(texte);
		theoTexte.setLineWrap(true);
		theoTexte.setEditable(false);
		add(theoTexte);

		// une image, voir
		// http://java.sun.com/docs/books/tutorial/uiswing/components/icon.html
		ImageIcon icon = new ImageIcon("../ressources/images/theo.JPG");
		texte = "Theo est dans un label a un fond bleu qui occupe la moitie de la largeur et le tiers de la hauteur.";
		// on met l'image dans un label
		JLabel jl = new JLabel(texte, icon, JLabel.CENTER);
		jl.setAutoscrolls(true);
		jl.add(new Scrollbar());
		// fond bleu
		jl.setBackground(Color.BLUE);
		// composant opaque pour voir le fond bleu
		jl.setOpaque(true);
		// (largeur de la fenetre)/2 et (hauteur fenetre)/3
		jl.setPreferredSize(new Dimension(largeur / 2, hauteur / 3));
		add(jl);

		// Lea
		icon = new ImageIcon("../ressources/images/lea.JPG");
		texte = "Ceci est Lea";
		JLabel jl2 = new JLabel(texte, icon, JLabel.CENTER);
		add(jl2);
	}

	@Override
	/** 
	 * pour cette fenetre, changer la couleur n'a pas de sens, alors la methode
	 * ne fait rien
	 */
	public void changeColor() {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
