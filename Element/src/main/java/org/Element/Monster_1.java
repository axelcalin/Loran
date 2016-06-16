package org.Element;

import contract.Permeability;

public class Monster_1 extends Monster
{
	public Monster_1(int y, int x){
	super( new Sprite("â”Œâ”�", "monster_1.png"), new Monster_1Behavior());
	this.setX(x);
	this.setY(y);
	}
	
	@Override
	public void animate(){
		this.behavior.animate();
	}
}