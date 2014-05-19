 package enigme;

import java.util.ArrayList;

public class EnigmeMelodiesManager {
    private static ArrayList<ContenuEnigme> listeDesEnigmes;
    private static int nbEnigmesRestantes;
    protected static int nbEnigmesTotales;
    private static final String chemin = "../ressources/sons/instruments/questions/melodies/";

    public static void creerEnigmes() {
        listeDesEnigmes = new ArrayList<ContenuEnigme>();

        // Enigme #1
        String reponses[] = { "Alouette", "Au clair de la lune",
                "Vive le vent", "Petit Papa Noël" };
        listeDesEnigmes.add(new ContenuEnigme("Quelle est cette mélodie ?",
                chemin + "1/", 4, reponses, 1));

        // Enigme #2
        String reponses2[] = { "Vive le vent", "Frère Jacques",
                "Petit Papa Noël", "Au clair de la lune" };
        listeDesEnigmes.add(new ContenuEnigme("Quelle est cette mélodie ?",
                chemin + "2/", 4, reponses2, 4));

        // Enigme #3
        String reponses3[] = { "J'ai du bon tabac", "Au clair de la lune",
                "Petit Papa Noël", "Vive le vent" };
        listeDesEnigmes.add(new ContenuEnigme("Quelle est cette mélodie ?",
                chemin + "3/", 4, reponses3, 4));

        // Enigme #4
        String reponses4[] = { "Vive le vent", "Au clair de la lune",
                "Petit Papa Noël", "Frère Jacques" };
        listeDesEnigmes.add(new ContenuEnigme("Quelle est cette mélodie ?",
                chemin + "4/", 4, reponses4, 3));

        // Enigme #5
        String reponses5[] = { "Alouette", "Frère Jacques", "Vive le vent",
                "J'ai du bon tabac" };
        listeDesEnigmes.add(new ContenuEnigme("Quelle est cette mélodie ?",
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
