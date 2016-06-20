package org.Element;

import contract.Permeability;
/**
 * The Stone class
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class Stone extends Element{

		public Stone() {
			super( Permeability.BLOCKING,new Sprite("bone.png"));
		}
}