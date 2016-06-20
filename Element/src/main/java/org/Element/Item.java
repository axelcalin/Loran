package org.Element;

import java.awt.Point;

import contract.IMobile;
import contract.Permeability;
/**
 * The Class Item.
 *
 * @author florent, axel, luc, romain;
 */
public abstract class Item extends DynamicElement {
	private int value;
	private boolean isLife;

	/**
	 * @param sprite
	 * @param itemValue
	 * @param isLifeItem
	 */
	public Item(Sprite sprite, int itemValue, boolean isLifeItem, int X, int Y) {
		super(Permeability.BLOCKING, sprite, X, Y);
		this.value = itemValue;
		this.isLife = isLifeItem;
	}
	
	/**
	 * @return
	 */
	public int getValue(){
		return this.value;
	}
	/**
	 * @return
	 */
	public boolean isLife(){
		return this.isLife;
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Element#onTouch(org.Element.Mobile)
	 */
	@Override
	public void onTouch(IMobile touch){
		if(touch instanceof Lorann){
			System.out.println("Item");
			this.getModel().getMap()[this.getY()][this.getX()] = new White();
			if(!this.isLife){
			//touch.addScore(this.getValue());
			}
		}
		super.onTouch(touch);
	}
}
