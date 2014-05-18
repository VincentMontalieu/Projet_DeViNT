package enigme;

import java.awt.event.MouseEvent;

import instruments.InstrumentSelectorFrame;

public class EnigmeInstru extends EnigmeAbstractFrame {

    private int bonneReponse;
    private boolean ajouterPoint;
    private String title;
    private String question;
    private String cheminSonQuestion;
    private int nbReponses;
    private String[] reponses;
    private int points;
    private int numeroQuestion;

    public EnigmeInstru(ContenuEnigme e, int points, int numeroQuestion) {
        super((e.getTitle() + numeroQuestion), e.getQuestion(), e
                .getCheminSonQuestion(), e.getNbReponses(), e.getReponses());
        title = e.getTitle();
        question = e.getQuestion();
        cheminSonQuestion = e.getCheminSonQuestion();
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

    public String getCheminSonQuestion() {
        return cheminSonQuestion;
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
        if (EnigmeInstruManager.isProchaineEnigmeNotNull()) {
            numeroQuestion++;
            if (ajouterPoint)
                new EnigmeInstru(EnigmeInstruManager.prochaineEnigme(), points + 1,
                        numeroQuestion);
            else
                new EnigmeInstru(EnigmeInstruManager.prochaineEnigme(), points,
                        numeroQuestion);
            dispose();
        }

        else if (ajouterPoint) {
            new InstrumentSelectorFrame(points + 1,
                    EnigmeInstruManager.nbEnigmesTotales);
            dispose();
        }

        else {
            new InstrumentSelectorFrame(points, EnigmeInstruManager.nbEnigmesTotales);
            dispose();
        }
    }

    @Override
    public void changeColor() {
        // TODO Auto-generated method stub
        
    }
}
