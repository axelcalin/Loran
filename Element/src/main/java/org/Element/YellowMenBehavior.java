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
		
		if (XN == 0 && YN < 0){
			this.master.moveDown();
		}
		if (XN == 0 && YN > 0){
			this.master.moveUp();
		}
		if (XN < 0 && YN < 0){
			this.master.moveDownRight();
		}
		if (XN > 0 && YN < 0){
			this.master.moveLeft();
		}
		if  (XN < 0 && YN > 0){
			this.master.moveUpRight(); 
		}
		if (XN > 0 && YN > 0){
			this.master.moveUpLeft();
		}
		if  (XN < 0 && YN == 0){
			this.master.moveRight();
		}
		if (XN > 0 && YN == 0){
			this.master.moveLeft();
		} else {
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
