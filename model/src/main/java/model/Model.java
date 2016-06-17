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
import contract.ILorann;
import contract.IModel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	/** The message. */
	private IElement[][]			map;
	private List<IElement>			dynamicElements;
	private ILorann					lorann;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		dynamicElements = new ArrayList<IElement>();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public IElement[][] getMap() {
		return this.map;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	private synchronized void setMap(final IElement[][] list) {
		this.map = list;
		setupElements();
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public synchronized void loadMap(String map) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setMap(daoHelloWorld.loadMap(map, dynamicElements));
		} catch (final SQLException e) {
			e.printStackTrace();
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

	public List<IElement> getDynamicObject() {
		return this.dynamicElements;
	}

	public IElement getElementxy(int x, int y) {
			return map[y][x];
	}
	
	public void moveElement(int x, int y, int targetx, int targety){
		this.map[targety][targetx] = this.map[y][x];
		this.map[y][x] = new White();
		this.setChanged();
	}
	
	public void setupElements(){
		for(IElement[] etab : this.map){
			for(IElement e : etab){
				e.setModel(this);
			}
		}
	}
	
	public void changed(){
		this.notifyObservers();
	}
	
	public ILorann getLorann(){
		return this.lorann;
	}
}
