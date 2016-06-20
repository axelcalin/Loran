package contract;
/**
 * The IElement interface.
 * 
 * Used for internal manipulation of the model.
 *
 * @author Florent , Axel , Luc , Romain
 */
public interface IElement {
	/**
	 * @return Sprite
	 * 			Returns the element's sprite
	 */
	public ISprite getSprite();
	
	/**
	 * @return Permeability
	 * 			Returns either BLOCKING or PERMEABLE,
	 * 			the first one meant to prevent elements from moving to this position,
	 * 			whereas the second allows it.
	 */
	public Permeability getPermeability();
	
	/**
	 * Animates the element.
	 */
	public void animate();
	
	/**
	 * Sets the model that the element is attached to.
	 * @param model
	 * 			The current instance of the model, that the element needs to manipulate on occasion
	 */
	public void setModel(IModelInternal model);
	
	/**
	 * Invoked when a mobile element tries to move over this element.
	 * @param touch
	 * 			The mobile element that touches this element.
	 */
	public void onTouch(IMobile touch);
}
