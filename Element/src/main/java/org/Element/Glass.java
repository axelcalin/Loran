package org.Element;
/**
 * The Glass class
 *
 * @author florent, axel, luc, romain;
 */
public class Glass extends Item
{
	
	/**
	 * Creates a chalice with a score value of 650.
	 * @param X
	 * 			The chalice's position on the x axis.
	 * @param Y
	 * 			The chalice's position on the y axis
	 */
	public Glass(int X, int Y)
	{
		super( new Sprite("Glass.png"),650,false, X, Y);
	}
}
