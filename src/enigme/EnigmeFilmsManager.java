package enigme;

import java.util.ArrayList;

public class EnigmeFilmsManager {
    private static ArrayList<ContenuEnigme> listeDesEnigmes;
    private static int nbEnigmesRestantes;
    protected static int nbEnigmesTotales;
    private static final String chemin = "../ressources/sons/instruments/questions/films/";

    public static void creerEnigmes() {
        listeDesEnigmes = new ArrayList<ContenuEnigme>();

        // Enigme #1
        String reponses[] = { "Retour vers le Futur", "Harry Potter",
                "Indiana Jones", "Pirates des Caraïbes" };
        listeDesEnigmes.add(new ContenuEnigme(
                "De quel film est tirée cette musique ?", chemin + "1/", 4,
                reponses, 1));

        // Enigme #2
        String reponses2[] = { "Retour vers le Futur", "Harry Potter",
                "Indiana Jones", "Pirates des Caraïbes" };
        listeDesEnigmes.add(new ContenuEnigme(
                "De quel film est tirée cette musique ?", chemin + "2/", 4,
                reponses2, 2));

        // Enigme #3
        String reponses3[] = { "Retour vers le Futur", "Harry Potter",
                "Indiana Jones", "Pirates des Caraïbes" };
        listeDesEnigmes.add(new ContenuEnigme(
                "De quel film est tirée cette musique ?", chemin + "3/", 4,
                reponses3, 3));

        // Enigme #4
        String reponses4[] = { "Retour vers le Futur", "Harry Potter",
                "Indiana Jones", "Pirates des Caraïbes" };
        listeDesEnigmes.add(new ContenuEnigme(
                "De quel film est tirée cette musique ?", chemin + "4/", 4,
                reponses4, 4));

        // Enigme #5
        String reponses5[] = { "Retour vers le Futur",
                "Le Seigneur des Anneaux", "Indiana Jones",
                "Pirates des Caraïbes" };
        listeDesEnigmes.add(new ContenuEnigme(
                "De quel film est tirée cette musique ?", chemin + "5/", 4,
                reponses5, 2));

        // Enigme #6
        String reponses6[] = { "Retour vers le Futur", "Harry Potter",
                "Indiana Jones", "Star Wars" };
        listeDesEnigmes.add(new ContenuEnigme(
                "De quel film est tirée cette musique ?", chemin + "6/", 4,
                reponses6, 4));

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
