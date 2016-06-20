package org.Element;

import java.util.Random;

/**
 * The Chesskull class
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class Chesskull extends Monster
{
	/**
	 * Creates a Chesskull-type (note : this name is fun) monster.
	 * @param y
	 * 			The monster's initial position on the y axis.
	 * @param x
	 * 			The monster's initial position on the x axis.
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
