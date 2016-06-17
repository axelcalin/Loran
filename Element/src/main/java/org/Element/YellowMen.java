package org.Element;
/**
 * The Class Yellowmen.
 *
 * @author florent, axel, luc, romain;
 */
public class YellowMen extends Monster
{
	/**
	 * @param y
	 * @param x
	 */
	public YellowMen(int y, int x)
	{
		super( new Sprite("â”Œâ”�", "monster_4.png"), new YellowMenBehavior());
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
