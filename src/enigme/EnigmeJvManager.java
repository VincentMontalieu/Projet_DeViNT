package enigme;

import java.util.ArrayList;

public class EnigmeJvManager {
    private static ArrayList<ContenuEnigme> listeDesEnigmes;
    private static int nbEnigmesRestantes;
    protected static int nbEnigmesTotales;
    private static final String chemin = "../ressources/sons/instruments/questions/jv/";

    public static void creerEnigmes() {
        listeDesEnigmes = new ArrayList<ContenuEnigme>();

        // Enigme #1
        String reponses[] = { "Angry Birds", "Dragon Ball Z", "Mario",
                "Pac-Man" };
        listeDesEnigmes.add(new ContenuEnigme(
                "De quel jeu-vidéo est tirée cette musique ?", chemin + "1/",
                4, reponses, 1));

        // Enigme #2
        String reponses2[] = { "Angry Birds", "Dragon Ball Z", "Mario",
                "Pac-Man" };
        listeDesEnigmes.add(new ContenuEnigme(
                "De quel jeu-vidéo est tirée cette musique ?", chemin + "2/",
                4, reponses2, 2));

        // Enigme #3
        String reponses3[] = { "Angry Birds", "Dragon Ball Z", "Mario",
                "Pac-Man" };
        listeDesEnigmes.add(new ContenuEnigme(
                "De quel jeu-vidéo est tirée cette musique ?", chemin + "3/",
                4, reponses3, 3));

        // Enigme #4
        String reponses4[] = { "Angry Birds", "Dragon Ball Z", "Mario",
                "Pac-Man" };
        listeDesEnigmes.add(new ContenuEnigme(
                "De quel jeu-vidéo est tirée cette musique ?", chemin + "4/",
                4, reponses4, 4));

        // Enigme #5
        String reponses5[] = { "Pokémon", "Dragon Ball Z", "Mario", "Pac-Man" };
        listeDesEnigmes.add(new ContenuEnigme(
                "De quel jeu-vidéo est tirée cette musique ?", chemin + "5/",
                4, reponses5, 1));

        // Enigme #6
        String reponses6[] = { "Angry Birds", "Tetris", "Mario", "Pac-Man" };
        listeDesEnigmes.add(new ContenuEnigme(
                "De quel jeu-vidéo est tirée cette musique ?", chemin + "6/",
                4, reponses6, 2));

        // Enigme #7
        String reponses7[] = { "Angry Birds", "Dragon Ball Z",
                "La Légende de Zelda", "Pac-Man" };
        listeDesEnigmes.add(new ContenuEnigme(
                "De quel jeu-vidéo est tirée cette musique ?", chemin + "7/",
                4, reponses7, 3));

        nbEnigmesRestantes = listeDesEnigmes.size();
        nbEnigmesTotales = nbEnigmesRestantes;
    }

    protected static boolean isProchaineEnigmeNotNull() {
        if (nbEnigmesRestantes > 0)
            return true;

        else
            return false;
    }

    public static ContenuEnigme prochaineEnigme() {
        int index = (int) (Math.random() * (nbEnigmesRestantes));
        nbEnigmesRestantes--;
        ContenuEnigme e = listeDesEnigmes.get(index);
        listeDesEnigmes.remove(index);
        return e;
    }
}
