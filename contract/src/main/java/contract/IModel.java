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
	 * Load the message.
	 *
	 * @param key
	 *          the key
	 */
	void loadMap(String key);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	
	/**
	 * @return
	 */
	List<IElement> getDynamicObject();
	
	/**
	 * @param x
	 * @param y
	 * @return
	 */
	IElement getElementxy(int x, int y);
	
	/**
	 * @param x
	 * @param y
	 * @param targetx
	 * @param targety
	 */
	public void moveElement(int x, int y, int targetx, int targety);
	
	/**
	 * 
	 */
	public void changed();
	
	/**
	 * @return
	 */
	public IMobile getLorann();

	/**
	 * @param lorann
	 */
	void setLorann(IMobile lorann);
}
