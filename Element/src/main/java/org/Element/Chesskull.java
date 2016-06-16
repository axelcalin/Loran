package org.Element;

public class Chesskull extends Monster
{
	public Chesskull(int y, int x)
	{
		super( new Sprite("â”Œâ”�", "monster_2.png"), new ChessskullBehavior());
		this.behavior.setMaster(this);
		this.setX(x);
		this.setY(y);
	}
	
	@Override
	public void animate(){
		this.behavior.animate();
	}
}
