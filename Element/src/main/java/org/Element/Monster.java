package org.Element;

import contract.IMobile;

/**
 * The Class Monster.
 *
 * @author florent, axel, luc, romain;
 */
public abstract class Monster extends Mobile {

	
	/**
	 * @param sprite
	 * @param behavior
	 */
	public Monster(Sprite sprite, int X, int Y) {
		super(sprite, X, Y);
	}

	/* (non-Javadoc)
	 * @see org.Element.Mobile#animate()
	 */
	public void animate(){
	}
	
	/*
	 * 
	 */
	@Override
	public void onTouch(IMobile touch){
		if(touch instanceof Lorann){
			touch.kill();
		}
		if(touch instanceof Fireball){
			this.kill();
			touch.kill();
		}
		super.onTouch(touch);
	}
	
	public void kill(){
		this.getModel().setForKill(this);
	}
}
