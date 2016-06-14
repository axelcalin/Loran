package org.Element;

public class Element {
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
}
