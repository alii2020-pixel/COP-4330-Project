// MainWindow.java
// Ethan Curtis, 11/23/2023
// Main window for application

package frontend;

import javax.swing.*;
import frontend.Login.*;

public class MainWindow implements IWrapper {
	private JFrame windowFrame;
	private Object model, controller;
	private JComponent view;
	
	public static MainWindow Instance; // Singleton pattern
	
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
	
	public static void main(String[] args) {
		Instance = new MainWindow();
	}
	
	/**
	 * Changes the current MVC to another MVC. 
	 * Removes the old MVC from memory (unless stored elsewhere).
	 * @param model The new Model component.
	 * @param view The new View component (inherited from JComponent).
	 * @param controller The new Controller component.
	 */
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
