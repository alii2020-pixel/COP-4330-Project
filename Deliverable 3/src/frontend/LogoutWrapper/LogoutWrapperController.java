// LogoutWrapperController.java
// Ethan Curtis

package frontend.LogoutWrapper;

import javax.swing.JComponent;
import frontend.*;
import frontend.Login.*;

/**
 * Controls the logout wrapper functionality, implementing the IWrapper interface.
 */
public class LogoutWrapperController implements IWrapper {
	public static LogoutWrapperController Instance;
	
	private LogoutWrapperView view;
	private LogoutWrapperModel model;
	
	private Object customModel, customController;
	
	/**
     * Constructs a LogoutWrapperController with the associated LogoutWrapperView and LogoutWrapperModel.
     *
     * @param view  The view component for the logout wrapper.
     * @param model The model containing logout-related functionality and data.
     */
	public LogoutWrapperController(LogoutWrapperView view, LogoutWrapperModel model) {
		Instance = this;
		
		this.view = view;
		this.model = model;
		
		this.view.addLogoutButtonListener(e -> onLogoutButtonClick());
	}
	
	/**
     * Handles the action when the logout button is clicked.
     * Performs the logout operation and navigates back to the login view.
     */
	private void onLogoutButtonClick() {
		model.logout();
		
		LoginModel model = new LoginModel();
		LoginView view = new LoginView();
		
		MainWindow.Instance.changeMVC(model, view, new LoginController(model, view));
	}
	
	/**
     * Changes the Model-View-Controller (MVC) components for a custom view in the logout wrapper.
     *
     * @param model     The custom model component.
     * @param view      The custom view component (inherited from JComponent).
     * @param controller The custom controller component.
     */
	public void changeMVC(Object model, JComponent view, Object controller) {
		this.customModel = model;
		this.customController = controller;
		
		this.view.updateView(view);
	}
}
