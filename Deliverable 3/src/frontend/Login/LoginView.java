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
	
	// for buffering symbol
	private JProgressBar progressBar;
	
	// for login failure window
	private JFrame failureFrame;
	
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
	    if (failureFrame != null) {
	        failureFrame.dispose();
	    }

	    failureFrame = new JFrame("Login failed!");
	    failureFrame.setSize(200, 120);
	    failureFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    JLabel label = new JLabel(failureMessage);
	    label.setFont(label.getFont().deriveFont(Font.PLAIN, 18f));
	    label.setHorizontalAlignment(JLabel.CENTER);
	    panel.add(label);

	    Box verticalBox = Box.createVerticalBox();
	    verticalBox.add(Box.createVerticalGlue()); // Add glue to center vertically
	    verticalBox.add(panel);
	    verticalBox.add(Box.createVerticalGlue()); // Add additional glue for spacing

	    failureFrame.add(verticalBox, BorderLayout.CENTER);

	    failureFrame.setVisible(true);
	}

	/**
	 * Shows a symbol to let user know the system is buffering.
	 * TODO: IMPLEMENT
	 */
	public void showBuffering() {
		//throw new UnsupportedOperationException();
		progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		progressBar.setString("Attempting to login...");
		progressBar.setStringPainted(true);
		progressBar.setPreferredSize(new Dimension(200, 30));
		
        int x = (this.getWidth() - progressBar.getPreferredSize().width) / 2;
        int y = (this.getHeight() - progressBar.getPreferredSize().height) / 2;
        
        // Set the position of the progress bar
        progressBar.setBounds(x, y, progressBar.getPreferredSize().width, progressBar.getPreferredSize().height);
        this.add(progressBar);
        
        this.setVisible(true);
	}
	
	/**
	 * Hides the buffering symbol.
	 * TODO: IMPLEMENT
	 */
	public void hideBuffering() {
		this.remove(progressBar);
		this.setVisible(true);
		this.revalidate();
		this.repaint();
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
