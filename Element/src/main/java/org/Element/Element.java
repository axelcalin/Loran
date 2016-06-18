package org.Element;

import contract.IElement;
import contract.IMobile;
import contract.IModel;
import contract.Permeability;
/**
 * The Class Element.
 *
 * @author florent, axel, luc, romain;
 */
public class Element implements IElement{
	private Permeability permeability;
	private Sprite spriteFile;
	private IModel masterModel;
	
	/**
	 * @param perm
	 * @param sprite
	 */
	public Element(Permeability perm, Sprite sprite){
		this.permeability = perm;
		this.spriteFile = sprite;
	}
	
	/* (non-Javadoc)
	 * @see contract.IElement#getSprite()
	 */
	public Sprite getSprite(){
		return this.spriteFile;
	}
	
	/* (non-Javadoc)
	 * @see contract.IElement#getPermeability()
	 */
	public Permeability getPermeability(){
		return this.permeability;
	}
	
	/**
	 * @param touch
	 */
	public void onTouch(Mobile touch){
		
	}

	/* (non-Javadoc)
	 * @see contract.IElement#animate()
	 */
	public void animate() {
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see contract.IElement#setModel(contract.IModel)
	 */
	public void setModel(IModel thisModel){
		this.masterModel = thisModel;
	}
	
	/**
	 * @return
	 */
	public IModel getModel(){
		return this.masterModel;
	}

	public void onTouch(IMobile touch) {
		// TODO Auto-generated method stub
		
	}

}
