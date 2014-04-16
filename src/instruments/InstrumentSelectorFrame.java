package instruments;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import devintAPI.FenetreAbstraite;

@SuppressWarnings("serial")
public class InstrumentSelectorFrame extends FenetreAbstraite implements
        ActionListener {

    // L'intitule de la fenêtre
    private static final String title = "Choix d'un instrument";

    // L'intitule de l'en-tête
    private String texte;

    // L'intitule de l'score
    private String score;

    // L'instrument max dispo
    private int choix, points, questions;

    // Un tableau contenant les boutons associes aux instruments
    private JButton[] boutonsInstruments;

    // Le nombre total d'instruments
    private int nbInstruments;

    // Un tableau contenant les instruments
    private static final String[] instruments = { "Flûte", "Guitare",
            "Trompette", "Piano", "Synthétiseur" };

    // Un tableau contenant les instruments disponibles
    private boolean[] instrumentsDisponibles;

    // Les JLabel qui vont contenir les textes
    private JLabel labelTexte, labelScore;

    // Le JPanel qui va contenir les boutons de instruments
    private JPanel instrumentsPanel;

    // Le JPannel de base qui va contenir tout le reste
    private JPanel content;

    // Les JPannel qui vont contenir les JLabel de texte
    private JPanel textePanel, scorePanel;

    public InstrumentSelectorFrame(int points, int questions) {
        super(title);
        this.choix = instrumentSelector(points, questions);
        this.score = "SCORE : " + points + "/" + questions;
        this.nbInstruments = instruments.length;
        this.points = points;

        switch (choix) {
        case -1:
            this.texte = "<html>Tu n'as débloqué aucun instrument... :( "
                    + "<br>Recommences le quiz et essaye d'avoir au moins une bonne réponse :)<html>";
            break;
        case 0:
            this.texte = "<html>Tu as débloqué 1 instrument !<br>Clique dessus et amuse-toi avec !<html>";
            break;
        default:
            this.texte = "<html>Tu as débloqué "
                    + (choix + 1)
                    + " instruments !<br>Choisis ton préféré et amuse-toi avec !<html>";
            break;
        }
        this.questions = questions;
        this.instrumentsDisponibles = new boolean[nbInstruments];

        for (int i = 0; i <= choix; i++) {
            this.instrumentsDisponibles[i] = true;
        }

        for (int i = choix + 1; i < nbInstruments; i++) {
            this.instrumentsDisponibles[i] = false;
        }

        this.boutonsInstruments = new JButton[nbInstruments];
        init();
    }

    @Override
    protected void init() {
        // Conteneur principal
        content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BorderLayout());

        // Definition du panel contenant le label texte
        textePanel = new JPanel();
        textePanel.setOpaque(false);
        textePanel.setLayout(new BorderLayout());

        // Definition du label contenant la texte
        labelTexte = new JLabel(texte);
        labelTexte.setOpaque(false);
        labelTexte.setFont(new Font("Verdana", 1, 40));
        textePanel.add(labelTexte, BorderLayout.CENTER);
        content.add(textePanel, BorderLayout.NORTH);

        // Definition du panel contenant le label score
        scorePanel = new JPanel();
        scorePanel.setOpaque(false);
        scorePanel.setLayout(new BorderLayout());

        // Definition du label contenant l'score
        labelScore = new JLabel(score);
        labelScore.setOpaque(false);
        labelScore.setFont(new Font("Verdana", 1, 40));
        scorePanel.add(labelScore, BorderLayout.CENTER);
        content.add(scorePanel, BorderLayout.SOUTH);

        // Definition du panel contenant les boutons instruments
        instrumentsPanel = new JPanel();
        instrumentsPanel.setOpaque(false);
        instrumentsPanel.setLayout(new GridLayout(nbInstruments, 2, 0, 20));
        creerinstruments(instruments);
        content.add(instrumentsPanel, BorderLayout.CENTER);

        setContentPane(content);
        setVisible(true);

        // Bordures et couleur de la zone texte
        setEmptyBorder(labelTexte, 10, 20, 10, 10);
        // setMatteBorder(textePanel, 0, 0, 1, 0, Color.BLACK);
        setComponentBackground(labelTexte, Color.PINK);
        setComponentForeground(labelTexte, Color.GRAY);
        // Pour redimensionner la zone de texte
        // textePanel.setPreferredSize(new Dimension(getScreenWidth(), 100));

        // Bordures et couleur de la zone instruments
        setEmptyBorder(instrumentsPanel, 10, 100, 10, 100);
        setComponentBackground(instrumentsPanel, Color.PINK);

        // Bordures et couleur de la zone score
        setEmptyBorder(labelScore, 10, 20, 10, 10);
        // setMatteBorder(scorePanel, 1, 0, 0, 0, Color.BLACK);
        setComponentBackground(labelScore, Color.PINK);
        setComponentForeground(labelScore, Color.GRAY);
        // Pour redimensionner la zone de texte
        // textePanel.setPreferredSize(new Dimension(getScreenWidth(), 50));

    }

    public static void setComponentBackground(JComponent obj, Color c) {
        obj.setOpaque(true);
        obj.setBackground(c);
    }

    public static void setComponentForeground(JComponent obj, Color c) {
        obj.setOpaque(true);
        obj.setForeground(c);
    }

    public static void setEmptyBorder(JComponent obj, int top, int left,
            int bottom, int right) {
        obj.setBorder(new EmptyBorder(top, left, bottom, right));
    }

    public void setMatteBorder(JComponent obj, int top, int left, int bottom,
            int right, Color c) {
        obj.setBorder(BorderFactory.createMatteBorder(top, left, bottom, right,
                c));
    }

    public static int getScreenWidth() {
        return Toolkit.getDefaultToolkit().getScreenSize().width;
    }

    public static int getScreenHeight() {
        return Toolkit.getDefaultToolkit().getScreenSize().height;
    }

    private void creerinstruments(String[] noms) {
        for (int i = 0; i <= choix; i++) {
            creerBouton(i, noms[i]);
            setPropertiesButtonTrue(boutonsInstruments[i]);
            instrumentsPanel.add(boutonsInstruments[i]);
        }

        for (int i = choix + 1; i < nbInstruments; i++) {
            creerBouton(i, noms[i]);
            setPropertiesButtonFalse(boutonsInstruments[i]);
            instrumentsPanel.add(boutonsInstruments[i]);
        }
    }

    private void creerBouton(int i, String texte) {
        boutonsInstruments[i] = new JButton();
        boutonsInstruments[i].setText(texte);
    }

    // mettre a jour les proprietes des boutons
    protected void setPropertiesButtonFalse(JButton b) {
        b.setFocusable(false);
        b.setFont(new Font("Verdana", 1, 60));
        setComponentBackground(b, Color.RED);
        b.setEnabled(false);
    }

    // mettre a jour les proprietes des boutons
    protected void setPropertiesButtonTrue(JButton b) {
        b.setFocusable(false);
        b.addActionListener(this);
        b.setFont(new Font("Verdana", 1, 60));
        setComponentBackground(b, Color.GREEN);
        setComponentForeground(b, Color.BLACK);
    }

    @Override
    protected String wavAide() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void changeColor() {
        // TODO Auto-generated method stub

    }

    @Override
    protected String wavAccueil() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String wavRegleJeu() {
        // TODO Auto-generated method stub
        return null;
    }

    private int instrumentSelector(int points, int questions) {
        int m = instruments.length;
        int pos = (questions + 1) / m;
        int instrument = 0;

        for (int i = 0; i <= questions + 1; i = i + pos) {
            if (i <= points && points <= i + pos)
                break;
            else
                instrument++;
        }
        if (points != 0) {
            return instrument;
        } else {
            return -1;
        }
    }

    public void actionPerformed(ActionEvent ae) {
        voix.stop();
        Object source = ae.getSource();

        for (int i = 0; i <= choix; i++) {
            if (source == this.boutonsInstruments[i]) {
                new Clavier(i, points, questions);
            }
        }
    }
}