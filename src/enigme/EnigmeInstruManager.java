package enigme;

import java.util.ArrayList;

public class EnigmeInstruManager {
    private static ArrayList<ContenuEnigme> listeDesEnigmes;
    private static int nbEnigmesRestantes;
    protected static int nbEnigmesTotales;
    private static final String chemin = "../ressources/sons/instruments/questions/instruments/";

    public static void creerEnigmes() {
        listeDesEnigmes = new ArrayList<ContenuEnigme>();

        // Enigme #1
        String reponses[] = { "Banjo", "Guitare", "Violon", "Piano" };
        listeDesEnigmes.add(new ContenuEnigme("Quel est cet instrument ?",
                chemin + "1/", 4, reponses, 1));

        // Enigme #2
        String reponses2[] = { "Le premier", "Le deuxième", "Le troisième" };
        listeDesEnigmes.add(new ContenuEnigme(
                "Quel piano joue un air de salsa ?", chemin + "2/", 3,
                reponses2, 2));

        // Enigme #3
        String reponses3[] = { "Clarinette", "Hautbois", "Basson", "Tuba" };
        listeDesEnigmes.add(new ContenuEnigme("Quel est cet instrument ?",
                chemin + "3/", 4, reponses3, 1));

        // Enigme #4
        String reponses4[] = { "Le premier", "Le deuxième", "Le troisième",
                "Le quatrième" };
        listeDesEnigmes.add(new ContenuEnigme(
                "Quel instrument est la mandoline ?", chemin + "4/", 4,
                reponses4, 3));

        // Enigme #5
        String reponses5[] = { "1", "2", "3", "4" };
        listeDesEnigmes.add(new ContenuEnigme(
                "Combien entendez-vous d'instruments à cordes ?",
                chemin + "5/", 4, reponses5, 2));

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
