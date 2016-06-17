package contract;

import java.util.List;
import java.util.Observable;

import contract.IMobile;

import contract.IElement;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
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
	
	List<IElement> getDynamicObject();
	
	IElement getElementxy(int x, int y);
	
	public void moveElement(int x, int y, int targetx, int targety);
	
	public void changed();
}
