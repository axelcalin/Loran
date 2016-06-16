package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.Element.Element;
import org.Element.Stone;

import contract.IElement;
import contract.IMobile;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	private int width;
	private int height;
	private org.Element.Element elements[][];
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		paintComponent(getGraphics());
		this.repaint();
	}
	
	
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, 1500,1000);
		int i = 0;
		int j = 0;
		Iterator<java.util.List<IElement>> n = this.getViewFrame().getModel().getMap().iterator();
		while(n.hasNext()){
			Iterator<IElement> k = n.next().iterator();
			while(k.hasNext()){
				graphics.drawImage(k.next().getSprite().getImage(),j*82,i*82, 75, 75,this);
				j++;
			}
			i++;
			j = 0;
		}
		Iterator<java.util.List<IElement>> l = this.getViewFrame().getModel().getMap().iterator();
		while(l.hasNext()){
			Iterator<IElement> m = l.next().iterator();
			while(m.hasNext()){
				m.next().animate();
			}
		}
	}
			
			
	
	public int getWidth() {
	return this.width;
	}
	
	public int getHeight() {
	return this.height;
	}
	
	public org.Element.Element getElements(final int x, final int y) {
		if ((x < 0) || (y < 0) || (x >= this.getWidth()) || (y >= this.getHeight())) {
			return null;
		}
		return this.elements[x][y];
	}


}
		/*graphics.drawString(this.getViewFrame().getModel().getMap(), 10, 20);
		graphics.drawString("test",10,30);
		System.out.println(this.getViewFrame().getModel().getMap());
	*/

