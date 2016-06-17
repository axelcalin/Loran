package org.Element;

import java.awt.Point;

import contract.Permeability;
/**
 * The Class Item.
 *
 * @author florent, axel, luc, romain;
 */
public abstract class Item extends DynamicElement {
	private int value;
	private boolean isLife;
	private Point position;
	
	/**
	 * @param sprite
	 * @param itemValue
	 * @param isLifeItem
	 */
	public Item(Sprite sprite, int itemValue, boolean isLifeItem) {
		super(Permeability.BLOCKING, sprite);
		this.value = itemValue;
		this.isLife = isLifeItem;
		this.position = new Point();
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
	public void onTouch(Mobile touch){
		//TODO ajout de score+vie 
	}
}
