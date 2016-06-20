package org.Element;

public class Fireball extends Mobile{
	
	int vx;
	int vy;
	private Lorann lorann;
	
	/**
	 * @param y
	 * @param x
	 */
	public Fireball (int x, int y,int vx, int vy, Lorann lorann)
	{
		super( new Sprite("â”Œâ”�", "fireball_1.png"), x, y);
		this.vx = vx;
		this.vy = vy;
		this.lorann = lorann;
		this.lorann.getModel().getMap()[y][x] = this;
	}
 	
	/* (non-Javadoc)
	 * @see org.Element.Monster#animate()
	 */
	@Override
	public void animate(){
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
	
	public void revert(){
		this.vx -= 2*vx;
		this.vy -= 2*vy;
	}
}
