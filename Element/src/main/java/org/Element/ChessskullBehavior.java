package org.Element;

import java.util.Random;

/**
 * The Class ChesskullBehavior.
 *
 * @author florent, axel, luc, romain;
 */
public class ChessskullBehavior implements IMonsterBehavior {
	private Monster master;
	
	/**
	 * 
	 */
	public ChessskullBehavior(){
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
			 this.master.moveRight();
			 break;
		 case 2:
			 System.out.println("IL T'ATTAQUE !!!!!");
			 this.master.moveLeft();
			 break;
		 case 3:
			 System.out.println("IL T'ATTAQUE !!!!!");
			 this.master.moveUp();
			 break;
		 case 4:
			 System.out.println("IL T'ATTAQUE !!!!!");
			 this.master.moveDown();
			 break;
		}
	}
}
