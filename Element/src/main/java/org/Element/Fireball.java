package org.Element;

import contract.IMobile;

/**
 * The Fireball class, also known as the multicoloured spell.
 * @author Florent, Axel, Luc, Romain
 *
 */
public class Fireball extends Mobile{
	
	/**
	 * The spell's vector.
	 */
	private int vx;
	private int vy;
	
	/**
	 * The spell's master.
	 */
	private Lorann lorann;
	
	/**
	 * All of the spell's sprites, and the index used to go through them..
	 */
	private static final Sprite[] IMAGES =  {	
													new Sprite("fireball_1.png"),
													new Sprite("fireball_2.png"), 
													new Sprite("fireball_3.png"), 
													new Sprite("fireball_4.png"), 
											   };
	private int imageIndex;
	
	
	/**
	 * Creates a new, and unique instance of Lorann's spell.
	 * @param x
	 * 			The spell's original position on the x axis.
	 * @param y
	 * 			The spell's original position on the y axis.
	 * @param vx
	 * 			The spell's x axis vector component.
	 * @param vy
	 * 			The spell's y axis vector component.
	 * @param lorann
	 * 			The spell's master entity.
	 */
	public Fireball (int x, int y,int vx, int vy, Lorann lorann)
	{
		super( new Sprite("fireball_1.png"), x, y);
		this.vx = vx;
		this.vy = vy;
		this.lorann = lorann;
		this.lorann.getModel().getMap()[y][x] = this;
		this.imageIndex = 0;
	}
 	
	/* (non-Javadoc)
	 * @see org.Element.Monster#animate()
	 */
	@Override
	public void animate(){
		this.switchImage();
		if ( vx == 1 && vy == 0){
			this.moveRight();
		}
		if ( vx == 1 && vy == 1){
			this.moveDownRight();
		}	
		if ( vx == 1 && vy == -1){
			this.moveUpRight();
		}
		if ( vx == 0 && vy == 1){
			this.moveDown();
		}
		if ( vx == 0 && vy == -1){
			this.moveUp();
		}
		if ( vx == -1 && vy == 0){
			this.moveLeft();
		}
		if ( vx == -1 && vy == 1){
			this.moveDownLeft();
		}
		if ( vx == -1 && vy == -1){
			this.moveUpLeft();
		}
	}
	
	/**
	 * The function used to cycle through the spell's sprites.
	 */
	private void switchImage() {
		this.setSprite(Fireball.IMAGES[this.imageIndex]);
		this.imageIndex++;
		if(this.imageIndex > 3){
			this.imageIndex = 0;
		}
	}
	
	/**
	 * The function used to revert the spell's trajectory
	 */
	public void revert(){
		this.vx -= 2*vx;
		this.vy -= 2*vy;
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#kill()
	 */
	public void kill(){
		this.lorann.destroySpell();
	}
	
	/**
	 * A function used to change te spell's vector, to move towards its master.
	 */
	public void changeDirection(){
		this.vx = (this.lorann.getX()-this.getX());
		this.vy = (this.lorann.getY()-this.getY());
		if(vx > 1){
			vx = 1;
		}
		if(vx < -1){
			vx = -1;
		}
		if(vy > 1){
			vy = 1;
		}
		if(vy < -1){
			vy = -1;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.Element.Mobile#onTouch(contract.IMobile)
	 */
	public void onTouch(IMobile touch){
		if(touch instanceof Lorann){
			this.kill();
		}
	}
}
