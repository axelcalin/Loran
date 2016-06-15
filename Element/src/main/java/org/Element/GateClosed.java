package org.Element;

import contract.Permeability;

public class GateClosed extends Element
{
	public GateClosed()
	{
		super( Permeability.BLOCKING,new Sprite("â”Œâ”�", "gate_closed.png"));
	}
}
