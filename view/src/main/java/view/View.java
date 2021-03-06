package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**The View class
 * 
 *@author Florent , Axel , Luc , Romain
 */
public class View implements IView, Runnable {

	
	/**
	 * The frame containing the display.
	 */
	private final ViewFrame viewFrame;

	
	/**
	 * @param model
	 * 			The model that this view will display.
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	
	/**
	 * @param keyCode
	 * @return the order of the KeyEvent
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode, boolean release) {
		if(!release){
			switch (keyCode) {
				case KeyEvent.VK_A:
					return ControllerOrder.Level1;	
				case KeyEvent.VK_Z:
					return ControllerOrder.Level2;
				case KeyEvent.VK_E:
					return ControllerOrder.Level3;
				case KeyEvent.VK_R:
					return ControllerOrder.Level4;
				case KeyEvent.VK_T:
					return ControllerOrder.Level5;
				case KeyEvent.VK_Y:
					return ControllerOrder.Test1;
				case KeyEvent.VK_U:
					return ControllerOrder.Test2;
				case KeyEvent.VK_I:
					return ControllerOrder.Test3;
				case KeyEvent.VK_O:
					return ControllerOrder.Test4;
				case KeyEvent.VK_M:
					return ControllerOrder.Menu;
				case KeyEvent.VK_ESCAPE:
					return ControllerOrder.EXIT;
				case KeyEvent.VK_UP:
					return ControllerOrder.UP;
				case KeyEvent.VK_DOWN:
					return ControllerOrder.DOWN;
				case KeyEvent.VK_LEFT:
					return ControllerOrder.LEFT;
				case KeyEvent.VK_RIGHT:
					return ControllerOrder.RIGHT;
				case KeyEvent.VK_SPACE:	
					return ControllerOrder.SPACE;
				default:
					return ControllerOrder.NULL;
			}
		}
		else{
			switch (keyCode) {
			case KeyEvent.VK_UP:
				return ControllerOrder.RELEASEUP;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.RELEASEDOWN;
			case KeyEvent.VK_LEFT:
				return ControllerOrder.RELEASELEFT;
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.RELEASERIGHT;
			case KeyEvent.VK_SPACE:	
				return ControllerOrder.RELEASESPACE;
			default:
				return ControllerOrder.NULL;
			}
		}
	}

	


	
	
	/* (non-Javadoc)
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

	/* (non-Javadoc)
	 * @see contract.IView#close()
	 */
	public void close() {
		this.viewFrame.dispose();
		
	}

}
