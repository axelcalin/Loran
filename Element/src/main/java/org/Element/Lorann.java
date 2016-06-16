package org.Element;

import java.awt.Point;

import contract.Permeability;

public class Lorann extends Mobile
{
	private Point lastPosition;
	int j;
	int i;
	
	public Lorann(int j, int i)
	{
		super( new Sprite("â”Œâ”�", "Lorann_u.png"));
		this.lastPosition = new Point();
		this.lastPosition.setLocation(j, i);
	}
	
	private void saveLastPostion()
	{
		this.lastPosition.setLocation(j, i);
	}
	
	public void moveUp()
	{
		this.saveLastPostion();
		super.moveUp();
	}
	
	public void moveDown()
	{
		this.saveLastPostion();
		super.moveDown();
	}
	
	public void moveRight()
	{
		this.saveLastPostion();
		super.moveRight();
	}
	
	public void moveLeft()
	{
		this.saveLastPostion();
		super.moveLeft();
	}
	
	public void moveUpRight()
	{
		this.saveLastPostion();
		super.moveUpRight();
	}
	
	public void moveUpLeft()
	{
		this.saveLastPostion();
		super.moveUpLeft();
	}
	
	public void moveDownRight()
	{
		this.saveLastPostion();
		super.moveDownRight();
	}
	
	public void moveDownLeft()
	{
		this.saveLastPostion();
		super.moveDownLeft();
	}
}