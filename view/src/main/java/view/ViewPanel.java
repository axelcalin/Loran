package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

import contract.IElement;

/**
 * The Class ViewPanel.
 *
 * @author florent , axel , luc , romain
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
		//this.repaint();
		paintComponent(getGraphics());
	}
	
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected synchronized void paintComponent(final Graphics graphics) {
		//graphics.clearRect(0, 0, 1920,1080);
		int i = 0;
		int j = 0;
		for(IElement[] etab : this.getViewFrame().getModel().getMap()){
			graphics.drawString("level 1", 0, 0);
			for(IElement e : etab){
				graphics.drawImage(e.getSprite().getImage(), j*92, i*89, 95, 95, this);
				j++;
			}
			i++;
			j=0;	
		}
		
	}			
			
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#getWidth()
	 */
	public int getWidth() {
	return this.width;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#getHeight()
	 */
	public int getHeight() {
	return this.height;
	}
	
	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public org.Element.Element getElements(final int x, final int y) {
		if ((x < 0) || (y < 0) || (x >= this.getWidth()) || (y >= this.getHeight())) {
			return null;
		}
		return this.elements[x][y];
	}


}

