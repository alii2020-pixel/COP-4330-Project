// LoginView.java
// Ethan Curtis, 11/30/2023

package frontend.Login;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginView extends JComponent {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton signUpButton;
	
	public LoginView() {
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign up");

        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5)); // 0 rows for variable number of components
        inputPanel.add(new JLabel("Username:"));
        inputPanel.add(usernameField);
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passwordField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        buttonPanel.add(signUpButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(300, 150)); // Set preferred size

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.setLayout(new GridBagLayout()); // Use GridBagLayout for LoginView
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gbc.gridy = 0;
        gbc.weightx = gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH; // Fill available space
        this.add(mainPanel, gbc);
	}
	
	/**
	 * Displays a login failure window when a user fails to log in.
	 * This creates a new window that the user will close once they read it.
	 * 
	 * @param failureMessage Message to show on the frame.
	 */
	public void displayLoginFailure(String failureMessage) {
		JFrame failureFrame = new JFrame("Login failed!");
		failureFrame.setSize(300, 240);
		failureFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		failureFrame.setVisible(true);
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel(failureMessage);
		panel.add(label);
		failureFrame.add(panel);
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
	
	/**
	 * Returns the entered username.
	 * @return The username in the username field.
	 */
	public String getUsername() {
		return usernameField.getText();
	}
	
	/**
	 * Returns the entered password.
	 * @return The password in the password field.
	 */
	public String getPassword() {
		return new String(passwordField.getPassword());
	}
	
	/**
	 * Adds an ActionListener to the login button.
	 * @param listener Listener to add to the sign up button.
	 */
	public void addLoginButtonListener(ActionListener listener) {
		loginButton.addActionListener(listener);
	}
	
	/**
	 * Adds an ActionListener to the sign up button.
	 * @param listener Listener to add to the sign up button.
	 */
	public void addSignUpButtonListener(ActionListener listener) {
		signUpButton.addActionListener(listener);
	}
}
