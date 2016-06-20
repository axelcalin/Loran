package org.Element;

import contract.IMobile;
import contract.IModelInternal;
import contract.Permeability;

/**
 * The Gate class.
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class Gate extends Element
{
	
	/**
	 * Indicates whether the door is open or closed.
	 */
	private boolean open;
	
	/**
	 * Creates the end-of-level door.
	 * @param open
	 * 			Indicates whether the door is already open or not.
	 */
	public Gate(boolean open)
	{
		super( Permeability.BLOCKING,new Sprite("gate_closed.png"));
		this.open = false;
		if(open){
			this.open();
		}
	}
	
	
	/* (non-Javadoc)
	 * @see org.Element.Element#setModel(contract.IModelInternal)
	 */
	@Override
	public void setModel(IModelInternal model){
		model.setGate(this);
		super.setModel(model);
	}
	
	/**
	 * Opens the door.
	 */
	public void open() {
		this.setSprite(new Sprite("gate_open.png"));
		open = true;
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Element#onTouch(contract.IMobile)
	 */
	@Override
	public void onTouch(IMobile touch){
		if(touch instanceof Lorann){
			if(open){
				this.getModel().setNextMap("me");
			}
			else{
				touch.kill();
			}
		}
		super.onTouch(touch);
	}
}
