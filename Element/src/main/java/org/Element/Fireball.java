package org.Element;

import contract.IMobile;

public class Fireball extends Mobile{
	
	private int vx;
	private int vy;
	private Lorann lorann;
	private static final Sprite[] IMAGES =  {	
													new Sprite("fireball_1.png"),
													new Sprite("fireball_2.png"), 
													new Sprite("fireball_3.png"), 
													new Sprite("fireball_4.png"), 
											   };
	private int imageIndex;
	
	/**
	 * @param y
	 * @param x
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
	private void switchImage() {
		this.setSprite(Fireball.IMAGES[this.imageIndex]);
		this.imageIndex++;
		if(this.imageIndex > 3){
			this.imageIndex = 0;
		}
	}
	
	public void revert(){
		this.vx -= 2*vx;
		this.vy -= 2*vy;
	}
	public void kill(){
		this.lorann.destroySpell();
	}
	
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
	public void onTouch(IMobile touch){
		if(touch instanceof Lorann){
			this.kill();
		}
	}
}
