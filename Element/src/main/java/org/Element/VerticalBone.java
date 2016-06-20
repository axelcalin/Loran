package org.Element;

import contract.Permeability;
/**
 * The Class VerticalBone.
 *
 * @author florent, axel, luc, romain;
 */
public class VerticalBone extends Element
{
	/**
	 * 
	 */
	public VerticalBone()
	{
		super( Permeability.BLOCKING,new Sprite("vertical_bone.png"));
	}

}
