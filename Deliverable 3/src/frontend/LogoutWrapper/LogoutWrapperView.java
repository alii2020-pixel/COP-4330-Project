package frontend.LogoutWrapper;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import frontend.IWrapper;

public class LogoutWrapperView extends JComponent implements IWrapper {
	public static LogoutWrapperView Instance; // Singleton
	
	private Object model, controller;
	private JComponent view;
	
	private JPanel wrapperPanel;
	private JButton logoutButton;
	
	public LogoutWrapperView() {
		Instance = this;
		
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
	
	@Override
	public void changeMVC(Object model, JComponent view, Object controller) {
		this.model = model;
		this.controller = controller;
		
		if (this.view != null)
			wrapperPanel.remove(this.view);
		this.view = view;
		wrapperPanel.add(view, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}

}
