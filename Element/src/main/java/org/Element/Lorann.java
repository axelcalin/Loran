package org.Element;

import java.awt.Point;

import contract.IModel;
/**
 * The Class Lorann.
 *
 * @author florent, axel, luc, romain;
 */
public class Lorann extends Mobile
{
	/**
	 * 
	 */
	private Point lastPosition;
	
	
	/**
	 * @param j
	 * @param i
	 */
	public Lorann(int j, int i)
	{
		super( new Sprite("â”Œâ”�", "Lorann_u.png"));
		this.lastPosition = new Point();
		this.lastPosition.setLocation(j, i);
		this.setX(j);
		this.setY(i);
		
	}
	
	/**
	 * 
	 */
	public void saveLastPostion()
	{
		this.lastPosition.setLocation(this.getX(),this.getY());
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Element#setModel(contract.IModel)
	 */
	@Override
	public void setModel(IModel thisModel){
		super.setModel(thisModel);
		thisModel.setLorann(this);
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#moveUp()
	 */
	public void moveUp()
	{
		this.saveLastPostion();
		super.moveUp();
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#moveDown()
	 */
	public void moveDown()
	{
		this.saveLastPostion();
		super.moveDown();
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#moveRight()
	 */
	public void moveRight()
	{
		this.saveLastPostion();
		super.moveRight();
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#moveLeft()
	 */
	public void moveLeft()
	{
		this.saveLastPostion();
		super.moveLeft();
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#moveUpRight()
	 */
	public void moveUpRight()
	{
		this.saveLastPostion();
		super.moveUpRight();
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#moveUpLeft()
	 */
	public void moveUpLeft()
	{
		this.saveLastPostion();
		super.moveUpLeft();
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#moveDownRight()
	 */
	public void moveDownRight()
	{
		this.saveLastPostion();
		super.moveDownRight();
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#moveDownLeft()
	 */
	public void moveDownLeft()
	{
		this.saveLastPostion();
		super.moveDownLeft();
	}
}