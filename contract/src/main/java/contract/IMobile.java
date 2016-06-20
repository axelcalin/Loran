package contract;

/**
 * The Interface IMobile.
 *
 * @author florent , axel , luc , romain
 */
public interface IMobile
{
	public int getX();
	
	public int getY();
	
	public void moveUp();
	
	public void moveDown();
	
	public void moveRight();
	
	public void moveLeft();
	
	public void moveUpRight();
	
	public void moveUpLeft();
	
	public void moveDownRight();
	
	public void moveDownLeft();

	public void kill();

}
