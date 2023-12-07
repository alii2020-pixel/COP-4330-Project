// MainScreenSellerView.java
// Brandon Christian, Ethan Curtis

package frontend.MainScreenSeller;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

/**
 * Represents the view component for the main screen of a seller.
 */
public class MainScreenSellerView extends JComponent {
	private JButton sellerInventoryButton, financialReportsButton;
	
	/**
     * Constructs the MainScreenSellerView with buttons for seller inventory and financial reports.
     */
    public MainScreenSellerView() {
        // Create UI components
        sellerInventoryButton = new JButton("Open Seller Inventory");
        financialReportsButton = new JButton("Open Financial Reports");
       
        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(sellerInventoryButton);
        buttonPanel.add(financialReportsButton);
       
        // Set layout for the main component
        setLayout(new BorderLayout());
       
        // Add components to the main component
        add(buttonPanel, BorderLayout.CENTER);
       
        // Set component properties
        setPreferredSize(getPreferredSize());
    }
    
    /**
     * Adds an ActionListener to the seller inventory button.
     *
     * @param listener The ActionListener to be added to the seller inventory button.
     */
    public void addSellerInventoryButtonListener(ActionListener listener) {
    	sellerInventoryButton.addActionListener(listener);
    }
    
    /**
     * Adds an ActionListener to the financial reports button.
     *
     * @param listener The ActionListener to be added to the financial reports button.
     */
    public void addFinancialReportsButtonListener(ActionListener listener) {
    	financialReportsButton.addActionListener(listener);
    }
}
