package contract;

/**
 * The IMobile interface
 * 
 * An interface for mobile elements, including : movement functions, position-getters, 
 * and a function to kill the mobile element, removing it from the program.
 *
 * @author Florent , Axel , Luc , Romain
 */
public interface IMobile
{
	/**
	 * @return int x
	 * 			Returns the element's position on the X axis.
	 */
	public int getX();
	
	/**
	 * @return int y
	 * 			Returns the element's position on the y axis.
	 */
	public int getY();
	
	/**
	 * Moves the element up by one tile.
	 */
	public void moveUp();
	
	/**
	 * Moves the element down by one tile.
	 */
	public void moveDown();
	
	/**
	 * Moves the element right by one tile.
	 */
	public void moveRight();
	
	/**
	 * Moves the element left by one tile.
	 */
	public void moveLeft();
	
	/**
	 * Moves the element diagonally up-right by one tile.
	 */
	public void moveUpRight();
	
	/**
	 * Moves the element diagonally up-left by one tile.
	 */
	public void moveUpLeft();
	
	/**
	 * Moves the element diagonally down-right by one tile.
	 */
	public void moveDownRight();
	
	/**
	 * Moves the element diagonally down-left by one tile.
	 */
	public void moveDownLeft();

	/**
	 * Destroys the element, by removing it from the map, unregistering it from the dynamic elements list,
	 *  and if the main character, loading the menu.
	 */
	public void kill();

}
