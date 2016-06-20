package contract;

import java.util.Observable;

import contract.IElement;

/**
 * The Interface IModel.
 *
 * @author Florent , Axel , Luc , Romain
 */
public interface IModel {

	/**
	 * Gets the currently loaded level.
	 *
	 * @return the current map.
	 */
	IElement[][] getMap();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	
	/**
	 * Executes a game tick, loading a new map if needed,
	 *  cycling through the AIs and the player's action routines,
	 *   and removing those that need to be.
	 */
	public void tick();
	
	/**
	 * Saves the current score in the database.
	 */
	public void saveScore();
	
	/**
	 * Turns on the boolean corresponding to the pressed key, allowing the player character's movement (or shooting).
	 * @param key
	 * 			The key corresponding to the pressed key.
	 */
	public void setPress(char key);
	
	/**
	 * Turns off the boolean corresponding to the pressed key, stopping the player's movement (or shooting).
	 * @param key
	 * 			The key corresponding to the pressed key.
	 */
	public void setUnpress(char key);
	
	/**
	 * Schedules a new level to be loaded on the next game tick.
	 * @param map
	 * 			The name of the level to be loaded on the next tick.
	 */
	public void setNextMap(String map);
}
