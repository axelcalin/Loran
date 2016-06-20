package org.Element;

import contract.Permeability;
/**
 * The Verticalbone class
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class VerticalBone extends Element
{

	public VerticalBone()
	{
		super( Permeability.BLOCKING,new Sprite("vertical_bone.png"));
	}

}
