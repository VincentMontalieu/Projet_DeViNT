package instruments;

import image.ImageLoader;
import image.ImagePanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import devintAPI.FenetreAbstraite;
import enigme.EnigmeAbstractFrame;

@SuppressWarnings("serial")
public abstract class ClavierFrame extends FenetreAbstraite implements
        KeyListener {

    // Un String contenant le chemin vers le dossier contenant les sons
    private String cheminFichiersInstrument;

    // Le JPannel de base qui va contenir tout le reste
    private JPanel content;

    // Les JLabel qui vont contenir les textes
    private JLabel labelTexte, labelScore;

    // Les JPannel qui vont contenir les JLabel de texte
    private JPanel textePanel, scorePanel, imagePanel;

    // Le JPannel qui va contenir le clavier virtuel
    private ClavierPanel clavier;

    private String title, chemin;

    private int points, questions, instru;

    public ClavierFrame(String title, String chemin, int points, int questions,
            int instru) {
        super(title);
        this.title = title;
        this.chemin = chemin;
        cheminFichiersInstrument = chemin;
        addKeyListener(this);
        this.points = points;
        this.questions = questions;
        this.instru = instru + 1;
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

        // Definition du label contenant le texte
        labelTexte = new JLabel(title);
        labelTexte.setOpaque(false);
        labelTexte.setFont(new Font("Verdana", 1, 40));
        textePanel.add(labelTexte, BorderLayout.CENTER);
        content.add(textePanel, BorderLayout.NORTH);

        // Definition du panel contenant le label score
        scorePanel = new JPanel();
        scorePanel.setOpaque(false);
        scorePanel.setLayout(new GridLayout(2, 1));

        // Panel image
        imagePanel = new ImagePanel(
                ImageLoader.getImage("../ressources/images/" + instru + ".gif"),
                0, 0);
        imagePanel.setOpaque(false);

        // Definition du label contenant le score
        labelScore = new JLabel("SCORE : " + points + "/" + questions);
        labelScore.setOpaque(false);
        labelScore.setFont(new Font("Verdana", 1, 30));
        scorePanel.add(imagePanel);
        scorePanel.add(labelScore);
        scorePanel.setPreferredSize(new Dimension(400, 0));
        content.add(scorePanel, BorderLayout.WEST);

        // Dessin du clavier
        clavier = new ClavierPanel();

        // Ajouts
        content.add(clavier, BorderLayout.CENTER);
        add(content);

        // Couleurs et bordures
        EnigmeAbstractFrame.setEmptyBorder(textePanel, 10, 10, 0, 0);
        EnigmeAbstractFrame.setEmptyBorder(scorePanel, 0, 10, 0, 0);
        clavier.setOpaque(false);
        textePanel.setOpaque(false);
        scorePanel.setOpaque(false);
        labelScore.setOpaque(false);
        labelTexte.setOpaque(false);
        content.setOpaque(false);
        EnigmeAbstractFrame.setComponentBackground(content, Color.WHITE);
        EnigmeAbstractFrame.setComponentBackground(scorePanel, Color.WHITE);
        EnigmeAbstractFrame.setComponentBackground(textePanel, Color.WHITE);
        EnigmeAbstractFrame.setComponentBackground(labelScore, Color.WHITE);
        EnigmeAbstractFrame.setComponentBackground(labelTexte, Color.WHITE);
        EnigmeAbstractFrame.setComponentForeground(labelTexte, Color.BLACK);
        EnigmeAbstractFrame.setComponentForeground(labelScore, Color.BLACK);
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

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_S) {
            clavier.do1 = Color.GREEN;
            voix.stop();
            voix.playWav(chemin + "0.wav");
        }

        else if (e.getKeyCode() == KeyEvent.VK_1) {
            voix.stop();
            voix.playWav("../ressources/sons/boule/ouvre.wav");
        }

        else if (e.getKeyCode() == KeyEvent.VK_2) {
            voix.stop();
            voix.playWav("../ressources/sons/boule/ferme.wav");
        }

        else if (e.getKeyCode() == KeyEvent.VK_3) {
            voix.stop();
            voix.playWav("../ressources/sons/boule/boule_magique.wav");
        }

        else if (e.getKeyCode() == KeyEvent.VK_E) {
            clavier.doDiese = Color.GREEN;
            voix.stop();
            voix.playWav(chemin + "1.wav");
        }

        else if (e.getKeyCode() == KeyEvent.VK_D) {
            clavier.re = Color.GREEN;
            voix.stop();
            voix.playWav(chemin + "2.wav");
        }

        else if (e.getKeyCode() == KeyEvent.VK_R) {
            clavier.reDiese = Color.GREEN;
            voix.stop();
            voix.playWav(chemin + "3.wav");
        }

        else if (e.getKeyCode() == KeyEvent.VK_F) {
            clavier.mi = Color.GREEN;
            voix.stop();
            voix.playWav(chemin + "4.wav");
        }

        else if (e.getKeyCode() == KeyEvent.VK_G) {
            clavier.fa = Color.GREEN;
            voix.stop();
            voix.playWav(chemin + "5.wav");
        }

        else if (e.getKeyCode() == KeyEvent.VK_Y) {
            clavier.faDiese = Color.GREEN;
            voix.stop();
            voix.playWav(chemin + "6.wav");
        }

        else if (e.getKeyCode() == KeyEvent.VK_H) {
            clavier.sol = Color.GREEN;
            voix.stop();
            voix.playWav(chemin + "7.wav");
        }

        else if (e.getKeyCode() == KeyEvent.VK_U) {
            clavier.solDiese = Color.GREEN;
            voix.stop();
            voix.playWav(chemin + "8.wav");
        }

        else if (e.getKeyCode() == KeyEvent.VK_J) {
            clavier.la = Color.GREEN;
            voix.stop();
            voix.playWav(chemin + "9.wav");
        }

        else if (e.getKeyCode() == KeyEvent.VK_I) {
            clavier.laDiese = Color.GREEN;
            voix.stop();
            voix.playWav(chemin + "10.wav");
        }

        else if (e.getKeyCode() == KeyEvent.VK_K) {
            clavier.si = Color.GREEN;
            voix.stop();
            voix.playWav(chemin + "11.wav");
        }

        else if (e.getKeyCode() == KeyEvent.VK_L) {
            clavier.do2 = Color.GREEN;
            voix.stop();
            voix.playWav(chemin + "12.wav");
        }

        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            voix.stop();
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_S)
            clavier.do1 = Color.YELLOW;
        else if (e.getKeyCode() == KeyEvent.VK_E)
            clavier.doDiese = Color.RED;
        else if (e.getKeyCode() == KeyEvent.VK_D)
            clavier.re = Color.YELLOW;
        else if (e.getKeyCode() == KeyEvent.VK_R)
            clavier.reDiese = Color.RED;
        else if (e.getKeyCode() == KeyEvent.VK_F)
            clavier.mi = Color.YELLOW;
        else if (e.getKeyCode() == KeyEvent.VK_G)
            clavier.fa = Color.YELLOW;
        else if (e.getKeyCode() == KeyEvent.VK_Y)
            clavier.faDiese = Color.RED;
        else if (e.getKeyCode() == KeyEvent.VK_H)
            clavier.sol = Color.YELLOW;
        else if (e.getKeyCode() == KeyEvent.VK_U)
            clavier.solDiese = Color.RED;
        else if (e.getKeyCode() == KeyEvent.VK_J)
            clavier.la = Color.YELLOW;
        else if (e.getKeyCode() == KeyEvent.VK_I)
            clavier.laDiese = Color.RED;
        else if (e.getKeyCode() == KeyEvent.VK_K)
            clavier.si = Color.YELLOW;
        else if (e.getKeyCode() == KeyEvent.VK_L)
            clavier.do2 = Color.YELLOW;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}