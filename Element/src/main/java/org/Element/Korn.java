package org.Element;

import contract.Permeability;

public class Korn extends Monster
{
	public Korn()
	{
		super(new Sprite("â”Œâ”�", "monster_3.png"), new KornBehavior());
	}
	
	@Override
	public void animate(){
		this.behavior.animate();
	}
}
