package controller;


import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Controller class
 *
 * @author Florent, Axel, Luc, Romain;
 */
public class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;
	/** The locking constant, that keeps the game running */
	private boolean game;

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
		game = true;
	}

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
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case Niveau1:
				System.out.println("niveau 1");
				this.model.setNextMap("n1");
				break;
			case Niveau2:
				System.out.println("niveau 2");
				this.model.setNextMap("n2");
				break;
			case Niveau3:
				System.out.println("niveau 3");
				this.model.setNextMap("n3");
				break;
			case Niveau4:
				System.out.println("niveau 4");
				this.model.setNextMap("n4");
				break;
			case Niveau5:
				System.out.println("niveau 5");
				this.model.setNextMap("n5");
				break;
			case Menu:
				System.out.println("menu");
				this.model.setNextMap("me");
				break;
			case Test1:
				System.out.println("Test");
				this.model.setNextMap("t1");
				break;
			case Test2:
				System.out.println("Test");
				this.model.setNextMap("t2");
				break;
			case EXIT:
				System.out.println("exit");
				this.game = false;
				break;
			case UP:
				this.model.setPress('u');
				break;
			case DOWN:
				this.model.setPress('d');
				break;
			case LEFT:
				this.model.setPress('l');
				break;
			case RIGHT:
				this.model.setPress('r');
				break;
			case SPACE:
				this.model.setPress('s');
				break;
			case RELEASEUP:
				this.model.setUnpress('u');
				break;
			case RELEASEDOWN:
				this.model.setUnpress('d');
				break;
			case RELEASELEFT:
				this.model.setUnpress('l');
				break;
			case RELEASERIGHT:
				this.model.setUnpress('r');
				break;
			case RELEASESPACE:
				this.model.setUnpress('s');
			default:
				break;
		}
	}
	
	/**
	 * The program's main loop.
	 */
	public void control(){
		
		this.model.setNextMap("me");
		while(game){
			this.model.tick();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.model.saveScore();
		this.view.close();
	}

}
