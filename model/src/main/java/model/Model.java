package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import org.Element.Lorann;
import org.Element.White;

import contract.IMobile;
import contract.IElement;
import contract.IModel;

/**
 * The Class Model.
 *
 * @author florent, axel, luc, romain;
 */
public class Model extends Observable implements IModel {

	/** The message. */
	private IElement[][]			map;
	private List<IElement>			dynamicElements;
	private List<IElement>			killTargets;
	private Lorann					lorann;
	private String 					curMap;
	private String 					nextMap;
	private boolean 				isLoad;
	private IElement				mapGate;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		dynamicElements = new ArrayList<IElement>();
		isLoad = false;
		curMap = null;
		nextMap = null;
		killTargets = new ArrayList<IElement>();
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
	public synchronized void loadMap() {
		if(isLoad){
			try {
				this.curMap = this.nextMap;
				this.isLoad = false;
				final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
				this.setMap(daoHelloWorld.loadMap(nextMap, dynamicElements));
			} catch (final SQLException e) {
				e.printStackTrace();
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

	/* (non-Javadoc)
	 * @see contract.IModel#getDynamicObject()
	 */
	public List<IElement> getDynamicObject() {
		return this.dynamicElements;
	}

	/* (non-Javadoc)
	 * @see contract.IModel#getElementxy(int, int)
	 */
	public IElement getElementxy(int x, int y) {
			return map[y][x];
	}
	
	/* (non-Javadoc)
	 * @see contract.IModel#moveElement(int, int, int, int)
	 */
	public void moveElement(int x, int y, int targetx, int targety){
		this.map[targety][targetx] = this.map[y][x];
		this.map[y][x] = new White();
	}
	
	/**
	 * 
	 */
	public void setupElements(){
		for(IElement[] etab : this.map){
			for(IElement e : etab){
				e.setModel(this);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see contract.IModel#changed()
	 */
	public void changed(){
		this.setChanged();
		this.notifyObservers();
	}
	
	/* (non-Javadoc)
	 * @see contract.IModel#getLorann()
	 */
	public IMobile getLorann(){
		return this.lorann;
	}
	/* (non-Javadoc)
	 * @see contract.IModel#setLorann(contract.IMobile)
	 */
	public void setLorann(IMobile lorann){
		this.lorann = (Lorann) lorann;
	}
	
	public void tick(){
		this.loadMap();
		Iterator<IElement> dynobj = dynamicElements.iterator();
		while(dynobj.hasNext()){
				dynobj.next().animate();
		}
		this.doKill();
	}
	
	public void setPress(char key){
		this.lorann.setPress(key);
	}
	
	public void setUnpress(char key){
		this.lorann.setUnpress(key);
	}

	public void setNextMap(String map) {
		this.nextMap = map;
		this.isLoad = true;
		
	}
	
	public void setGate(IElement gate){
		this.mapGate = gate;
	}
	public IElement getGate(){
		return this.mapGate;
	}

	public void setForKill(IElement target) {
		this.killTargets.add(target);
		
	}
	
	public void doKill(){
		Iterator<IElement> targets = this.killTargets.iterator();
		Iterator<IElement> list = this.getDynamicObject().iterator();
		while(targets.hasNext()){
			IElement target = targets.next();
			while(list.hasNext()){
				if(target.getClass() == list.next().getClass()){
					this.map[((IMobile)target).getY()][((IMobile)target).getX()] = new White();
					list.remove();
				}
			}
			list = this.getDynamicObject().iterator();
		}
	}
}
