package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import org.Element.Element;
import org.Element.Mobile;
import org.Element.White;

import contract.IMobile;
import contract.IElement;
import contract.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	/** The message. */
	private List<List<IElement>>	map;
	private List<IMobile>			dynamicElements;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public List<List<IElement>> getMap() {
		return this.map;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	private void setMap(final List<List<IElement>> list) {
		this.map = list;
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMap(String map) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setMap(daoHelloWorld.loadMap(map));
			this.setDynamicElements(this.getMap());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	private void setDynamicElements(List<List<IElement>> map) {
		dynamicElements = new ArrayList<IMobile>();
		Iterator<List<IElement>> i = map.iterator();
		IElement elem;
		while(i.hasNext()){
			Iterator<IElement> k = i.next().iterator();
			while(k.hasNext()){
				if((elem = k.next()) instanceof Mobile){
					dynamicElements.add(elem);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}

	public List<IMobile> getDynamicObject() {
		return this.dynamicElements;
	}

	public IElement getElementxy(int x, int y) {
		return map.get(y).get(x);
	}
	
	public void moveElement(int x, int y, int targetx, int targety){
		this.map.get(targety).remove(targetx);
		this.map.get(targety).add(targetx, this.map.get(y).get(x));
		this.map.get(y).remove(x);
		this.map.get(y).add(x, new White());
		this.setChanged();
		this.notifyObservers();
	}
}
