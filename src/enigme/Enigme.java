package enigme;

import instruments.InstrumentSelectorFrame;

public class Enigme extends EnigmeAbstractFrame {

    private int bonneReponse;
    private boolean ajouterPoint;
    private String title;
    private String question;
    private String[] cheminsFichiersSon;
    private int nbReponses;
    private String[] reponses;
    private int points;
    private int numeroQuestion;

    public Enigme(ContenuEnigme e, int points, int numeroQuestion) {
        super((e.getTitle() + numeroQuestion), e.getQuestion(), e
                .getCheminsFichiersSon(), e.getNbReponses(), e.getReponses());
        title = e.getTitle();
        question = e.getQuestion();
        cheminsFichiersSon = e.getCheminsFichiersSon();
        nbReponses = e.getNbReponses();
        reponses = e.getReponses();
        ajouterPoint = false;
        this.numeroQuestion = numeroQuestion;
        bonneReponse = e.getBonneReponse();
        this.points = points;
    }

    @Override
    protected void reponseJoueur(int reponseChoisie) {
        if (bonneReponse == reponseChoisie) {
            ajouterPoint = true;
            voix.playWav("../ressources/sons/right.wav");
        } else {
            voix.playWav("../ressources/sons/wrong.wav");
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getBonneReponse() {
        return bonneReponse;
    }

    public boolean getAjouterPoint() {
        return ajouterPoint;
    }

    public String getTitle() {
        return title;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getCheminsFichiersSon() {
        return cheminsFichiersSon;
    }

    public int getNbReponses() {
        return nbReponses;
    }

    public String[] getReponses() {
        return reponses;
    }

    public int getPoints() {
        return points;
    }

    @Override
    protected void lancerEnigmeSuivante() {
        if (EnigmeManager.isProchaineEnigmeNotNull()) {
            numeroQuestion++;
            if (ajouterPoint)
                new Enigme(EnigmeManager.prochaineEnigme(), points + 1,
                        numeroQuestion);
            else
                new Enigme(EnigmeManager.prochaineEnigme(), points,
                        numeroQuestion);
            dispose();
        }

        else if (ajouterPoint) {
            new InstrumentSelectorFrame(points + 1,
                    EnigmeManager.nbEnigmesTotales);
            dispose();
        }

        else {
            new InstrumentSelectorFrame(points, EnigmeManager.nbEnigmesTotales);
            dispose();
        }
    }
}
