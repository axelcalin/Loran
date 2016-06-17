package org.Element;

import java.awt.Point;

import contract.IMobile;
import contract.Permeability;
/**
 * The Class Mobile.
 *
 * @author florent, axel, luc, romain;
 */

public class Mobile extends DynamicElement implements IMobile
{
	private Point position;
	
	/**
	 * @param sprite
	 */
	public Mobile(Sprite sprite)
	{
		super(Permeability.BLOCKING,sprite);
		this.position = new Point();
	}
	
	/* (non-Javadoc)
	 * @see contract.IMobile#getX()
	 */
	public int getX()
	{
		return this.position.x;
	}
	
	/**
	 * @param x
	 */
	protected void setX(final int x)
	{
		if ((x >= 0) && (x <= 20))
		{
			this.position.x = x;
			//TODO prevent viewer
		}
	}
	
	/* (non-Javadoc)
	 * @see contract.IMobile#getY()
	 */
	public int getY()
	{
		return this.position.y;
	}

	/**
	 * @param y
	 */
	protected void setY(final int y)
	{
		if ((y >= 0) && (y <= 12))
		{
			this.position.y = y;
			//TODO prevent viewer
		}
	}
	
	/**
	 * @param x
	 * @param y
	 * @return
	 */
	private  boolean isMovePossible(int x, int y)
	{
		return (this.getModel().getElementxy(x, y).getPermeability() != Permeability.BLOCKING);
	}
	
	/* (non-Javadoc)
	 * @see contract.IMobile#moveUp()
	 */
	public void moveUp()
	{
		if (this.isMovePossible(this.getX() , this.getY() - 1))
		{
			this.getModel().moveElement(getX(), getY(), getX(), getY()-1);
			this.setY(this.getY() - 1);
		}
	}
	
	/* (non-Javadoc)
	 * @see contract.IMobile#moveDown()
	 */
	public void moveDown()
	{
		if (this.isMovePossible(this.getX(), this.getY() + 1))
		{
			this.getModel().moveElement(getX(), getY(), getX(), getY() + 1);
			this.setY(this.getY() + 1);
		}
	}
	
	/* (non-Javadoc)
	 * @see contract.IMobile#moveRight()
	 */
	public void moveRight()
	{
		if (this.isMovePossible(this.getX() + 1, this.getY()))
		{
			this.getModel().moveElement(getX(), getY(), getX()+1, getY());
			this.setX(this.getX() + 1);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see contract.IMobile#moveLeft()
	 */
	public void moveLeft()
	{
		if (this.isMovePossible(this.getX() - 1, this.getY()))
		{
			this.getModel().moveElement(getX(), getY(), getX()-1, getY());
			this.setX(this.getX() - 1);
		}
	}
	
	/* (non-Javadoc)
	 * @see contract.IMobile#moveUpRight()
	 */
	public void moveUpRight()
	{
		if (this.isMovePossible(this.getX() + 1, this.getY() - 1))
		{
			this.getModel().moveElement(getX(), getY(), getX()+1, getY()-1);
			this.setX(this.getX() + 1);
			this.setY(this.getY() - 1);
		}
	}
	
	/* (non-Javadoc)
	 * @see contract.IMobile#moveUpLeft()
	 */
	public void moveUpLeft()
	{
		if (this.isMovePossible(this.getX() - 1, this.getY() - 1))
		{
			this.getModel().moveElement(getX(), getY(), getX()-1, getY()-1);
			this.setX(this.getX() - 1);
			this.setY(this.getY() - 1);
		}
	}
	
	/* (non-Javadoc)
	 * @see contract.IMobile#moveDownRight()
	 */
	public void moveDownRight()
	{
		if (this.isMovePossible(this.getX() + 1, this.getY() + 1))
		{
			this.getModel().moveElement(getX(), getY(), getX()+1, getY()+1);
			this.setX(this.getX() + 1);
			this.setY(this.getY() + 1);
		}
	}
	
	/* (non-Javadoc)
	 * @see contract.IMobile#moveDownLeft()
	 */
	public void moveDownLeft()
	{
		if (this.isMovePossible(this.getX() - 1, this.getY() + 1))
		{
			this.getModel().moveElement(getX(), getY(), getX()-1, getY()+1);
			this.setX(this.getX() - 1);
			this.setY(this.getY() + 1);
		}
	}
	
	/**
	 * 
	 */
	public void kill(){
		//TODO kill this object !
	}
	/* (non-Javadoc)
	 * @see org.Element.Element#onTouch(org.Element.Mobile)
	 */
	@Override
	public void onTouch(Mobile touch){
		if(touch instanceof Lorann){
			touch.kill();
		}
	}

	/* (non-Javadoc)
	 * @see org.Element.Element#animate()
	 */
	public void animate() {
		// TODO Auto-generated method stub
		
	}
	
}
