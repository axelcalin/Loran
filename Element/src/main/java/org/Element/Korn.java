package org.Element;

import java.util.Random;

/**
 * The Class Korn.
 *
 * @author florent, axel, luc, romain;
 */
public class Korn extends Monster
{
	/**
	 * @param y
	 * @param x
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
