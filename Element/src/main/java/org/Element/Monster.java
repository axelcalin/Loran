package org.Element;

/**
 * The Class Monster.
 *
 * @author florent, axel, luc, romain;
 */
public abstract class Monster extends Mobile {
	protected IMonsterBehavior behavior;
	
	/**
	 * @param sprite
	 * @param behavior
	 */
	public Monster(Sprite sprite, IMonsterBehavior behavior) {
		super(sprite);
		this.behavior = behavior;
	}

	/* (non-Javadoc)
	 * @see org.Element.Mobile#animate()
	 */
	public void animate(){
		behavior.animate();
	}
	
	/*
	 * 
	 */
	@Override
	public void onTouch(Mobile touch){
		System.out.println("Touch");
		if(touch instanceof Lorann){
			System.out.println("Kill");
			touch.kill();
		}
	}
}
