package devintAPI;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import t2s.SIVOXDevint;

public abstract class DevintFrameListener extends JFrame implements KeyListener {

    protected SIVOXDevint voix;

    protected abstract String wavAccueil();

    protected abstract String wavRegleJeu();

    public abstract void changeColor();

    public DevintFrameListener(String title) {
        super(title);
        newCursor();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addKeyListener(this);
        Preferences.getData().addDevintFrame(this);
        voix = Preferences.getData().getVoice();
    }

    public void newCursor() {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image mouse = new ImageIcon("../ressources/images/cursor.png")
                .getImage();
        Cursor cursor = t.createCustomCursor(mouse, new Point(0, 0), "big4");
        setCursor(cursor);
    }

    public void keyPressed(KeyEvent e) {
        voix.stop();
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dispose();
        }
        if (e.getKeyCode() == KeyEvent.VK_F1) {
            voix.playWav(wavRegleJeu());
        }
        if (e.getKeyCode() == KeyEvent.VK_F3) {
            Preferences.getData().changeColor();
        }
        if (e.getKeyCode() == KeyEvent.VK_F4) {
            Preferences.getData().changeVoice();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
