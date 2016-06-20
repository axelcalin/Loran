package org.Element;

import contract.Permeability;
/**
 * The Class Stone.
 *
 * @author florent, axel, luc, romain;
 */
public class Stone extends Element{

		/**
		 * 
		 */
		public Stone() {
			super( Permeability.BLOCKING,new Sprite("bone.png"));
		}
}