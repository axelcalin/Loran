package contract;

import java.util.List;
import java.util.Observable;

import contract.IMobile;

import contract.IElement;

/**
 * The Interface IModel.
 *
 * @author florent , axel , luc , romain
 */
public interface IModel {

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	IElement[][] getMap();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	
	public void tick();
	
	public void saveScore();
	
	public void setPress(char key);
	
	public void setUnpress(char key);
	
	public void setNextMap(String map);
}
