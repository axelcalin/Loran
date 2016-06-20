package org.Element;

import java.util.Random;

/**
 * The Yellowmen class.
 * It is actually a single man. And it's not even a man.
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class YellowMen extends Monster
{
	/**
	 * Creates a Yellowmen-class monster at set location.
	 * @param y
	 * 			The monster's initial position on the y axis.
	 * @param x
	 * 			The monster's initial position on the x axis.
	 */
	public YellowMen(int y, int x)
	{
		super( new Sprite("monster_4.png"), x, y);
		this.setX(x);
		this.setY(y);
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Monster#animate()
	 */
	@Override
	public void animate(){
		int XL = this.getModel().getLorann().getX();
		int YL = this.getModel().getLorann().getY();
		int XA = this.getX();
		int YA = this.getY();
		int XN = XA - XL;
		int YN = YA - YL;
		Random moveRand = new Random();
		int rand = moveRand.nextInt(5);
		
		if (XN == 0 && YN < 0){
			this.moveDown();
		}
		else if (XN == 0 && YN > 0){
			this.moveUp();
		}
		else if (XN < 0 && YN < 0){
			this.moveDownRight();
		}
		else if (XN > 0 && YN < 0){
			this.moveLeft();
		}
		else if  (XN < 0 && YN > 0){
			this.moveUpRight(); 
		}
		else if (XN > 0 && YN > 0){
			this.moveUpLeft();
		}
		else if  (XN < 0 && YN == 0){
			this.moveRight();
		}
		else if (XN > 0 && YN == 0){
			this.moveLeft();
		} 
		if(rand == 1) {
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
	

}
