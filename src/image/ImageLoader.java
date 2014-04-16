package image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class ImageLoader {
	static public Image getImage(String chemin) {
		BufferedImage myImage = null;
		try {
			myImage = ImageIO.read(new File(chemin));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myImage;
	}
}
