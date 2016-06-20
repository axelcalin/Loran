package org.Element;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import contract.ISprite;
/**
 * The Sprite class
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class Sprite implements ISprite {
	private Image image;

	/**
	 * @param image
	 * 			This sprite's image.
	 */
	public Sprite(final String image) {
		try {
			this.image = ImageIO.read(new File("resources/" + image));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see contract.ISprite#getImage()
	 */
	public Image getImage() {
		return this.image;
	}
}
