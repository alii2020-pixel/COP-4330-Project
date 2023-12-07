// MainScreenSellerView.java
// Brandon Christian, Ethan Curtis

package frontend.MainScreenSeller;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;


public class MainScreenSellerView extends JComponent {
	private JButton sellerInventoryButton, financialReportsButton;
	
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
    
    public void addSellerInventoryButtonListener(ActionListener listener) {
    	sellerInventoryButton.addActionListener(listener);
    }
    
    public void addFinancialReportsButtonListener(ActionListener listener) {
    	financialReportsButton.addActionListener(listener);
    }
}
