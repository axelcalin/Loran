package org.Element;

import contract.Permeability;

public class Monster_1 extends Monster
{
	public Monster_1()
	{
		super( new Sprite("â”Œâ”�", "monster_1.png"), new Monster_1Behavior());
	}
	
	@Override
	public void animate(){
		this.behavior.animate();
	}
}