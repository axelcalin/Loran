package org.Element;

import contract.Permeability;
/**
 * The White class. It is actually black.
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class White extends Element
{
	
	public White()
	{
		super( Permeability.PERMEABLE,new Sprite("black.png"));
	}
}