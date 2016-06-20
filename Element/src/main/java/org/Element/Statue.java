package org.Element;
/**
 * The Class Statue.
 *
 * @author florent, axel, luc, romain;
 */
public class Statue extends Item{

		/**
		 * Creates a life-giving statue.
		 * @param X
		 * 			The statue's initial position on the x axis.
		 * @param Y
		 * 			The statue's initial position on the y axis.
		 */
		public Statue(int X, int Y) {
			super( new Sprite("statue.png"),2,true, X, Y);
		}
}