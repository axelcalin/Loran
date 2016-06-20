package org.Element;
/**
 * The Bag class.
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class Bag extends Item{

		/**
		 * Creates a bag with a score value of 650.
		 * @param X
		 * 			The bag's position on the x axis.
		 * @param Y
		 * 			The bag's position on the y axis
		 */
		public Bag(int X, int Y) {
			super( new Sprite("purse.png"), 650, false, X, Y);
		}
}