package org.Element;


import contract.IMobile;
import contract.Permeability;
/**
 * The Item class.
 *
 * @author Florent, Axel, Luc, Romain;
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
			this.getModel().getMap()[this.getY()][this.getX()] = new White();
			if(!this.isLife){
			this.getModel().addScore(this.getValue());
			}
			else{
				this.getModel().setAddLife();
			}
		}
		super.onTouch(touch);
	}
}
