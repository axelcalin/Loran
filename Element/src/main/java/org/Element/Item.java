package org.Element;

import java.awt.Point;

import contract.Permeability;

public abstract class Item extends Element {
	private int value;
	private boolean isLife;
	private Point position;
	
	public Item(Sprite sprite, int itemValue, boolean isLifeItem) {
		super(Permeability.BLOCKING, sprite);
		this.value = itemValue;
		this.isLife = isLifeItem;
		this.position = new Point();
	}
	
	public int getValue(){
		return this.value;
	}
	public boolean isLife(){
		return this.isLife;
	}
	
	@Override
	public void onTouch(Element touch){
		//TODO ajout de score+vie 
	}
}
