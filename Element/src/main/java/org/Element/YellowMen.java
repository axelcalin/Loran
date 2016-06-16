package org.Element;

public class YellowMen extends Monster
{
	public YellowMen()
	{
		super( new Sprite("â”Œâ”�", "monster_4.png"), new YellowMenBehavior());
	}
	
	@Override
	public void animate(){
		this.behavior.animate();
	}
}
