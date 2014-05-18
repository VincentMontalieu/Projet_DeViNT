/*  Classe de menu de lancement de l'exemple de jeu.
 *  Cette classe herite de la classe abstraite MenuAbstrait en definissant les methodes :
 *     - nomOptions qui renvoie la liste des options possibles pour le menu 
 *     - lancerOption qui associe une action e chaque option du menu
 *     - wavAccueil() qui renvoie le nom du fichier wav lu lors de l'accueil dans le menu
 *     - wavAide() qui renvoie le nom du fichier wav lu lors de l'activation de la touche F1
 */

package jeu;

import devintAPI.MenuAbstrait;
import enigme.EnigmeFilms;
import enigme.EnigmeFilmsManager;
import enigme.EnigmeInstru;
import enigme.EnigmeInstruManager;
import enigme.EnigmeJv;
import enigme.EnigmeJvManager;
import enigme.EnigmeMelodies;
import enigme.EnigmeMelodiesManager;

public class MenuThemes extends MenuAbstrait {

    /**
     * constructeur
     * 
     * @param title
     *            : le nom du jeu
     */
    public MenuThemes(String title) {
        super(title);
    }

    /**
     * renvoie le nom des options du menu vous pouvez definir autant d'options
     * que vous voulez
     **/
    protected String[] nomOptions() {
        String[] noms = { "Instruments de musique", "Musiques de films",
                "Mélodies célèbres", "Les jeux vidéos" };
        return noms;
    }

    /**
     * lance l'action associee au bouton nei la numerotation est celle du
     * tableau renvoye par nomOption
     */
    protected void lancerOption(int i) {
        switch (i) {
        case 0:
            EnigmeInstruManager.creerEnigmes();
            new EnigmeInstru(EnigmeInstruManager.prochaineEnigme(), 0, 1);
            break;
        case 1:
            EnigmeFilmsManager.creerEnigmes();
            new EnigmeFilms(EnigmeFilmsManager.prochaineEnigme(), 0, 1);
            break;
        case 2:
            EnigmeMelodiesManager.creerEnigmes();
            new EnigmeMelodies(EnigmeMelodiesManager.prochaineEnigme(), 0, 1);
            break;
        case 3:
            EnigmeJvManager.creerEnigmes();
            new EnigmeJv(EnigmeJvManager.prochaineEnigme(), 0, 1);
            break;
        default:
            System.err.println("action non definie");
        }
    }

    // renvoie le fichier wave contenant le message d'accueil
    // ces fichiers doivent etre places dans ressources/sons/
    protected String wavAccueil() {
        return "../ressources/sons/Menus/Theme/ChoisisUnTheme.wav";
    }

    // renvoie le fichier wave contenant la regle du jeu
    protected String wavRegleJeu() {
        return null;
    }

    @Override
    protected String cheminOptions() {
        return "../ressources/sons/Menus/Theme/";
    }

    @Override
    protected String wavAide() {
        return "../ressources/sons/Aide/PourObtenirDeLAide.wav";
    }

}
