package org.Element;

import contract.IMobile;

/**
 * The CrystallBall class.
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class CrystalBall extends Item
{
	/**
	 * 	Creates a crystal ball used to open the level's door.
	 * @param X
	 * 			The element's position on the x axis.
	 * @param Y
	 * 			The element's position on the y axis.
	 */
	public CrystalBall(int X, int Y)
	{
		super( new Sprite("crystal_ball.png"),0 ,false, X, Y);
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Item#onTouch(contract.IMobile)
	 */
	@Override
	public void onTouch(IMobile touch){
		if(touch instanceof Lorann){
			Gate gate = (Gate) this.getModel().getGate();
			gate.open();
			super.onTouch(touch);
		}
		super.onTouch(touch);
	}
}
