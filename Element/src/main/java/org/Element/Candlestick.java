package org.Element;
/**
 * The Candlestick class
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class Candlestick extends Item{

	/**
	 * Creates a candlestick with a score value of 620.
	 * @param X
	 * 			The candlestick's position on the x axis.
	 * @param Y
	 * 			The candlestick's position on the y axis
	 */
	public Candlestick(int X, int Y) {
		super( new Sprite("candlestick.png"), 620, false, X, Y);
	}
}