package org.Element;

import java.util.Random;

/**
 * The Monster_1 class.
 * Because we couldn't find a funny name for this one.
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class Monster_1 extends Monster
{
	/**
	 * Creates a Monster_1 type monster at set location.
	 * @param y
	 * 			The monster's initial position on the y axis.
	 * @param x
	 * 			The monster's initial position on the x axis.
	 */
	public Monster_1(int y, int x){
	super( new Sprite("monster_1.png"), x, y);
	this.setX(x);
	this.setY(y);
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Monster#animate()
	 */
	@Override
	public void animate(){
		Random r = new Random();
		  int valeur = 1 + r.nextInt(8);
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
		   case 5:
		   this.moveRight();
		   break;
		   case 6 :
		   this.moveLeft();
		   break;
		   case 7 :
		   this.moveUp();
		   break;
		   case 8 :
		   this.moveDown();
		   break;
		  }
	}
}