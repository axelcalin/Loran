package org.Element;

import contract.Permeability;
/**
 * The Horizontalbone class
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class HorizontalBone extends Element
{
	/**
	 * Creates an horizontal wall.
	 */
	public HorizontalBone()
	{
		super( Permeability.BLOCKING,new Sprite("horizontal_bone.png"));
	}
}
