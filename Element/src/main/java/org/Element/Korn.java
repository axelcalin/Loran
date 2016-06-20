package org.Element;

/**
 * The Class Korn.
 *
 * @author florent, axel, luc, romain;
 */
public class Korn extends Monster
{
	/**
	 * @param y
	 * @param x
	 */
	public Korn(int y, int x)
	{
		super(new Sprite("â”Œâ”�", "monster_3.png"), new KornBehavior(), x, y);
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
