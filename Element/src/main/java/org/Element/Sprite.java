package org.Element;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.imageio.ImageIO;

import contract.ISprite;
/**
 * The Class Sprite.
 *
 * @author florent, axel, luc, romain;
 */
public class Sprite extends StringWriter implements ISprite {
	private Image image;

	/**
	 * @param c
	 * @param image
	 */
	public Sprite(final String c, final String image) {
		try {
			this.image = ImageIO.read(new File("resources/" + image));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param c
	 */
	public Sprite(final String c) {
		this(c, "noimage.png");
	}



	/* (non-Javadoc)
	 * @see contract.ISprite#getImage()
	 */
	public Image getImage() {
		return this.image;
	}
}
