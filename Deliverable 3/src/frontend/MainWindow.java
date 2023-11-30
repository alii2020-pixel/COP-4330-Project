// MainWindow.java
// Ethan Curtis, 11/23/2023
// Main window for application

package frontend;

import javax.swing.*;

public class MainWindow {
	public static JFrame windowFrame;
	
	private MainWindow() { } // do not allow construction
	
	public static void main(String[] args) {
		windowFrame = new JFrame("CartSafari");
		windowFrame.setSize(1200, 720);
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowFrame.setVisible(true);
		
		// Add login window
	}
}
