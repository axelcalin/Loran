package org.Element;

import contract.Permeability;

public abstract class Item extends Element {
	int value;
	boolean isLife;
	
	public Item(Sprite sprite, int itemValue, boolean isLifeItem) {
		super(Permeability.BLOCKING, sprite);
		this.value = itemValue;
		this.isLife = isLifeItem;
	}
	
	public int getValue(){
		return this.value;
	}
	public boolean isLife(){
		return this.isLife;
	}
	
	@Override
	public void onTouch(Element touch){
		
	}
}
