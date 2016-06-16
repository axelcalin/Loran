package org.Element;

import java.awt.Point;

import contract.Permeability;

public class Lorann extends Mobile
{
	private Point lastPosition;
	
	public Lorann(int j, int i)
	{
		super( new Sprite("â”Œâ”�", "Lorann_u.png"));
		this.lastPosition = new Point();
		this.lastPosition.setLocation(j, i);
	}
}