package org.Element;

import java.util.Iterator;

import contract.IMobile;

public class ChessskullBehavior implements IMonsterBehavior {
	private Monster master;
	
	public ChessskullBehavior(Monster master){
		this.master = master;
	}

	public void animate() {
		Iterator<IMobile> i = master.getModel().getDynamicObject().iterator();
		IMobile target = null;
		while(i.hasNext() && !((target = i.next()) instanceof Lorann)){}
		if(target != null){
		int vecX = target.getX() - this.master.getX();
		int vecy = target.getY() - this.master.getY();
		}
	}
}
