package org.Element;

import contract.IElement;
import contract.Permeability;

public class Element implements IElement{
	private Permeability permeability;
	private Sprite spriteFile;
	
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
	
	public void onTouch(Element touch){
		
	}
}
