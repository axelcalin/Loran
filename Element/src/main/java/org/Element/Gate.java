package org.Element;

import contract.IMobile;
import contract.IModel;
import contract.IModelInternal;
import contract.Permeability;
/**
 * The Class GateClosed.
 *
 * @author florent, axel, luc, romain;
 */
public class Gate extends Element
{
	private boolean open;
	/**
	 * 
	 */
	public Gate(boolean open)
	{
		super( Permeability.BLOCKING,new Sprite("gate_closed.png"));
		this.open = false;
		if(open){
			this.open();
		}
	}
	
	@Override
	public void setModel(IModelInternal model){
		model.setGate(this);
		super.setModel(model);
	}
	public void open() {
		this.setSprite(new Sprite("gate_open.png"));
		open = true;
	}
	
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
	}
}
