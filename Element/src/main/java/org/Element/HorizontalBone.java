package org.Element;

import contract.Permeability;
/**
 * The Class HorizontalBone.
 *
 * @author florent, axel, luc, romain;
 */
public class HorizontalBone extends Element
{
	/**
	 * 
	 */
	public HorizontalBone()
	{
		super( Permeability.BLOCKING,new Sprite("horizontal_bone.png"));
	}
}
