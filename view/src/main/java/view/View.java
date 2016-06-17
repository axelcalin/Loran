package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import org.Element.Lorann;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_A:
				return ControllerOrder.Niveau1;	
			case KeyEvent.VK_Z:
				return ControllerOrder.Niveau2;
			case KeyEvent.VK_E:
				return ControllerOrder.Niveau3;
			case KeyEvent.VK_R:
				return ControllerOrder.Niveau4;
			case KeyEvent.VK_T:
				return ControllerOrder.Niveau5;
			case KeyEvent.VK_M:
				return ControllerOrder.Menu;
			case KeyEvent.VK_ESCAPE:
				return ControllerOrder.EXIT;
			case KeyEvent.VK_UP:
				System.out.println("monte");
				return ControllerOrder.UP;
			case KeyEvent.VK_DOWN:
				System.out.println("descend");
				return ControllerOrder.DOWN;
			case KeyEvent.VK_LEFT:
				System.out.println("gauche");
				return ControllerOrder.LEFT;
			case KeyEvent.VK_RIGHT:
				System.out.println("droite");
				return ControllerOrder.RIGHT;
			default:
				return ControllerOrder.NULL;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMap(final String map) {
		this.viewFrame.printMap(map);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}

	public void printMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	public void close() {
		this.viewFrame.dispose();
		
	}
}
