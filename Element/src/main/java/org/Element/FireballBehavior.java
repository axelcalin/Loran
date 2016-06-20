package org.Element;

	/**
	 * The Class FireballBehavior.
	 *
	 * @author florent, axel, luc, romain;
	 */
	public class FireballBehavior implements IMonsterBehavior {
		private Monster master;
		
		/**
		 * 
		 */
		public FireballBehavior(){
		}
		/* (non-Javadoc)
		 * @see org.Element.IMonsterBehavior#setMaster(org.Element.Monster)
		 */
		public void setMaster(Monster master){
			this.master = master;
		}

		/* (non-Javadoc)
		 * @see org.Element.IMonsterBehavior#animate()
		 */
		public void animate() {
	
		}
}
