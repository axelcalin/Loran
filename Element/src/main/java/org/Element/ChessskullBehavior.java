package org.Element;


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
		/*Iterator<IMobile> i = master.getModel().getDynamicObject().iterator();
		IMobile target = null;
		while(i.hasNext() && !((target = i.next()) instanceof Lorann)){}
		if(target != null){
		int vecX = target.getX() - this.master.getX();
		int vecy = target.getY() - this.master.getY();
		}*/
		//this.master.moveLeft();
		this.master.moveRight();
		
	}
}
