package contract;

/**
 * The internal interface, allowing the two model package to interact together (Model and Element).
 * @author Florent, Axel, Luc, Romain
 *
 */
public interface IModelInternal extends IModel{
	
	/**
	 * Takes the element at a given set of coordinates.
	 * @param x
	 * 			The coordinate on the x axis of the spot to verify.
	 * @param y
	 * 			The coordinate on the y axis of the spot to verify.
	 * @return The element at the given coordinates.
	 */
	IElement getElementxy(int x, int y);
	
	/**
	 * Moves an element from a position to another.
	 * @param x
	 * 			The element's current coordinate on the x axis.
	 * @param y
	 * 			The element's current coordinate on the y axis.
	 * @param targetx
	 * 			The target coordinate for the movement on the x axis.
	 * @param targety
	 * 			The target coordinate for the movement on the y axis.
	 */
	public void moveElement(int x, int y, int targetx, int targety);
	
	/**
	 * @return the current map's main character's instance.
	 */
	public IMobile getLorann();

	/**
	 * @param lorann
	 * 			Sets the current map's main character's instance.
	 */
	void setLorann(IMobile lorann);
	
	/**
	 * @param gate
	 * 			Sets the current map's exit door.
	 */
	public void setGate(IElement gate);
	
	/**
	 * @return The current map's exit door.
	 */
	public IElement getGate();

	/**
	 * @param target
	 * 			Sets an element as a target for elimination on next game tick.
	 */
	void setForKill(IElement target);


	
	/**
	 * @param score
	 * 			Adds the value to the current game's score.
	 */
	public void addScore(int score);
	
	/**
	 * Removes a life.
	 */
	public void removeLife();
	
	/**
	 * Sets the boolean to add a life after finishing the level.
	 */
	public void setAddLife();
}
