package org.Element;

public class Fireball extends Monster{
	
	/**
	 * @param y
	 * @param x
	 */
	public Fireball (int y, int x)
	{
		super( new Sprite("â”Œâ”�", "fireball_1.png"), new FireballBehavior(), x, y);
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
