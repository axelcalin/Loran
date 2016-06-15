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
		this.repaint();
		paintComponent(getGraphics());
	}
	
	
	@Override
	protected void paintComponent(final Graphics graphics) {
		System.out.println("test");
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		int i = 0;
		int j = 0;
		Iterator<java.util.List<IElement>> n = this.getViewFrame().getModel().getMap().iterator();
		while(n.hasNext()){
			Iterator<IElement> k = n.next().iterator();
			while(k.hasNext()){
				graphics.drawImage(k.next().getSprite().getImage(),j*32,i*32,this);
				j++;
				System.out.println("AFFICHE BORDEL!");
			}
			i++;
			j = 0;
		}
	}
		/*private Image readImage (int x, int y){
			try {
				return ImageIO.read(new File("resources/" + ImageChoose(x, y)));
			} catch (IOException e) {
				System.out.println("Erreur de lecture d'image");
				return null;
			}
		}
		
		private String ImageChoose(final int width, final int height){
		this.width = width;
		this.height = height;
		this.elements = new ordg.Element.Element[this.getWidth()][this.getHeight()];
		
		String S = resultSet.getString("map");
		ArrayList<String> map = new ArrayList<String>();
		for(String temp : S.split("\n")) map.add(temp);

			for (int y = 0; y < map.size(); y++) {
				for (int x = 0; x < map.get(y).length(); x++) {
					switch(map.get(y).charAt(x)){
						case 'P' :
							addElement(new Stone(), x, y);
						break;
			}
				}	
			}}*/
		
			
			
	private void addElement(org.Element.Element element, int x, int y) {
		this.elements[x][y] = element;
		
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

