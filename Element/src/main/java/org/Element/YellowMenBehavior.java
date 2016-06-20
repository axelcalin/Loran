package org.Element;

import java.util.Random;

/**
 * The Class YellowMenBehavior.
 *
 * @author florent, axel, luc, romain;
 */
public class YellowMenBehavior implements IMonsterBehavior {
	private Monster master;
	/**
	 * 
	 */
	public YellowMenBehavior(){
		
	}

	/* (non-Javadoc)
	 * @see org.Element.IMonsterBehavior#animate()
	 */
	public void animate() {
		int XL = this.master.getModel().getLorann().getX();
		int YL = this.master.getModel().getLorann().getY();
		int XA = this.master.getX();
		int YA = this.master.getY();
		int XN = XA - XL;
		int YN = YA - YL;
		Random moveRand = new Random();
		int rand = moveRand.nextInt(5);
		
		if (XN == 0 && YN < 0){
			this.master.moveDown();
		}
		else if (XN == 0 && YN > 0){
			this.master.moveUp();
		}
		else if (XN < 0 && YN < 0){
			this.master.moveDownRight();
		}
		else if (XN > 0 && YN < 0){
			this.master.moveLeft();
		}
		else if  (XN < 0 && YN > 0){
			this.master.moveUpRight(); 
		}
		else if (XN > 0 && YN > 0){
			this.master.moveUpLeft();
		}
		else if  (XN < 0 && YN == 0){
			this.master.moveRight();
		}
		else if (XN > 0 && YN == 0){
			this.master.moveLeft();
		} 
		if(rand == 1) {
			Random r = new Random();
			int valeur = 1 + r.nextInt(4);
			switch(valeur){
				case 1:
				this.master.moveUpRight();
				break;
				case 2:
				this.master.moveUpLeft();
				break;
				case 3:
				this.master.moveDownLeft();
				break;
				case 4:
				this.master.moveDownRight();
				break;
			}
			
		}
	}

	

	/* (non-Javadoc)
	 * @see org.Element.IMonsterBehavior#setMaster(org.Element.Monster)
	 */
	public void setMaster(Monster master) {
		this.master = master;
		
	}

}
