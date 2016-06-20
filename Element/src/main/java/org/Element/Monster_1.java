package org.Element;


/**
 * The Class Monster_1.
 *
 * @author florent, axel, luc, romain;
 */
public class Monster_1 extends Monster
{
	/**
	 * @param y
	 * @param x
	 */
	public Monster_1(int y, int x){
	super( new Sprite("â”Œâ”�", "monster_1.png"), new Monster_1Behavior(), x, y);
	this.setX(x);
	this.setY(y);
	this.behavior.setMaster(this);
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Monster#animate()
	 */
	@Override
	public void animate(){
		this.behavior.animate();
	}
}