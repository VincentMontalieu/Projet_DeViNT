package image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel {
	private Image image;
	private int x;
	private int y;

	public ImagePanel(Image image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, null);
	}
}