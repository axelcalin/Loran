package org.Element;

import java.util.Random;

/**
 * The Korn class
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class Korn extends Monster
{
	/**
	 * Creates a Korn-type monster at set location
	 * @param y
	 * 			The initial position on the y axis.
	 * @param x
	 * 			The initial position on the x axis.
	 */
	public Korn(int y, int x)
	{
		super(new Sprite("monster_3.png"), x, y);
		this.setX(x);
		this.setY(y);
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Monster#animate()
	 */
	@Override
	public void animate(){
		Random r = new Random();
		int valeur = 1 + r.nextInt(4);
		switch(valeur){
		   case 1:
			   this.moveUpRight();
			   break;
		   case 2:
			   this.moveUpLeft();
			   break;
		   case 3:
			   this.moveDownLeft();
			   break;
		   case 4:
			   this.moveDownRight();
			   break;
		}
	}
}
