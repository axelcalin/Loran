package org.Element;

import java.awt.Point;

import contract.IMobile;
import contract.IModel;
import contract.Permeability;
/**
 * The Class Lorann.
 *
 * @author florent, axel, luc, romain;
 */
public class Lorann extends Mobile
{
	/**
	 * 
	 */
	private Point lastPosition;
	//private static String[]
	private Fireball spell;
	/*
	 * Booleans that indicate which keys are currently pressed.
	 */
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	private boolean shot;
	
	/**
	 * @param j
	 * @param i
	 */
	public Lorann(int j, int i)
	{
		super( new Sprite("â”Œâ”�", "Lorann_u.png"),j,i);
		this.lastPosition = new Point();
		this.lastPosition.setLocation(j, i);
		this.setX(j);
		this.setY(i);
		this.spell = null;
		
	}
	
	public void setPress(char key){
		if(key == 'u'){
			this.up = true;
		}
		if(key == 'd'){
			this.down = true;
		}
		if(key == 'l'){
			this.left = true;
		}
		if(key == 'r'){
			this.right = true;
		}
		if(key == 's'){
			this.shot = true;
		}
	}
	
	public void setUnpress(char key){
		if(key == 'u'){
			this.up = false;
		}
		if(key == 'd'){
			this.down = false;
		}
		if(key == 'l'){
			this.left = false;
		}
		if(key == 'r'){
			this.right = false;
		}
		if(key == 's'){
			this.shot = false;
		}
	}
	
	/**
	 * 
	 */
	public void saveLastPostion()
	{
		this.lastPosition.setLocation(this.getX(),this.getY());
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Element#setModel(contract.IModel)
	 */
	@Override
	public void setModel(IModel thisModel){
		super.setModel(thisModel);
		thisModel.setLorann(this);
	}
	
	/*
	 * 
	 */
	@Override
	public void kill(){
		this.getModel().setNextMap("me");
	}
	
	public void addScore(int score){
		
	}
	
	public void onTouch(IMobile touch){
		if(touch instanceof Monster){
			this.kill();
		}
		if(touch instanceof Fireball){
			touch.kill();
		}
	}
	
	/*
	 * 
	 */
	@Override
	public void animate(){
		if(this.up && this.left){
			this.moveUpLeft();
			if(shot && this.getModel().getElementxy(getX()+1, getY()+1).getPermeability() != Permeability.BLOCKING){
				this.shoot(1,1);
			}
		}
		else if(this.up && this.right){
			this.moveUpRight();
			if(shot && this.getModel().getElementxy(getX()-1, getY()+1).getPermeability() != Permeability.BLOCKING){
				this.shoot(-1,1);
			}
		}
		else if(this.down && this.left){
			this.moveDownLeft();
			if(shot && this.getModel().getElementxy(getX()+1, getY()-1).getPermeability() != Permeability.BLOCKING){
				this.shoot(1,-1);
			}
		}
		else if(this.down && this.right){
			this.moveDownRight();
			if(shot && this.getModel().getElementxy(getX()-1, getY()-1).getPermeability() != Permeability.BLOCKING){
				this.shoot(-1,-1);
			}
		}
		else if(this.up){
			this.moveUp();
			if(shot && this.getModel().getElementxy(getX(), getY()+1).getPermeability() != Permeability.BLOCKING){
				this.shoot(0, 1);
			}
		}
		else if(this.down){
			this.moveDown();
			if(shot && this.getModel().getElementxy(getX(), getY()-1).getPermeability() != Permeability.BLOCKING){
				this.shoot(0,-1);
			}
		}
		else if(this.left){
			this.moveLeft();
			if(shot && this.getModel().getElementxy(getX()+1, getY()).getPermeability() != Permeability.BLOCKING){
				this.shoot(1,0);
			}
		}
		else if(this.right){
			this.moveRight();
			if(shot && this.getModel().getElementxy(getX()-1, getY()).getPermeability() != Permeability.BLOCKING){
				this.shoot(-1,0);
			}
		}
		if(spell != null){
			this.spell.animate();
		}
	}

	private void shoot(int i, int j) {
		if(spell == null){
			this.spell = new Fireball(this.getX() + i,this.getY() + j, i, j, this);
			spell.setModel(getModel());
		}
		else{
			spell.changeDirection();
		}
	}
	public void destroySpell(){
		this.getModel().setForKill(spell);
		this.spell = null;
	}

	/* (non-Javadoc)
	 * @see org.Element.Mobile#moveUp()
	 */
	public void moveUp()
	{
		this.saveLastPostion();
		super.moveUp();
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#moveDown()
	 */
	public void moveDown()
	{
		this.saveLastPostion();
		super.moveDown();
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#moveRight()
	 */
	public void moveRight()
	{
		this.saveLastPostion();
		super.moveRight();
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#moveLeft()
	 */
	public void moveLeft()
	{
		this.saveLastPostion();
		super.moveLeft();
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#moveUpRight()
	 */
	public void moveUpRight()
	{
		this.saveLastPostion();
		super.moveUpRight();
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#moveUpLeft()
	 */
	public void moveUpLeft()
	{
		this.saveLastPostion();
		super.moveUpLeft();
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#moveDownRight()
	 */
	public void moveDownRight()
	{
		this.saveLastPostion();
		super.moveDownRight();
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#moveDownLeft()
	 */
	public void moveDownLeft()
	{
		this.saveLastPostion();
		super.moveDownLeft();
	}
}