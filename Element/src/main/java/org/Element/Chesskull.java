package org.Element;

import java.util.Random;

/**
 * The Class Chesskull.
 *
 * @author florent, axel, luc, romain;
 */
public class Chesskull extends Monster
{
	/**
	 * @param y
	 * @param x
	 */
	public Chesskull(int y, int x)
	{
		super( new Sprite("monster_2.png"), x, y);
		this.setX(x);
		this.setY(y);
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Monster#animate()
	 */
	@Override
	public void animate() {
		Random r = new Random();
		int valeur = 1 + r.nextInt(4);
		switch(valeur){
		 case 1:
			 this.moveRight();
			 break;
		 case 2:
			 this.moveLeft();
			 break;
		 case 3:
			 this.moveUp();
			 break;
		 case 4:
			 this.moveDown();
			 break;
		}
	}
}
