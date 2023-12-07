// LogoutWrapperView.java
// Ethan Curtis

package frontend.LogoutWrapper;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import frontend.IWrapper;

/**
 * Represents the view component for the logout wrapper.
 */
public class LogoutWrapperView extends JComponent {
	private JComponent view;
	private JPanel wrapperPanel;
	private JButton logoutButton;
	
	/**
     * Constructs the LogoutWrapperView with a logout button and a wrapper panel.
     */
	public LogoutWrapperView() {
		setLayout(new BorderLayout());
		
		wrapperPanel = new JPanel(new BorderLayout());
		logoutButton = new JButton("Logout");
		wrapperPanel.add(logoutButton, BorderLayout.NORTH);
		
		this.add(wrapperPanel);
		this.setVisible(true);
	}
	
	/**
     * Adds an ActionListener to the logout button.
     *
     * @param listener The ActionListener to be added to the logout button.
     */
	public void addLogoutButtonListener(ActionListener listener) {
		logoutButton.addActionListener(listener);
	}
	
	/**
     * Updates the view within the logout wrapper.
     * Replaces the existing view with a new one in the wrapper panel.
     *
     * @param view The new view component to be displayed within the wrapper.
     */
	public void updateView(JComponent view) {
		if (this.view != null)
			wrapperPanel.remove(this.view);
		this.view = view;
		wrapperPanel.add(view, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}

}
