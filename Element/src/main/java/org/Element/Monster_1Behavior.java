package org.Element;

import java.util.Random;

/**
 * The Class Monster_1Behavior.
 *
 * @author florent, axel, luc, romain;
 */
public class Monster_1Behavior implements IMonsterBehavior {
	private Monster master;
	
	/**
	 * 
	 */
	public Monster_1Behavior(){
		
	}

	/* (non-Javadoc)
	 * @see org.Element.IMonsterBehavior#animate()
	 */
	public void animate() {
		  Random r = new Random();
		  int valeur = 1 + r.nextInt(8);
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
		   case 5:
		   this.master.moveRight();
		   break;
		   case 6 :
		   this.master.moveLeft();
		   break;
		   case 7 :
		   this.master.moveUp();
		   break;
		   case 8 :
		   this.master.moveDown();
		   break;
		  }
		  
		 }

	/* (non-Javadoc)
	 * @see org.Element.IMonsterBehavior#setMaster(org.Element.Monster)
	 */
	public void setMaster(Monster master){
		this.master = master;
	}

}
