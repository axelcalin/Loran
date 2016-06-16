package org.Element;

import contract.IModel;
import contract.Permeability;

public class DynamicElement extends Element {
	private IModel masterModel;

	public DynamicElement(Permeability perm, Sprite sprite) {
		super(perm, sprite);
	}
	public void setModel(IModel thisModel){
		this.masterModel = thisModel;
	}

}
