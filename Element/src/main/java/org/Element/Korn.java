package org.Element;

import contract.Permeability;

public class Korn extends Monster
{
	public Korn(int y, int x)
	{
		super(new Sprite("â”Œâ”�", "monster_3.png"), new KornBehavior());
		this.setX(x);
		this.setY(y);
	}
	
	@Override
	public void animate(){
		this.behavior.animate();
	}
}
