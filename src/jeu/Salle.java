package jeu;

import javax.swing.*;
import javax.swing.border.LineBorder;

import devintAPI.FenetreAbstraite;
import devintAPI.Preferences;
import enigme.Enigme;

import java.awt.*;
import java.awt.event.*;

/** Cette classe est un exemple d'interface de jeu.
 *  Elle etend DevintFrame pour avoir un Frame et reagir aux evenements claviers
 * Implemente ActionListener pour reagir au clic souris sur le bouton.
 * On surchage la methode "keyPressed" pour associer une action e la touche F3
 * 
 * @author helene
 *
 */

public class Salle extends FenetreAbstraite implements ActionListener{

	private Enigme enigmeA, enigmeB, enigmeC, enigmeD;
	private boolean unlockA, unlockB, unlockC, unlockD;
	
	// le bouton pour la question
	// est une variable d'instance car il doit etre accessible 
	// dans la methode actionPerformed 
	private JButton question;
	
	// un label
	// est une variable d'instance car il doit etre accessible 
	// dans la methode changeColor, qui gere les preferences
	private JTextArea lb1;
	
	// appel au constructeur de la classe mere
    public Salle(String title) {
    	/*
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * Instancier les 4 enigmes en dur ici.
    	 * 
    	 * -> Le resultat de l'enigme doit etre transmis dans cette classe aussi
    	 * 
    	 * Dans cette salle il faut faire : les 4 boutons d'acces aux enigmes, et un bouton central qui soit
    	 * -> Dans un premier temps lance les sons des enigmes si c'est accessible 
    	 * -> Dans un deuxieme temps, si on a le temps, un synthetiseur vers un son (necessitera une liste de chemins audio pour chaque synthe)
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 * 
    	 */
    	// unlockA = unlockB = unlockC = unlockD = false; // Aucune enigme accomplie
		//enigmeA = new Enigme(/*chemin vers le son e jouer*/ ,/* les 3 choix*/, /* Le numero de la bonne reponse*/);
		//enigmeB = new Enigme(/*chemin vers le son e jouer*/ ,/* les 3 choix*/, /* Le numero de la bonne reponse*/);
		//enigmeC = new Enigme(/*chemin vers le son e jouer*/ ,/* les 3 choix*/, /* Le numero de la bonne reponse*/);
		//enigmeD = new Enigme(/*chemin vers le son e jouer*/ ,/* les 3 choix*/, /* Le numero de la bonne reponse*/);
		
    	super(title);
     }
    
	// renvoie le fichier wave contenant le message d'accueil
	protected  String wavAccueil() {
		return "../ressources/sons/accueil.wav";
	}
	
	// renvoie le fichier wave contenant la regle du jeu
	protected  String wavRegleJeu() {
		return "../ressources/sons/aideF1.wav";
	}
	
	// renvoie le fichier wave contenant la regle du jeu
	protected  String wavAide() {
		return "../ressources/sons/aide.wav";
	}

    // definition de la methode abstraite "init()"
    // initialise le frame 
    protected void init() {
    	// BorderLayout, voir http://java.sun.com/docs/books/tutorial/uiswing/layout/border.html
    	setLayout(new BorderLayout());
 
    	// premier label
    	// ce label est gere par les preferences (cf methode changeColor)
    	String text = "L'interface de votre jeu est totalement libre mais vous devez suivre ";
    	text += "les conventions d'utilisation des touches.\n";
    	text += "En heritant de \"FenetreAbstraite\", la touche ESC vous permez de sortir,\n"; 
    	text += "la touche F1 d'ecouter la regle du jeu et la touche F2 d'ecouter l'aide\n.";
    	text += "La touche F3 permet de changer le jeu de couleurs, et la touche F4 la voix";
    	text+= "de la synthese vocale\n";
    	text+= "\nESSAYEZ DE TAPER F1 puis F3\n";
    	text += "\nOn a utilise un BorderLayout pour placer les elements. Ce texte est au nord.";
     	lb1 = new JTextArea (text); 
    	lb1.setLineWrap(true);
    	lb1.setEditable(false);
    	lb1.setFont(new Font("Georgia",1,30));
    	// on recupere les couleurs de base dans la classe Preferences 
		Preferences pref = Preferences.getData();
		Color foregroundColor = pref.getCurrentForegroundColor();
		Color backgroundColor = pref.getCurrentBackgroundColor();
		lb1.setBackground(backgroundColor);
		lb1.setForeground(foregroundColor);
    	
    	// on place le premier composant en haut
    	this.add(lb1,BorderLayout.NORTH);

    	// deuxieme label, qui n'est pas gere par les preferences
       	text = "C'est rigolo les jeux DeViNT";
       	text += "\nIci c'est un JLabel avec un bord gris.\n";
       	text += "Il est place au centre.";
       	text += "\n\nExemple d'utilisation d'une touche : essayez de taper F5";
    	JTextArea lb2 = new JTextArea (text);
    	lb2.setLineWrap(true);
    	lb2.setEditable(false);
    	lb2.setFont(new Font("Georgia",1,30));
    	// on met un contour gris fonce
       	lb2.setBorder(new LineBorder(Color.GRAY,5));
       	// on met un fond noir
    	lb2.setBackground(Color.BLACK);
    	// le composant doit etre opaque pour qu'on voit le fond
       	lb2.setOpaque(true);
    	// on ecrit en blanc
       	lb2.setForeground(Color.WHITE);  	
       	// on place ce composant au centre
       	this.add(lb2,BorderLayout.CENTER);

    	// bouton pour poser une question
    	question = new JButton();
    	question.setText("Cliquez sur ce bouton pour ecouter la question");
    	question.setBackground(new Color(50,50,255));
    	question.setBorder(new LineBorder(Color.BLACK,10));
     	question.setFont(new Font("Georgia",1,40));
     	// c'est l'objet Jeu lui-meme qui reagit au clic souris
       	question.addActionListener(this);
    	// on met le bouton e droite
     	this.add(question,BorderLayout.EAST);
   }

    // lire la question si clic sur le bouton 
    public void actionPerformed(ActionEvent ae){
       	// toujours stopper la voix avant de parler
    	
    	/*
    	 * 
    	 * 
    	 * 
    	 * LANCER ENIGMEFRAME avec en parametre l'enigme e jouer.
    	 * 
    	 * 
    	 * 
    	 */
    	voix.stop();
    	// on recupere la source de l'evenement
     	Object source = ae.getSource();
     	// si c'est le bouton "question" on lit la question
     	// le contenu des questions est variable donc on les lit avec SI_VOX
    	if (source.equals(question)) {
    		String text = "les questions sont longues et ont un contenu variable.";
    		text += "Il ne faut pas generer un fichier wave mais lire directement les textes";
    		voix.playText(text);
    	}	
    	// on redonne le focus au JFrame principal 
    	// (apres un clic, le focus est sur le bouton)
    	this.requestFocus();
    }
 
    // evenements clavier
    public void keyPressed(KeyEvent e) {
    	// appel e la methode mere qui gere les evenements ESC, F1, F3, F4
    	super.keyPressed(e);
    	// cas particulier pour ce jeu : la touche F5
    	if (e.getKeyCode()==KeyEvent.VK_F5){
    	   	voix.playText("Vous venez d'appuyer sur EFFE 5");
    	}
    }
    
	/**
	 * Pour modifier les couleurs de fond et de premier plan de la fenetre
	 * Cette fonction est appelee par la fonction "changeColor" de la classe "Preferences"
	 * e chaque fois que l'on presse F3 
	 * 
	 * on change la couleur du texte principal
	 **/
	public  void changeColor() {
    	// on recupere les couleurs de base dans la classe Preferences 
		Preferences pref = Preferences.getData();
		lb1.setBackground(pref.getCurrentBackgroundColor());
		lb1.setForeground(pref.getCurrentForegroundColor());
	}

}
