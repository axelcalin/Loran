package org.Element;

import contract.IMobile;

/**
 * The Monster class
 *
 * @author Florent, Axel, Luc, Romain;
 */
public abstract class Monster extends Mobile {

	public Monster(Sprite sprite, int X, int Y) {
		super(sprite, X, Y);
	}

	/* (non-Javadoc)
	 * @see org.Element.Mobile#animate()
	 */
	public void animate(){
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#onTouch(contract.IMobile)
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
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#kill()
	 */
	public void kill(){
		this.getModel().setForKill(this);
	}
}
