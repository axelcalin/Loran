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
import contract.IModelInternal;

/**
 * The Model class.
 *
 * @author Florent, Axel, Luc, Romain;
 */
/**
 * @author Florent
 *
 */
public class Model extends Observable implements IModel, IModelInternal {

	/** The current level's map. */
	private IElement[][]			map;
	
	/** The list of the current map's dynamic elements. */
	private List<IElement>			dynamicElements;
	
	/** The list of "to be eliminated on next tick" entities. */
	private List<IElement>			killTargets;
	
	/** Critically important entities on the map, the hero and the exit door */
	private Lorann					lorann;
	private IElement				mapGate;
	
	/** The map-loading variables, nextMap defines which, isLoad tells the game to load it. */
	private String 					nextMap;
	private boolean 				isLoad;
	
	/** The game's score, and the boolean that sets whether a life should be added after ending the level or not*/
	private int 					score;
	private boolean 				addLife;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		dynamicElements = new ArrayList<IElement>();
		isLoad = false;
		nextMap = null;
		killTargets = new ArrayList<IElement>();
		score = 0;
		addLife = false;
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
	 * Sets the map
	 * 
	 * @param list
	 * 			The map you wish to set as current.
	 */
	public synchronized void setMap(final IElement[][] list) {
		this.map = list;
		setupElements();
		this.setChanged();
		this.notifyObservers();
	}


	/**
	 * Loads the map defined by nextMap, if isLoad is set to true.
	 * Also adds two lives when going back to the "menu" and addLife is true.
	 */
	public synchronized void loadMap() {
		if(isLoad){
			if(nextMap.equalsIgnoreCase("me") && this.addLife){
				DAOLife daoLife;
				try{
					daoLife = new DAOLife(DBConnection.getInstance().getConnection());
					daoLife.addLife();
				} catch(SQLException e){
					e.printStackTrace();
				}
			}
			try {
//				this.curMap = this.nextMap;
				this.isLoad = false;
				final DAOModel daoModel = new DAOModel(DBConnection.getInstance().getConnection());
				this.setMap(daoModel.loadMap(nextMap, dynamicElements));
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

	/**
	 * @return	The list of this map's dynamic objects.
	 */
	public List<IElement> getDynamicObject() {
		return this.dynamicElements;
	}


	/* (non-Javadoc)
	 * @see contract.IModelInternal#getElementxy(int, int)
	 */
	public IElement getElementxy(int x, int y) {
			return map[y][x];
	}
	

	/* (non-Javadoc)
	 * @see contract.IModelInternal#moveElement(int, int, int, int)
	 */
	public void moveElement(int x, int y, int targetx, int targety){
		this.map[targety][targetx] = this.map[y][x];
		this.map[y][x] = new White();
	}
	
	/**
	 * Calls all elements to set this model as the one they're attached to.
	 */
	public void setupElements(){
		for(IElement[] etab : this.map){
			for(IElement e : etab){
				e.setModel(this);
			}
		}
	}
	

	/**
	 * Sets the model as changed, once per tick.
	 */
	public void changed(){
		this.setChanged();
		this.notifyObservers();
	}
	

	/* (non-Javadoc)
	 * @see contract.IModelInternal#getLorann()
	 */
	public IMobile getLorann(){
		return this.lorann;
	}

	
	/* (non-Javadoc)
	 * @see contract.IModelInternal#setLorann(contract.IMobile)
	 */
	public void setLorann(IMobile lorann){
		this.lorann = (Lorann) lorann;
	}
	
	/* (non-Javadoc)
	 * @see contract.IModel#tick()
	 */
	public void tick(){
		this.loadMap();
		Iterator<IElement> dynobj = dynamicElements.iterator();
		while(dynobj.hasNext()){
				dynobj.next().animate();
		}
		this.doKill();
		this.changed();
	}
	
	/* (non-Javadoc)
	 * @see contract.IModel#setPress(char)
	 */
	public void setPress(char key){
		this.lorann.setPress(key);
	}
	
	/* (non-Javadoc)
	 * @see contract.IModel#setUnpress(char)
	 */
	public void setUnpress(char key){
		this.lorann.setUnpress(key);
	}

	/* (non-Javadoc)
	 * @see contract.IModel#setNextMap(java.lang.String)
	 */
	public void setNextMap(String map) {
		this.nextMap = map;
		this.isLoad = true;
		
	}
	
	/* (non-Javadoc)
	 * @see contract.IModelInternal#setGate(contract.IElement)
	 */
	public void setGate(IElement gate){
		this.mapGate = gate;
	}
	
	/* (non-Javadoc)
	 * @see contract.IModelInternal#getGate()
	 */
	public IElement getGate(){
		return this.mapGate;
	}

	/* (non-Javadoc)
	 * @see contract.IModelInternal#setForKill(contract.IElement)
	 */
	public void setForKill(IElement target) {
		this.killTargets.add(target);
	}
	
	/**
	 * Removes the objects stored in targets from the map.
	 */
	public void doKill(){
		Iterator<IElement> targets = this.killTargets.iterator();
		Iterator<IElement> list = this.getDynamicObject().iterator();
		while(targets.hasNext()){
			IElement target = targets.next();
			while(list.hasNext()){
				if(target.getClass() == list.next().getClass()){
					list.remove();
				}
			}
			list = this.getDynamicObject().iterator();
			this.map[((IMobile)target).getY()][((IMobile)target).getX()] = new White();
		}
		this.killTargets.clear();
	}
	
	/* (non-Javadoc)
	 * @see contract.IModelInternal#addScore(int)
	 */
	public void addScore(int score){
		this.score += score;
	}
	
	/* (non-Javadoc)
	 * @see contract.IModel#saveScore()
	 */
	public void saveScore(){
		DAOModel daoHelloWorld;
		try {
			daoHelloWorld = new DAOModel(DBConnection.getInstance().getConnection());
			daoHelloWorld.saveScoreToDB(score);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see contract.IModelInternal#removeLife()
	 */
	public void removeLife() {
		DAOLife daoLife;
		try{
			daoLife = new DAOLife(DBConnection.getInstance().getConnection());
			daoLife.removeLife();
			if(daoLife.getLife() < 1){
				this.saveScore();
				daoLife.resetLife();
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	/* (non-Javadoc)
	 * @see contract.IModelInternal#setAddLife()
	 */
	public void setAddLife() {
		this.addLife = true;
	}
}
