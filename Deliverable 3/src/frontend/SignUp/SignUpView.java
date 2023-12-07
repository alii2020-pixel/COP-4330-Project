// SignUpView.java
// Ethan Curtis

package frontend.SignUp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignUpView extends JComponent {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signUpButton;
    private JButton loginButton;
    private JProgressBar progressBar;
    private JFrame failureFrame;
    private JToggleButton userTypeButton;

    public SignUpView() {
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        signUpButton = new JButton("Sign up");
        loginButton = new JButton("Return to login");
        
        userTypeButton = new JToggleButton("Customer");
        userTypeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userTypeButton.isSelected()) {
                	userTypeButton.setText("Seller");
                } else {
                	userTypeButton.setText("Customer");
                }
            }
        });

        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5)); //0 rows for variable number of components
        inputPanel.add(new JLabel("Username:"));
        inputPanel.add(usernameField);
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passwordField);
        inputPanel.add(new JLabel("User type:"));
        inputPanel.add(userTypeButton);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(signUpButton);
        buttonPanel.add(loginButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(300, 150)); //Set size

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.setLayout(new GridBagLayout()); //Use GBL for SignUpView
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gbc.gridy = 0;
        gbc.weightx = gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH; //fill blank space
        this.add(mainPanel, gbc);
    }

    /**
	 * Displays a sign up failure window when a user fails to sign up.
	 * This creates a new window that the user will close once they read it.
	 * 
	 * @param failureMessage Message to show on the frame.
	 */

    public void displaySignUpFailure(String failureMessage) {
        if (failureFrame != null) {
            failureFrame.dispose();
        }

        failureFrame = new JFrame("Sign Up Failed!");
        failureFrame.setSize(200, 120);
        failureFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label = new JLabel(failureMessage);
        label.setFont(label.getFont().deriveFont(Font.PLAIN, 18f));
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label);

        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(Box.createVerticalGlue());
        verticalBox.add(panel);
        verticalBox.add(Box.createVerticalGlue());

        failureFrame.add(verticalBox, BorderLayout.CENTER);

        failureFrame.setVisible(true);
    }

    /**
     * Displays a symbol to show the user that the program is buffering
     */
    
    public void showBuffering() {
        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setString("Signing up...");
        progressBar.setStringPainted(true);
        progressBar.setPreferredSize(new Dimension(200, 30));

        int x = (this.getWidth() - progressBar.getPreferredSize().width) / 2;
        int y = (this.getHeight() - progressBar.getPreferredSize().height) / 2;

        progressBar.setBounds(x, y, progressBar.getPreferredSize().width, progressBar.getPreferredSize().height);
        this.add(progressBar);

        this.setVisible(true);
    }

    public void hideBuffering() {
        this.remove(progressBar);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }
    
    public String getUserType() {
    	return userTypeButton.getText();
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