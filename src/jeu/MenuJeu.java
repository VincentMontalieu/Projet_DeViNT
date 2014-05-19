/*  Classe de menu de lancement de l'exemple de jeu.
 *  Cette classe herite de la classe abstraite MenuAbstrait en definissant les methodes :
 *     - nomOptions qui renvoie la liste des options possibles pour le menu 
 *     - lancerOption qui associe une action e chaque option du menu
 *     - wavAccueil() qui renvoie le nom du fichier wav lu lors de l'accueil dans le menu
 *     - wavAide() qui renvoie le nom du fichier wav lu lors de l'activation de la touche F1
 */

package jeu;

import instruments.Clavier;
import instruments.InstrumentSelectorFrame;
import devintAPI.MenuAbstrait;
import enigme.EnigmeInstru;
import enigme.EnigmeInstruManager;

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
        String[] noms = { "Jouer", "Règles", "Aide", "Quitter" };
        return noms;
    }

    /**
     * lance l'action associee au bouton nei la numerotation est celle du
     * tableau renvoye par nomOption
     */
    protected void lancerOption(int i) {
        switch (i) {
        case 0:
            new MenuThemes("Thèmes disponibles");
            break;
        case 1:
            voix.stop();
            voix.playWav(wavRegleJeu());
            break;
        case 2:
            voix.stop();
            voix.playWav(wavAide());
            break;
        case 3:
            dispose();
            break;
        default:
            System.err.println("action non definie");
            System.out.println(i);
        }
    }

    // renvoie le fichier wave contenant le message d'accueil
    // ces fichiers doivent etre places dans ressources/sons/
    protected String wavAccueil() {
        return "../ressources/sons/Menus/Jeu/BienvenueDansLaBoiteAMusique.wav";
    }

    @Override
    protected String wavAide() {
        return "../ressources/sons/Aide/PourObtenirDeLAide.wav";
    }

    @Override
    protected String wavRegleJeu() {
        return "../ressources/sons/Regles/TuDoisRepondreAUneSerieDeQuestions.wav";
    }

    @Override
    protected String cheminOptions() {
        return "../ressources/sons/Menus/Jeu/";
    }
}
