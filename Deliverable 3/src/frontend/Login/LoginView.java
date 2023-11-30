// LoginView.java
// Ethan Curtis, 11/30/2023

package frontend.Login;

import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginView extends JComponent {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton signUpButton;
	
	public LoginView() {
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		loginButton = new JButton("Login");
		signUpButton = new JButton("Sign up");
		
		JPanel panel = new JPanel();
		panel.add(usernameField);
		panel.add(passwordField);
		panel.add(loginButton);
		panel.add(signUpButton);
		
		this.add(panel);
	}
	
	/**
	 * Displays a login failure window when a user fails to log in.
	 * This creates a new window that the user will close once they read it.
	 * TODO: IMPLEMENT
	 */
	public void displayLoginFailure() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Shows a symbol to let user know the system is buffering.
	 * TODO: IMPLEMENT
	 */
	public void showBuffering() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Hides the buffering symbol.
	 * TODO: IMPLEMENT
	 */
	public void hideBuffering() {
		throw new UnsupportedOperationException();
	}
	
	public void setUsernameFieldListener(ActionListener listener) {
		usernameField.addActionListener(listener);
	}
	
	public void setPasswordFieldListener(ActionListener listener) {
		passwordField.addActionListener(listener);
	}
	
	public void setLoginButtonListener(ActionListener listener) {
		loginButton.addActionListener(listener);
	}
	
	public void setSignUpButtonListener(ActionListener listener) {
		signUpButton.addActionListener(listener);
	}
}
