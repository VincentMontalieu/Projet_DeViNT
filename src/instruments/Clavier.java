package instruments;

@SuppressWarnings("serial")
public class Clavier extends ClavierFrame {

    private static String[] instruments = { "une basse", "une guitare",
            "une trompette", "un piano", "une batterie" };
    private static final String debutChemin = "../ressources/sons/instruments/clavier/";
    private static String[] cheminsInstruments = { debutChemin + "basse/",
            debutChemin + "guitare/", debutChemin + "trompette/",
            debutChemin + "piano/", debutChemin + "batterie/" };

    public Clavier(int choix, int points, int questions) {
        super("Tu as choisi " + instruments[choix] + " !",
                cheminsInstruments[choix], points, questions, choix);
        // TODO Auto-generated constructor stub
    }
}
