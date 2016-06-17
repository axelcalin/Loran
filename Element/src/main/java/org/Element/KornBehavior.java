package org.Element;

import java.util.Random;

/**
 * The Class KornBehavior.
 *
 * @author florent, axel, luc, romain;
 */
public class KornBehavior implements IMonsterBehavior {
	private Monster master;
	
	/**
	 * 
	 */
	public KornBehavior(){
		
	}
	
	/* (non-Javadoc)
	 * @see org.Element.IMonsterBehavior#setMaster(org.Element.Monster)
	 */
	public void setMaster(Monster master){
		this.master = master;
	}

	/* (non-Javadoc)
	 * @see org.Element.IMonsterBehavior#animate()
	 */
	public void animate() {
		  Random r = new Random();
		  int valeur = 1 + r.nextInt(4);
		  switch(valeur){
		   case 1:
		   System.out.println("IL T'ATTAQUE !!!!!");
		   this.master.moveUpRight();
		   break;
		   case 2:
		   System.out.println("IL T'ATTAQUE !!!!!");
		   this.master.moveUpLeft();
		   break;
		   case 3:
		   System.out.println("IL T'ATTAQUE !!!!!");
		   this.master.moveDownLeft();
		   break;
		   case 4:
		   System.out.println("IL T'ATTAQUE !!!!!");
		   this.master.moveDownRight();
		   break;
		  }
		 }

}
