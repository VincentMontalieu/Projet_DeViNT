/** 
Cette classe abstraite est un Frame associe e une instance de voix 
 * SI_VOX et qui implemente KeyListener.
 * Elle peut servir de classe mere e toutes les fenetres de vos jeux :
 * il suffit de definir la methode "init" pour initialiser les elements du Frame
 */

package devintAPI;

import java.awt.event.*;

/**
 * Classe abstraite avec un Frame, une instance de SI_VOX pour parler et qui
 * ecoute les evenements clavier avec gestion des preferences. Par defaut, un
 * son est lu e l'activation de la fenetre, on sort de la fenetre par ESC et on
 * obtient la regle du jeu par F1, l'aide par F2
 * 
 * @author helene
 * 
 */
public abstract class FenetreAbstraite extends DevintFrameListener implements
		ActionListener {

	/**
	 * @param title
	 *            : titre de la fenetre
	 */
	public FenetreAbstraite(String title) {
		super(title);
		// methode init e implementer, elle construit ce qui est dans le frame
		// init();
		// visible
		this.setVisible(true);
		// a le focus
		this.requestFocus();
	}

	/**
	 * methode abstraite e implementer pour definir ce qu'il y a dans le Frame
	 */
	protected abstract void init();

	/**
	 * methode abstraite e implementer
	 * 
	 * @return le fichier wav contenant le message d'aide (active par F2)
	 */
	protected abstract String wavAide();

	// ////////////////////////////////////////////
	// Gestion des evenements clavier
	// ///////////////////////////////////////////
	public void keyPressed(KeyEvent e) {
		// gestion de ESC, F1, F3 et F4 dans la classe mere
		// (DevintFrameListener)
		super.keyPressed(e);
		// on ajoute la gestion de l'aide quand on presse F2
		if (e.getKeyCode() == KeyEvent.VK_F2) {
			voix.playWav(wavAide());
		}
	}

	/**
	 * Pour modifier les couleurs de fond et de premier plan de la fenetre Cette
	 * fonction est appelee par la fonction "changeColor" de la classe
	 * "Preferences" e chaque fois que l'on presse F3
	 * 
	 * Cette methode doit etre reecrite dans les classes filles si cela n'a pas
	 * de sens pour votre jeu, vous la redefinissez en la laissant vide
	 **/
	public abstract void changeColor();

}
