package org.Element;

import java.awt.Point;

import contract.Permeability;
/**
 * The Class DynamicElement.
 *
 * @author florent, axel, luc, romain;
 */
public class DynamicElement extends Element {
	protected Point position;

	/**
	 * @param perm
	 * @param sprite
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
