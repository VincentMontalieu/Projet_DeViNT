package instruments;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import enigme.EnigmeAbstractFrame;

@SuppressWarnings("serial")
public class ClavierPanel extends JPanel {
	protected Color do1, doDiese, re, reDiese, mi, fa, faDiese, sol, solDiese,
			la, laDiese, si, do2;
	private static final Color blanche = Color.YELLOW;
	private static final Color noire = Color.RED;

	public ClavierPanel() {
		super();
		do1 = blanche;
		doDiese = noire;
		re = blanche;
		reDiese = noire;
		mi = blanche;
		fa = blanche;
		faDiese = noire;
		sol = blanche;
		solDiese = noire;
		la = blanche;
		laDiese = noire;
		si = blanche;
		do2 = blanche;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		dessinerClavier(g, 800);
	}

	private void dessinerClavier(Graphics g, int largeur) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(largeur / 160));
		int hauteurToucheBlanche = (int) (largeur / 1.31);
		int largeurToucheBlanche = (int) (largeur / 8);
		int largeurToucheNoire = (int) (largeurToucheBlanche / 1.35);
		int hauteurToucheNoire = (int) (hauteurToucheBlanche / 1.61);
		int x = (int) ((EnigmeAbstractFrame.getScreenWidth() - largeur) / 5.5);
		int y = (int) ((EnigmeAbstractFrame.getScreenHeight() - hauteurToucheBlanche) / 6.5);

		do1(g2d, x, y, largeurToucheBlanche, hauteurToucheBlanche);
		re(g2d, x + largeurToucheBlanche, y, largeurToucheBlanche,
				hauteurToucheBlanche);
		mi(g2d, x + 2 * largeurToucheBlanche, y, largeurToucheBlanche,
				hauteurToucheBlanche);
		fa(g2d, x + 3 * largeurToucheBlanche, y, largeurToucheBlanche,
				hauteurToucheBlanche);
		sol(g2d, x + 4 * largeurToucheBlanche, y, largeurToucheBlanche,
				hauteurToucheBlanche);
		la(g2d, x + 5 * largeurToucheBlanche, y, largeurToucheBlanche,
				hauteurToucheBlanche);
		si(g2d, x + 6 * largeurToucheBlanche, y, largeurToucheBlanche,
				hauteurToucheBlanche);
		do2(g2d, x + 7 * largeurToucheBlanche, y, largeurToucheBlanche,
				hauteurToucheBlanche);

		doDiese(g2d, x + (largeurToucheBlanche - largeurToucheNoire / 2), y,
				largeurToucheNoire, hauteurToucheNoire);
		reDiese(g2d, x + (2 * largeurToucheBlanche - largeurToucheNoire / 2),
				y, largeurToucheNoire, hauteurToucheNoire);
		faDiese(g2d, x + (4 * largeurToucheBlanche - largeurToucheNoire / 2),
				y, largeurToucheNoire, hauteurToucheNoire);
		solDiese(g2d, x + (5 * largeurToucheBlanche - largeurToucheNoire / 2),
				y, largeurToucheNoire, hauteurToucheNoire);
		laDiese(g2d, x + (6 * largeurToucheBlanche - largeurToucheNoire / 2),
				y, largeurToucheNoire, hauteurToucheNoire);

		int xLettres = x + largeurToucheBlanche / 4;
		int yLettres = (int) (y + hauteurToucheBlanche / 1.1);

		dessinerLettresBlanches(g2d, largeur / 10, "S", xLettres, yLettres);
		dessinerLettresBlanches(g2d, largeur / 10, "D", xLettres
				+ largeurToucheBlanche, yLettres);
		dessinerLettresBlanches(g2d, largeur / 10, "F", xLettres + 2
				* largeurToucheBlanche, yLettres);
		dessinerLettresBlanches(g2d, largeur / 10, "G", xLettres + 3
				* largeurToucheBlanche, yLettres);
		dessinerLettresBlanches(g2d, largeur / 10, "H", xLettres + 4
				* largeurToucheBlanche, yLettres);
		dessinerLettresBlanches(g2d, largeur / 10, "J", xLettres + 5
				* largeurToucheBlanche, yLettres);
		dessinerLettresBlanches(g2d, largeur / 10, "K", xLettres + 6
				* largeurToucheBlanche, yLettres);
		dessinerLettresBlanches(g2d, largeur / 10, "L", xLettres + 7
				* largeurToucheBlanche, yLettres);

		xLettres += largeurToucheNoire / 1.7;
		yLettres -= hauteurToucheNoire / 1.2;
		int delta = (int) (largeurToucheBlanche / 1.00);

		dessinerLettresNoires(g2d, largeur / 10, "E", xLettres, yLettres);
		dessinerLettresNoires(g2d, largeur / 10, "R", delta + xLettres,
				yLettres);
		dessinerLettresNoires(g2d, largeur / 10, "Y",
				(int) (3.03 * delta + xLettres), yLettres);
		dessinerLettresNoires(g2d, largeur / 10, "U",
				(int) (4.01 * delta + xLettres), yLettres);
		dessinerLettresNoires(g2d, largeur / 10, "I",
				(int) (5.12 * delta + xLettres), yLettres);
	}

	private void do1(Graphics2D g2d, int x, int y, int largeur, int hauteur) {
		g2d.setColor(do1);
		g2d.fillRect(x, y, largeur, hauteur);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x, y, largeur, hauteur);
	}

	private void re(Graphics2D g2d, int x, int y, int largeur, int hauteur) {
		g2d.setColor(re);
		g2d.fillRect(x, y, largeur, hauteur);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x, y, largeur, hauteur);
	}

	private void mi(Graphics2D g2d, int x, int y, int largeur, int hauteur) {
		g2d.setColor(mi);
		g2d.fillRect(x, y, largeur, hauteur);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x, y, largeur, hauteur);
	}

	private void fa(Graphics2D g2d, int x, int y, int largeur, int hauteur) {
		g2d.setColor(fa);
		g2d.fillRect(x, y, largeur, hauteur);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x, y, largeur, hauteur);
	}

	private void sol(Graphics2D g2d, int x, int y, int largeur, int hauteur) {
		g2d.setColor(sol);
		g2d.fillRect(x, y, largeur, hauteur);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x, y, largeur, hauteur);
	}

	private void la(Graphics2D g2d, int x, int y, int largeur, int hauteur) {
		g2d.setColor(la);
		g2d.fillRect(x, y, largeur, hauteur);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x, y, largeur, hauteur);
	}

	private void si(Graphics2D g2d, int x, int y, int largeur, int hauteur) {
		g2d.setColor(si);
		g2d.fillRect(x, y, largeur, hauteur);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x, y, largeur, hauteur);
	}

	private void do2(Graphics2D g2d, int x, int y, int largeur, int hauteur) {
		g2d.setColor(do2);
		g2d.fillRect(x, y, largeur, hauteur);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x, y, largeur, hauteur);
	}

	private void doDiese(Graphics2D g2d, int x, int y, int largeur, int hauteur) {
		g2d.setColor(doDiese);
		g2d.fillRect(x, y, largeur, hauteur);
	}

	private void reDiese(Graphics2D g2d, int x, int y, int largeur, int hauteur) {
		g2d.setColor(reDiese);
		g2d.fillRect(x, y, largeur, hauteur);
	}

	private void faDiese(Graphics2D g2d, int x, int y, int largeur, int hauteur) {
		g2d.setColor(faDiese);
		g2d.fillRect(x, y, largeur, hauteur);
	}

	private void solDiese(Graphics2D g2d, int x, int y, int largeur, int hauteur) {
		g2d.setColor(solDiese);
		g2d.fillRect(x, y, largeur, hauteur);
	}

	private void laDiese(Graphics2D g2d, int x, int y, int largeur, int hauteur) {
		g2d.setColor(laDiese);
		g2d.fillRect(x, y, largeur, hauteur);
	}

	private void dessinerLettresBlanches(Graphics2D g2d, int taille,
			String lettre, int x, int y) {
		g2d.setFont(new Font("Verdana", 1, taille));
		g2d.setColor(Color.BLACK);
		g2d.drawString(lettre, x, y);
	}

	private void dessinerLettresNoires(Graphics2D g2d, int taille,
			String lettre, int x, int y) {
		g2d.setFont(new Font("Verdana", 1, taille));
		g2d.setColor(Color.BLACK);
		g2d.drawString(lettre, x, y);
	}
}
