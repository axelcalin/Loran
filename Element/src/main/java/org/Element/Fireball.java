package org.Element;

public class Fireball extends Mobile{
	
	int vx;
	int vy;
	
	/**
	 * @param y
	 * @param x
	 */
	public Fireball (int y, int x,int vx, int vy)
	{
		super( new Sprite("â”Œâ”�", "fireball_1.png"), x, y);
		this.vx = vx;
		this.vy = vy;
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
}
