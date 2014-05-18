/*  Classe de menu de lancement de l'exemple de jeu.
 *  Cette classe herite de la classe abstraite MenuAbstrait en definissant les methodes :
 *     - nomOptions qui renvoie la liste des options possibles pour le menu 
 *     - lancerOption qui associe une action e chaque option du menu
 *     - wavAccueil() qui renvoie le nom du fichier wav lu lors de l'accueil dans le menu
 *     - wavAide() qui renvoie le nom du fichier wav lu lors de l'activation de la touche F1
 */

package jeu;

import instruments.InstrumentSelectorFrame;
import devintAPI.MenuAbstrait;

public class MenuClavier extends MenuAbstrait {

    /**
     * constructeur
     * 
     * @param title
     *            : le nom du jeu
     */
    public MenuClavier(String title) {
        super(title);
    }

    /**
     * renvoie le nom des options du menu vous pouvez definir autant d'options
     * que vous voulez
     **/
    protected String[] nomOptions() {
        String[] noms = { "Aucun", "Basse", "Guitare", "Trompette", "Piano",
                "Batterie" };
        return noms;
    }

    /**
     * lance l'action associee au bouton nei la numerotation est celle du
     * tableau renvoye par nomOption
     */
    protected void lancerOption(int i) {
        switch (i) {
        case 0:
            new InstrumentSelectorFrame(0, 5);
            break;
        case 1:
            new InstrumentSelectorFrame(1, 5);
            break;
        case 2:
            new InstrumentSelectorFrame(2, 5);
            break;
        case 3:
            new InstrumentSelectorFrame(3, 5);
            break;
        case 4:
            new InstrumentSelectorFrame(4, 5);
            break;
        case 5:
            new InstrumentSelectorFrame(5, 5);
            break;
        default:
            System.err.println("action non definie");
        }
    }

    // renvoie le fichier wave contenant le message d'accueil
    // ces fichiers doivent etre places dans ressources/sons/
    protected String wavAccueil() {
        return null;
    }

    // renvoie le fichier wave contenant la regle du jeu
    protected String wavRegleJeu() {
        return null;
    }

    @Override
    protected String cheminOptions() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String wavAide() {
        // TODO Auto-generated method stub
        return null;
    }
}
