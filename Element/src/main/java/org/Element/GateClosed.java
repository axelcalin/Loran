package org.Element;

import contract.Permeability;
/**
 * The Class GateClosed.
 *
 * @author florent, axel, luc, romain;
 */
public class GateClosed extends Element
{
	/**
	 * 
	 */
	public GateClosed()
	{
		super( Permeability.BLOCKING,new Sprite("â”Œâ”�", "gate_closed.png"));
	}
}
