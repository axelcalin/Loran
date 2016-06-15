package org.Element;

import java.awt.Point;

import contract.Permeability;


public class Mobile extends Element
{
	private Point position;
	private int life;
	
	public Mobile(Permeability perm, Sprite sprite, int life)
	{
		super(perm,sprite)
		this.position = new Point();
		this.life = life;
	}
	
	public int getX()
	{
		return this.position.x;
	}
	
	protected void setX(final int x)
	{
		if ((x >= 0) && (x <= 20))
		{
			this.position.x = x;
			//TODO prevent viewer
		}
	}
	
	public int getY()
	{
		return this.position.y;
	}

	protected void setY(final int y)
	{
		if ((y >= 0) && (y <= 12))
		{
			this.position.y = y;
			//TODO prevent viewer
		}
	}
	
	/*private  boolean isMovePossible(int x, int y)
	{
		return (this.getElements(x, y).getPermeability() != Permeability.BLOCKING);
	}
	
	public void moveUp()
	{
		if (this.isMovePossible(this.getX(), this.getY() - 1))
		{
			this.setY(this.getY() - 1);
		}
	}
	
	public void moveDown()
	{
		if (this.isMovePossible(this.getX(), this.getY() + 1))
		{
			this.setY(this.getY() + 1);
		}
	}
	
	public void moveRight()
	{
		if (this.isMovePossible(this.getX() + 1, this.getY()))
		{
			this.setX(this.getX() + 1);
		}
	}
	
	public void moveLeft()
	{
		if (this.isMovePossible(this.getX() - 1, this.getY()))
		{
			this.setX(this.getX() - 1);
		}
	}*/
	
	public void moveUpRight()
	{
		if (this.isMovePossible(this.getX() + 1, this.getY() - 1))
		{
			this.setX(this.getX() + 1);
			this.setY(this.getY() - 1);
		}
	}
	
	public void moveUpLeft()
	{
		if (this.isMovePossible(this.getX() - 1, this.getY() - 1))
		{
			this.setX(this.getX() - 1);
			this.setY(this.getY() - 1);
		}
	}
	
	public void moveDownRight()
	{
		if (this.isMovePossible(this.getX() + 1, this.getY() + 1))
		{
			this.setX(this.getX() + 1);
			this.setY(this.getY() + 1);
		}
	}
	
	public void moveDownLeft()
	{
		if (this.isMovePossible(this.getX() - 1, this.getY() + 1))
		{
			this.setX(this.getX() - 1);
			this.setY(this.getY() + 1);
		}
	}
	
	public void kill(){
		this.life -= 1;
		if(this.life <= 0){
			
		}
	}
	@Override
	public void onTouch(Element touch){
		if(touch instanceof Lorann){
			touch.kill();
		}
	}
	
}
