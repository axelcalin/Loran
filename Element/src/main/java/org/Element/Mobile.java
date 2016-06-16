package org.Element;

import java.awt.Point;

import contract.IMobile;
import contract.IModel;
import contract.Permeability;


public class Mobile extends DynamicElement implements IMobile
{
	private Point position;
	
	public Mobile(Sprite sprite)
	{
		super(Permeability.BLOCKING,sprite);
		this.position = new Point();
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
	
	private  boolean isMovePossible(int x, int y)
	{
		return (this.getModel().getElementxy(x, y).getPermeability() != Permeability.BLOCKING);
	}
	
	public void moveUp()
	{
		if (this.isMovePossible(this.getX(), this.getY() - 1))
		{
			this.setY(this.getY() - 1);
			this.getModel().moveElement(getX(), getY(), getX(), getY()-1);
		}
	}
	
	public void moveDown()
	{
		if (this.isMovePossible(this.getX(), this.getY() + 1))
		{
			this.setY(this.getY() + 1);
			this.getModel().moveElement(getX(), getY(), getX(), getY()+1);
		}
	}
	
	public void moveRight()
	{
		if (this.isMovePossible(this.getX() + 1, this.getY()))
		{
			this.setX(this.getX() + 1);
			this.getModel().moveElement(getX(), getY(), getX()+1, getY());
		}
	}
	
	public void moveLeft()
	{
		if (this.isMovePossible(this.getX() - 1, this.getY()))
		{
			this.setX(this.getX() - 1);
			this.getModel().moveElement(getX(), getY(), getX()-1, getY());
		}
	}
	
	public void moveUpRight()
	{
		if (this.isMovePossible(this.getX() + 1, this.getY() - 1))
		{
			this.setX(this.getX() + 1);
			this.setY(this.getY() - 1);
			this.getModel().moveElement(getX(), getY(), getX()+1, getY()-1);
		}
	}
	
	public void moveUpLeft()
	{
		if (this.isMovePossible(this.getX() - 1, this.getY() - 1))
		{
			this.setX(this.getX() - 1);
			this.setY(this.getY() - 1);
			this.getModel().moveElement(getX(), getY(), getX()-1, getY()-1);
		}
	}
	
	public void moveDownRight()
	{
		if (this.isMovePossible(this.getX() + 1, this.getY() + 1))
		{
			this.setX(this.getX() + 1);
			this.setY(this.getY() + 1);
			this.getModel().moveElement(getX(), getY(), getX()+1, getY()+1);
		}
	}
	
	public void moveDownLeft()
	{
		if (this.isMovePossible(this.getX() - 1, this.getY() + 1))
		{
			this.setX(this.getX() - 1);
			this.setY(this.getY() + 1);
			this.getModel().moveElement(getX(), getY(), getX()-1, getY()+1);
		}
	}
	
	public void kill(){
		//TODO kill this object !
	}
	@Override
	public void onTouch(Mobile touch){
		if(touch instanceof Lorann){
			touch.kill();
		}
	}

	public void animate() {
		// TODO Auto-generated method stub
		
	}
	
}
