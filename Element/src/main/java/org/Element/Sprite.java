package org.Element;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.imageio.ImageIO;

import contract.ISprite;

public class Sprite extends StringWriter implements ISprite {
	private Image image;

	public Sprite(final String c, final String image) {
		this.write(c);
		try {
			this.image = ImageIO.read(new File("resources/" + image));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public Sprite(final String c) {
		this(c, "noimage.png");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jpu2016.nettle.world.element.ISprite#getImage()
	 */
	public Image getImage() {
		return this.image;
	}
}
