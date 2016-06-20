package contract;

/**
 * The IController interface
 * 
 * Used by the view to transmit keyboard input.
 *
 * @author florent , axel , luc , romain
 */
public interface IController {


	/**
	 * This function tells the model what to do.
	 * Included orders are : load a level, move the player character, exit the game.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void orderPerform(ControllerOrder controllerOrder);
}
