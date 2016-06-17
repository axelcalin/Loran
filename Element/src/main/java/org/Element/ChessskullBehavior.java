package org.Element;

import java.util.Random;

public class ChessskullBehavior implements IMonsterBehavior {
	private Monster master;
	
	public ChessskullBehavior(){
	}
	public void setMaster(Monster master){
		this.master = master;
	}



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
