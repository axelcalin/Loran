package org.Element;
/**
 * The Onion class.
 * That... isn't an onion.
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class onion extends Item
{
	/**
	 * Creates an... onion ? With a score value of 620.
	 * @param X
	 * 			The onion's position on the x axis.
	 * @param Y
	 * 			The onion's position on the y axis
	 */
	public onion(int X, int Y)
	{
		super( new Sprite("onion.png"), 620, false, X, Y);
	}
}