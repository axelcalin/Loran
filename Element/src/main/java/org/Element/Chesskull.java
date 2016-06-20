package org.Element;
/**
 * The Class Chesskull.
 *
 * @author florent, axel, luc, romain;
 */
public class Chesskull extends Monster
{
	/**
	 * @param y
	 * @param x
	 */
	public Chesskull(int y, int x)
	{
		super( new Sprite("â”Œâ”�", "monster_2.png"), new ChessskullBehavior(), x, y);
		this.behavior.setMaster(this);
		this.setX(x);
		this.setY(y);
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Monster#animate()
	 */
	@Override
	public void animate(){
		this.behavior.animate();
	}
}
