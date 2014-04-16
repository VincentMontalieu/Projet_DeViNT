package instruments;

@SuppressWarnings("serial")
public class Clavier extends ClavierFrame {

    private static String[] instruments = { "une flûte", "une guitare",
            "une trompette", "un piano", "un synthétiseur" };
    private static final String debutChemin = "../ressources/sons/instruments/clavier/";
    private static String[] cheminsInstruments = { debutChemin + "flute/",
            debutChemin + "guitare/", debutChemin + "trompette/",
            debutChemin + "piano/", debutChemin + "synth/" };

    public Clavier(int choix, int points, int questions) {
        super("Tu as choisi " + instruments[choix] + " !",
                cheminsInstruments[choix], points, questions, choix);
        // TODO Auto-generated constructor stub
    }
}
