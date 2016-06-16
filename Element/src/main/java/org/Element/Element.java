package org.Element;

import contract.IElement;
import contract.IModel;
import contract.Permeability;

public class Element implements IElement{
	private Permeability permeability;
	private Sprite spriteFile;
	private IModel masterModel;
	
	public Element(Permeability perm, Sprite sprite){
		this.permeability = perm;
		this.spriteFile = sprite;
	}
	
	public Sprite getSprite(){
		return this.spriteFile;
	}
	
	public Permeability getPermeability(){
		return this.permeability;
	}
	
	public void onTouch(Mobile touch){
		
	}

	public void animate() {
		// TODO Auto-generated method stub
		
	}
	
	public void setModel(IModel thisModel){
		this.masterModel = thisModel;
	}
	
	public IModel getModel(){
		return this.masterModel;
	}

}
