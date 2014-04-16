package enigme;

import image.ImageLoader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import devintAPI.FenetreAbstraite;

@SuppressWarnings("serial")
public abstract class EnigmeAbstractFrame extends FenetreAbstraite implements
        ActionListener {

    // L'intitule de la fenêtre
    private String title;

    // L'intitule de la question
    private String question;

    // L'intitule de l'aide
    private String aide;

    // Un tableau contenant les chemins vers les differents sons a jouer
    private String[] cheminsFichiersSon;

    // Un tableau contenant les intitules des reponses possibles
    private String[] reponses;

    // Un tableau contenant les boutons associes aux reponses
    private JButton[] boutonsReponses;

    // Le bouton play
    private JButton play;

    // Le nombre de reponses possibles
    private int nbReponses;

    // Les JLabel qui vont contenir les textes
    private JLabel labelQuestion, labelAide;

    // Le JPanel qui va contenir les boutons de reponses
    private JPanel reponsesPanel;

    // Le JPannel de base qui va contenir tout le reste
    private JPanel content;

    // Le JPannel qui va contenir le bouton play
    private JPanel boutonPlay;

    // Les JPannel qui vont contenir les JLabel de texte
    private JPanel questionPanel, aidePanel;

    public EnigmeAbstractFrame(String title, String question,
            String[] cheminsFichiersSon, int nbReponses, String[] reponses) {
        super(title);
        this.title = title;
        this.question = question;
        this.aide = "Pour réécouter la question, cliquez sur le bouton vert.";
        this.nbReponses = nbReponses;
        this.reponses = reponses;
        this.cheminsFichiersSon = cheminsFichiersSon;
        this.boutonsReponses = new JButton[nbReponses];
        init();
        lireQuestion(title + ":" + question, cheminsFichiersSon);
        /*new Thread() {
            public void run() {
                lireQuestion(title + ":" + question, cheminsFichiersSon);
            }
        }.start();*/
    }

    @Override
    protected void init() {
        // Conteneur principal
        content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BorderLayout());

        // Definition du panel contenant le label question
        questionPanel = new JPanel();
        questionPanel.setOpaque(false);
        questionPanel.setLayout(new BorderLayout());

        // Definition du label contenant la question
        labelQuestion = new JLabel("<html>" + title + " : " + question
                + "</html>");
        labelQuestion.setOpaque(false);
        labelQuestion.setFont(new Font("Verdana", 1, 40));
        questionPanel.add(labelQuestion, BorderLayout.CENTER);
        content.add(questionPanel, BorderLayout.NORTH);

        // Definition du panel contenant le label aide
        aidePanel = new JPanel();
        aidePanel.setOpaque(false);
        aidePanel.setLayout(new BorderLayout());

        // Definition du label contenant l'aide
        labelAide = new JLabel(aide);
        labelAide.setOpaque(false);
        labelAide.setFont(new Font("Verdana", 1, 40));
        aidePanel.add(labelAide, BorderLayout.CENTER);
        content.add(aidePanel, BorderLayout.SOUTH);

        // Definition du bouton play
        Image playLogo = ImageLoader.getImage("../ressources/images/play.gif");
        Image playLogoScaled = playLogo.getScaledInstance(150, 150,
                java.awt.Image.SCALE_SMOOTH); // Dimensions de l'icone
        ImageIcon playLogoIcon = new ImageIcon(playLogoScaled);
        play = new JButton(playLogoIcon);
        play.setOpaque(false);
        play.setFocusable(false);
        play.addActionListener(this);
        play.setFocusPainted(false); // Enleve la bordure autour de l'icone
        play.setPreferredSize(new Dimension(200, 200)); // Taille du bouton

        // Definition du panel contenant le bouton play
        boutonPlay = new JPanel();
        boutonPlay.setOpaque(false);
        boutonPlay.setLayout(new FlowLayout());
        boutonPlay.add(play); // On ajoute le bouton
        content.add(boutonPlay, BorderLayout.WEST);

        // Definition du panel contenant les boutons reponses
        reponsesPanel = new JPanel();
        reponsesPanel.setOpaque(false);
        reponsesPanel.setLayout(new GridLayout(4, 1, 0, 50));
        creerReponses(reponses);
        content.add(reponsesPanel, BorderLayout.CENTER);

        setContentPane(content);
        setVisible(true);

        // Bordures et couleur de la zone question
        setEmptyBorder(labelQuestion, 5, 20, 5, 5);
        // setMatteBorder(questionPanel, 0, 0, 1, 0, Color.BLACK);
        setComponentBackground(labelQuestion, Color.WHITE);
        setComponentForeground(labelQuestion, Color.BLACK);
        // Pour redimensionner la zone de texte
        // questionPanel.setPreferredSize(new Dimension(getScreenWidth(), 50));

        // Bordures et couleur de la zone reponses
        setEmptyBorder(reponsesPanel, 5, 50, 5, 50);
        setComponentBackground(reponsesPanel, Color.WHITE);

        // Bordures et couleur de la zone bouton play
        setEmptyBorder(boutonPlay, (getScreenHeight() / 5), 40, 0, 0);
        setComponentBackground(play, Color.GREEN);
        setComponentBackground(boutonPlay, Color.WHITE);

        // Bordures et couleur de la zone aide
        setEmptyBorder(labelAide, 5, 20, 5, 5);
        setMatteBorder(aidePanel, 1, 0, 0, 0, Color.BLACK);
        setComponentBackground(labelAide, Color.WHITE);
        setComponentForeground(labelAide, Color.BLACK);
        // Pour redimensionner la zone de texte
        // questionPanel.setPreferredSize(new Dimension(getScreenWidth(), 50));

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

    private void creerReponses(String[] noms) {
        for (int i = 0; i < nbReponses; i++) {
            creerBouton(i, noms[i]);
            reponsesPanel.add(boutonsReponses[i]);
        }
    }

    private void creerBouton(int i, String texte) {
        boutonsReponses[i] = new JButton();
        boutonsReponses[i].setText(texte);
        setPropertiesButton(boutonsReponses[i]);
    }

    // mettre a jour les proprietes des boutons
    protected void setPropertiesButton(JButton b) {
        b.setFocusable(false);
        b.addActionListener(this);
        b.setFont(new Font("Verdana", 1, 60));
        setComponentBackground(b, Color.YELLOW);
        setComponentForeground(b, Color.BLACK);
        setMatteBorder(b, 5, 5, 5, 5, Color.BLACK);
    }

    private void lireQuestion(String txt, String[] cheminsFichiersSon) {
        voix.playText(txt);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lireSonsMultiples(cheminsFichiersSon);
    }

    private void lireSonsMultiples(String[] cheminsFichiersSon) {
        for (int i = 0; i < cheminsFichiersSon.length; i++) {
            voix.stop();
            voix.playWav(cheminsFichiersSon[i]);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
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

    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
    }

    protected abstract void reponseJoueur(int reponseChoisie);

    protected abstract void lancerEnigmeSuivante();

    public void actionPerformed(ActionEvent ae) {
        voix.stop();
        Object source = ae.getSource();

        if (source == play) {
            lireQuestion(question, cheminsFichiersSon);
        }

        else {
            for (int i = 0; i < nbReponses; i++) {
                if (source == boutonsReponses[i]) {
                    reponseJoueur(i + 1);
                    lancerEnigmeSuivante();
                }
            }
        }
    }
}