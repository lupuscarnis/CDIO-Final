package controllers;

import java.io.IOException;
import boundary.GUIController;

/**
 * Class is base controller for all classes in "controllers" package EXCEPT GameBoardController as it's
 * strictly used as lookup and therefore does not use the other controllers.
 */
public abstract class BaseController {

	protected GUIController gui = null;
	protected GameBoardController gbc = null;
	/**
	 * Gets the singletons of the two Controllers
	 * @throws IOException
	 */
	public BaseController() throws IOException {
		this.gui = GUIController.getInstance(); // singleton
		this.gbc = GameBoardController.getInstance(); // singleton		
	}
}
