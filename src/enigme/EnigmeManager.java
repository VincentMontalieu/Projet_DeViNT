package enigme;

import java.util.ArrayList;

public class EnigmeManager {
    private static ArrayList<ContenuEnigme> listeDesEnigmes;
    private static int nbEnigmesRestantes;
    protected static int nbEnigmesTotales;
    private static final String chemin = "../ressources/sons/instruments/questions/";

    public static void creerEnigmes() {
        listeDesEnigmes = new ArrayList<ContenuEnigme>();

        // Enigme #1
        String reponses[] = { "Banjo", "Guitare", "Violon", "Piano" };
        String chemins[] = { chemin + "banjo.wav" };
        listeDesEnigmes.add(new ContenuEnigme("Quel est cet instrument ?",
                chemins, 4, reponses, 1));

        // Enigme #2
        String reponses2[] = { "Le premier", "Le deuxième", "Le troisième" };
        String chemins2[] = { chemin + "piano blues.wav",
                chemin + "piano salsa.wav", chemin + "piano jazz.wav" };
        listeDesEnigmes
                .add(new ContenuEnigme("Quel piano joue un air de salsa ?",
                        chemins2, 3, reponses2, 2));

        // Enigme #3
        String reponses3[] = { "Clarinette", "Hautbois", "Basson", "Tuba" };
        String chemins3[] = { chemin + "clarinette.wav" };
        listeDesEnigmes.add(new ContenuEnigme("Quel est cet instrument ?",
                chemins3, 4, reponses3, 1));

        // Enigme #4
        String reponses4[] = { "Le premier", "Le deuxieme", "Le troisieme",
                "Le quatrieme" };
        String chemins4[] = { chemin + "guitare acoustique.wav",
                chemin + "ukulele.wav", chemin + "mandoline.wav",
                chemin + "guitare électrique.wav" };
        listeDesEnigmes
                .add(new ContenuEnigme("Quel instrument est la mandoline ?",
                        chemins4, 4, reponses4, 3));

        // Enigme #5
        String reponses5[] = { "1", "2", "3", "4" };
        String chemins5[] = { chemin + "contrebasse.wav",
                chemin + "violoncelle.wav", chemin + "orgue hammond.wav",
                chemin + "hautbois.wav" };
        listeDesEnigmes.add(new ContenuEnigme(
                "Combien entendez-vous d'instruments à cordes ?", chemins5, 4,
                reponses5, 2));

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
