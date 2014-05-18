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

    protected abstract String wavRegleJeu();

    protected abstract String wavAide();

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
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE
                || e.getKeyCode() == KeyEvent.VK_LEFT) {
            dispose();
        }

        if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
            voix.playWav(wavRegleJeu());
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            voix.playWav(wavAide());
        }
        
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            voix.stop();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
