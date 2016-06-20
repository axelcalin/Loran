package org.Element;

import java.awt.Point;

import contract.Permeability;
/**
 * The DynamicElement class
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class DynamicElement extends Element {
	protected Point position;

	/**
	 * Creates a dynamic element.
	 * @param perm
	 * 			The element's permeability.
	 * @param sprite
	 * 			The element's sprite.
	 * @param X
	 * 			The element's original position on the x axis.
	 * @param Y
	 * 			The element's original position on the y axis.
	 */
	public DynamicElement(Permeability perm, Sprite sprite, int X, int Y) {
		super(perm, sprite);
		this.position = new Point(X,Y);
	}
	
	/* (non-Javadoc)
	 * @see contract.IMobile#getY()
	 */
	public int getY()
	{
		return this.position.y;
	}
	
	/* (non-Javadoc)
	 * @see contract.IMobile#getX()
	 */
	public int getX()
	{
		return this.position.x;
	}
}
