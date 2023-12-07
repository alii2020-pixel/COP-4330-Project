// MainWindow.java
// Ethan Curtis, 11/23/2023
// Main window for application

package frontend;

import javax.swing.*;
import frontend.Login.*;

/**
 * Represents the main window of the application and implements the IWrapper interface.
 */
public class MainWindow implements IWrapper {
	private JFrame windowFrame;
	private Object model, controller;
	private JComponent view;
	
	/**
     * Singleton instance of the MainWindow class.
     */
	public static MainWindow Instance;
	
	/**
     * Private constructor to enforce the Singleton pattern and initialize the main window.
     */
	private MainWindow() {
		windowFrame = new JFrame("CartSafari");
		windowFrame.setSize(1200, 720);
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowFrame.setVisible(true);
		
		// Add login window
		LoginModel loginModel = new LoginModel();
		LoginView loginView = new LoginView();
		LoginController loginController = new LoginController(loginModel, loginView);
		
		changeMVC(loginModel, loginView, loginController);
	}
	
	/**
     * Initializes the application's main window and starts the application.
     *
     * @param args The command-line arguments.
     */
	public static void main(String[] args) {
		Instance = new MainWindow();
	}
	
	/**
     * Changes the current Model-View-Controller (MVC) to another set of MVC components.
     * Removes the old MVC from memory (unless stored elsewhere).
     *
     * @param model      The new Model component.
     * @param view       The new View component (inherited from JComponent).
     * @param controller The new Controller component.
     */
    @Override
	public void changeMVC(Object model, JComponent view, Object controller) {
		this.model = model;
		this.controller = controller;
		
		if (this.view != null)
			windowFrame.remove(this.view);
		this.view = view;
		windowFrame.add(view);
		windowFrame.revalidate();
		windowFrame.repaint();
	}
}
