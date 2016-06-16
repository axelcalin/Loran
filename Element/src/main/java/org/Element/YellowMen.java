package org.Element;

public class YellowMen extends Monster
{
	public YellowMen(int y, int x)
	{
		super( new Sprite("â”Œâ”�", "monster_4.png"), new YellowMenBehavior());
		this.setX(x);
		this.setY(y);
	}
	
	@Override
	public void animate(){
		this.behavior.animate();
	}
}
