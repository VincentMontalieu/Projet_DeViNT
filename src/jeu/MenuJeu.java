/*  Classe de menu de lancement de l'exemple de jeu.
 *  Cette classe herite de la classe abstraite MenuAbstrait en definissant les methodes :
 *     - nomOptions qui renvoie la liste des options possibles pour le menu 
 *     - lancerOption qui associe une action e chaque option du menu
 *     - wavAccueil() qui renvoie le nom du fichier wav lu lors de l'accueil dans le menu
 *     - wavAide() qui renvoie le nom du fichier wav lu lors de l'activation de la touche F1
 */

package jeu;

import instruments.Clavier;
import devintAPI.MenuAbstrait;
import enigme.Enigme;
import enigme.EnigmeManager;

public class MenuJeu extends MenuAbstrait {

	/**
	 * constructeur
	 * 
	 * @param title
	 *            : le nom du jeu
	 */
	public MenuJeu(String title) {
		super(title);
	}

	/**
	 * renvoie le nom des options du menu vous pouvez definir autant d'options
	 * que vous voulez
	 **/
	protected String[] nomOptions() {
		String[] noms = { "Test questions", "Test clavier"};
//		String[] noms = { "Jouer"};
		return noms;
	}

	/**
	 * lance l'action associee au bouton nei la numerotation est celle du
	 * tableau renvoye par nomOption
	 */
	protected void lancerOption(int i) {
		switch (i) {
		case 0:
			EnigmeManager.creerEnigmes();
			new Enigme(EnigmeManager.prochaineEnigme(), 0, 1);
			break;
		case 1:
			new MenuClavier("Test Clavier");
			break;
		default:
			System.err.println("action non definie");
		}
	}

	// renvoie le fichier wave contenant le message d'accueil
	// ces fichiers doivent etre places dans ressources/sons/
	protected String wavAccueil() {
		return "../ressources/sons/accueil.wav";
	}

	// renvoie le fichier wave contenant la regle du jeu
	protected String wavRegleJeu() {
		return "../ressources/sons/accueil.wav";
	}

}
