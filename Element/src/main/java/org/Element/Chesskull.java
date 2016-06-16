package org.Element;

public class Chesskull extends Monster
{
	public Chesskull()
	{
		super( new Sprite("â”Œâ”�", "monster_2.png"), new ChessskullBehavior());
		this.behavior.setMaster(this);
	}
	
	@Override
	public void animate(){
		this.behavior.animate();
	}
}
