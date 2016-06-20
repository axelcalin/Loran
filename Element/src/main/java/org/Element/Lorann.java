package org.Element;

import java.awt.Point;

import contract.IMobile;
import contract.IModelInternal;
import contract.Permeability;
/**
 * The Lorann class.
 * Which is our main character actually.
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class Lorann extends Mobile
{
	private Point lastPosition;
	
	/**
	 * A collection of all sprites used by Lorann, and the index of the currently used sprite.
	 */
	private static final Sprite[] IMAGES =  {	
											new Sprite("Lorann_u.png"),
											new Sprite("Lorann_ur.png"), 
											new Sprite("Lorann_r.png"), 
											new Sprite("Lorann_br.png"), 
											new Sprite("Lorann_b.png"), 
											new Sprite("Lorann_bl.png"),
											new Sprite("Lorann_l.png"),
											new Sprite("Lorann_ul.png"),
									   };
	private int imageIndex;
	
	/**
	 * Lorann's spell's instance.
	 */
	private Fireball spell;
	
	/**
	 * Booleans that indicate which keys are currently pressed.
	 */
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	private boolean shot;
	
	/**
	 * Creates Lorann at set location.
	 * @param x
	 * 			The initial position on the x axis.
	 * @param y
	 * 			The initial position on the y axis.
	 */
	public Lorann(int x, int y)
	{
		super( new Sprite("Lorann_u.png"),x,y);
		this.lastPosition = new Point();
		this.lastPosition.setLocation(x, y);
		this.setX(x);
		this.setY(y);
		this.spell = null;
		this.imageIndex = 0;
	}
	
	/**
	 * @param key
	 * 			The key corresponding to the currently pressed... key.
	 */
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
	public void setModel(IModelInternal thisModel){
		super.setModel(thisModel);
		thisModel.setLorann(this);
	}
	
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#kill()
	 */
	@Override
	public void kill(){
		this.getModel().setForKill(this);
		this.getModel().removeLife();
		this.getModel().setNextMap("me");
	}

	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#onTouch(contract.IMobile)
	 */
	public void onTouch(IMobile touch){
		if(touch instanceof Monster){
			this.kill();
		}
		if(touch instanceof Fireball){
			touch.kill();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#animate()
	 */
	@Override
	public void animate(){
		this.switchImage();
		if(spell != null){
			this.spell.animate();
		}
		if(this.up && this.left){
			this.setSprite(Lorann.IMAGES[7]);
			this.moveUpLeft();
			if(shot && this.getModel().getElementxy(getX()+1, getY()+1).getPermeability() != Permeability.BLOCKING){
				this.shoot(1,1);
			}
		}
		else if(this.up && this.right){
			this.setSprite(Lorann.IMAGES[1]);
			this.moveUpRight();
			if(shot && this.getModel().getElementxy(getX()-1, getY()+1).getPermeability() != Permeability.BLOCKING){
				this.shoot(-1,1);
			}
		}
		else if(this.down && this.left){
			this.setSprite(Lorann.IMAGES[5]);
			this.moveDownLeft();
			if(shot && this.getModel().getElementxy(getX()+1, getY()-1).getPermeability() != Permeability.BLOCKING){
				this.shoot(1,-1);
			}
		}
		else if(this.down && this.right){
			this.setSprite(Lorann.IMAGES[3]);
			this.moveDownRight();
			if(shot && this.getModel().getElementxy(getX()-1, getY()-1).getPermeability() != Permeability.BLOCKING){
				this.shoot(-1,-1);
			}
		}
		else if(this.up){
			this.setSprite(Lorann.IMAGES[0]);
			this.moveUp();
			if(shot && this.getModel().getElementxy(getX(), getY()+1).getPermeability() != Permeability.BLOCKING){
				this.shoot(0, 1);
			}
		}
		else if(this.down){
			this.setSprite(Lorann.IMAGES[4]);
			this.moveDown();
			if(shot && this.getModel().getElementxy(getX(), getY()-1).getPermeability() != Permeability.BLOCKING){
				this.shoot(0,-1);
			}
		}
		else if(this.left){
			this.setSprite(Lorann.IMAGES[6]);
			this.moveLeft();
			if(shot && this.getModel().getElementxy(getX()+1, getY()).getPermeability() != Permeability.BLOCKING){
				this.shoot(1,0);
			}
		}
		else if(this.right){
			this.setSprite(Lorann.IMAGES[2]);
			this.moveRight();
			if(shot && this.getModel().getElementxy(getX()-1, getY()).getPermeability() != Permeability.BLOCKING){
				this.shoot(-1,0);
			}
		}
	}

	/**
	 * Cycles through Lorann's sprites.
	 */
	private void switchImage() {
		this.setSprite(Lorann.IMAGES[this.imageIndex]);
		this.imageIndex++;
		if(this.imageIndex > 7){
			this.imageIndex = 0;
		}
	}

	/**
	 * The function that creates, or changes the direction of Lorann's spell.
	 * @param x
	 * 			The spell's initial position on the x axis.
	 * @param y
	 * 			The spell's initial position on the y axis.
	 */
	private void shoot(int x, int y) {
		if(spell == null){
			this.spell = new Fireball(this.getX() + x,this.getY() + y, x, y, this);
			spell.setModel(getModel());
		}
		else{
			spell.changeDirection();
		}
	}
	
	/**
	 * Destroys the current instance of the spell.
	 */
	public void destroySpell(){
		if(this.spell != null){
			this.getModel().setForKill(spell);
			this.spell = null;
		}
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