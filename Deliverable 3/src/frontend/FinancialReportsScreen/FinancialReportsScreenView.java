// FinancialReportsScreenView.java
// Ethan Curtis

package frontend.FinancialReportsScreen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Represents the view component for displaying financial reports.
 */
public class FinancialReportsScreenView extends JComponent {
	private JButton backButton;
	private JLabel totalSalesLabel, totalProfitLabel;
	
	/**
     * Constructs the FinancialReportsScreenView.
     * Initializes and arranges the graphical components to display financial reports.
     */
	public FinancialReportsScreenView() {
		JPanel allContainer = new JPanel();
		allContainer.setLayout(new BorderLayout());
		
		backButton = new JButton("Back to Main Menu");
		totalSalesLabel = new JLabel("0");
		totalProfitLabel = new JLabel("$0.00");
		
		JPanel labelContainer = new JPanel(new GridLayout(2, 2, 10, 10));
		labelContainer.add(new JLabel("Total sales: "));
		labelContainer.add(totalSalesLabel);
		labelContainer.add(new JLabel("Total profit: "));
		labelContainer.add(totalProfitLabel);
		
		allContainer.add(backButton, BorderLayout.NORTH);
		allContainer.add(labelContainer);
		
		add(allContainer);
		
		setLayout(new FlowLayout());
    	setVisible(true);
	}
	
	/**
     * Adds an ActionListener to the back button.
     *
     * @param listener The ActionListener to be added to the back button.
     */
    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    /**
     * Sets the text for the total sales label.
     *
     * @param text The text to be set for the total sales label.
     */
    public void setTotalSalesLabelText(String text) {
        totalSalesLabel.setText(text);
    }

    /**
     * Sets the text for the total profit label.
     *
     * @param text The text to be set for the total profit label.
     */
    public void setTotalProfitLabelText(String text) {
        totalProfitLabel.setText(text);
    }
	
}
