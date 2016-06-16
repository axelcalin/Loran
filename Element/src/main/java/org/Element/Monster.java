package org.Element;

import contract.IModel;

public abstract class Monster extends Mobile {
	protected IMonsterBehavior behavior;
	
	public Monster(Sprite sprite, IMonsterBehavior behavior) {
		super(sprite);
		this.behavior = behavior;
	}

	public void animate(){
		behavior.animate();
	}
}
