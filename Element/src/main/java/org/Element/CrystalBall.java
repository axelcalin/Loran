package org.Element;

import contract.IMobile;

/**
 * The Class CrystallBall.
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class CrystalBall extends Item
{
	/**
	 * 
	 */
	public CrystalBall(int X, int Y)
	{
		super( new Sprite("â”Œâ”�", "crystal_ball.png"),0 ,false, X, Y);
	}
	
	@Override
	public void onTouch(IMobile touch){
		Gate gate = (Gate) this.getModel().getGate();
		gate.open();
		super.onTouch(touch);
	}
}
