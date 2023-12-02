// MainWindow.java
// Ethan Curtis, 11/23/2023
// Main window for application

package frontend;

import javax.swing.*;
import frontend.Login.LoginView;

public class MainWindow {
	public static JFrame windowFrame;
	
	private MainWindow() { } // do not allow construction
	
	public static void main(String[] args) {
		windowFrame = new JFrame("CartSafari");
		windowFrame.setSize(1200, 720);
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add login window
		LoginView loginView = new LoginView();
		
		windowFrame.add(loginView);
		windowFrame.setVisible(true);
	}
}
