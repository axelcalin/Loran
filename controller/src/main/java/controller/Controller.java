package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

import org.Element.ILorann;
import org.Element.Lorann;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;
	
	private ILorann lorann;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case Niveau1:
				System.out.println("niveau 1");
				this.model.loadMap("n1");
				break;
			case Niveau2:
				System.out.println("niveau 2");
				this.model.loadMap("n2");
				break;
			case Niveau3:
				System.out.println("niveau 3");
				this.model.loadMap("n3");
				break;
			case Niveau4:
				System.out.println("niveau 4");
				this.model.loadMap("n4");
				break;
			case Niveau5:
				System.out.println("niveau 5");
				this.model.loadMap("n5");
				break;
			case Menu:
				System.out.println("menu");
				this.model.loadMap("me");
				break;
			case EXIT:
				System.out.println("exit");
				this.view.close();
			/*case UP:
				this.lorann.moveUp();
				break;
			case DOWN:
				this.lorann.moveDown();
				break;
			case LEFT:
				this.lorann.moveLeft();
				break;
			case RIGHT:
				this.lorann.moveRight();
				break;
			case UPRIGHT:
				this.lorann.moveUpRight();
				break;
			case UPLEFT:
				this.lorann.moveUpLeft();
				break;
			case DOWNRIGHT:
				this.lorann.moveDownRight();
				break;
			case DOWNLEFT:
				this.lorann.moveDownLeft();
				break;*/
		}
	}



}
