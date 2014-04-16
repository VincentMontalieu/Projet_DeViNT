/**
 * @author LOGRE Ivan, MULLER Stephane, GUYADER Erwan
 * Eleves SI3 en 2010-2011
 **/

package devintAPI;

import java.awt.Color;
//import java.io.File;
import java.util.ArrayList;
import java.util.List;


import t2s.SIVOXDevint;

import devintAPI.FenetreAbstraite;

/**
 * classe pour stocker les preferences de couleurs et de voix SIVOX
 * 
 * On change de jeu de couleurs en tapant F3.
 * On choisi la voix en tapant 
 *
 */
public class Preferences {

	/** The instance of the singleton. */
	private static Preferences instance;

	/** liste des classes (i.e. fenetres) qui vont utiliser ces preferences
	 *  ces classes heritent de MenuAbstrait ou DevintFrame
	 *  */
	private List<DevintFrameListener> openedWinndows;
	
	/** les valeurs choisies */
	// la voix
	private int currentVoice;
	private SIVOXDevint voix;
	
	// le jeu de couleurs
	private int currentSetOfColor;
	private Color foregroundColor;
	private Color backgroundColor;
	
	/** pour creer l'instance de Data */
	public static Preferences getData() {
		if (instance == null) {
			instance = new Preferences();
		}
		return instance;
	}

	/**
	 * Instantiates a new data.
	 */
	private Preferences() {
		openedWinndows = new ArrayList<DevintFrameListener>();
		foregroundColor = new Color(10, 0, 150);
		backgroundColor = Color.WHITE;
		currentSetOfColor = 0;
		currentVoice = 4;
		voix = new SIVOXDevint(currentVoice);
	}

	/**
	 * pour changer la couleur
	 * on passe d'un jeu predefini e un autre
	 */
	public void changeColor() {
		if (currentSetOfColor == 0) {
			// jeu de couleurs gris/rose
			this.foregroundColor = new Color(49,79,79); // Dark Slate Gray
			this.backgroundColor = new Color(255,182,193); // hot pink
			currentSetOfColor = 1;
		} else if (currentSetOfColor == 1) {
			// jeu de couleurs noir/jaune
			this.foregroundColor = Color.BLACK;
			this.backgroundColor = Color.YELLOW;
			currentSetOfColor = 2;
		} else if (currentSetOfColor == 2) {
			// jeu de couleur de base
			this.foregroundColor = new Color(10, 0, 150); //bleu 
			this.backgroundColor = Color.WHITE;
			currentSetOfColor = 0;
		}
		// on met e jour toutes les menus avec ce nouveau jeu de couleurs
		for (DevintFrameListener fenetre : openedWinndows) {
			fenetre.changeColor();
		}

	}

	// pour changer la voix en passant e la suivante
	public void changeVoice() {
		if(currentVoice == 7)
			currentVoice = 0;
		else
			currentVoice++;
		this.voix.setVoix(currentVoice);
	}

	// la couleur de devant
	public Color getCurrentForegroundColor() {
		return this.foregroundColor;
	}

	// la couleur de fond
	public Color getCurrentBackgroundColor() {
		return this.backgroundColor;
	}
	
	// pour ajouter une fenetre e la liste des fenetres dont on peut fixer les preferences
	public void addDevintFrame(DevintFrameListener frame) {
		if (!openedWinndows.contains(frame))
			this.openedWinndows.add(frame);
	}

	// la voix
	public SIVOXDevint getVoice() {
		return voix;
	}


}
