package contract;

import java.util.List;
import java.util.Observable;

import org.Element.Element;

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
	List<List<Element>> getMap();

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
}
