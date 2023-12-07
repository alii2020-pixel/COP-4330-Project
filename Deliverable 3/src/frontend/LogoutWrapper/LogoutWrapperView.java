// LogoutWrapperView.java
// Ethan Curtis

package frontend.LogoutWrapper;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import frontend.IWrapper;

public class LogoutWrapperView extends JComponent {
	private JComponent view;
	
	private JPanel wrapperPanel;
	private JButton logoutButton;
	
	public LogoutWrapperView() {
		setLayout(new BorderLayout());
		
		wrapperPanel = new JPanel(new BorderLayout());
		logoutButton = new JButton("Logout");
		wrapperPanel.add(logoutButton, BorderLayout.NORTH);
		
		this.add(wrapperPanel);
		this.setVisible(true);
	}
	
	public void addLogoutButtonListener(ActionListener listener) {
		logoutButton.addActionListener(listener);
	}
	
	public void updateView(JComponent view) {
		if (this.view != null)
			wrapperPanel.remove(this.view);
		this.view = view;
		wrapperPanel.add(view, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}

}
