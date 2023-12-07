//MainScreenSellerView.java
//Brandon Christian

package frontend.MainScreenSeller;

import frontend.SellerInventoryScreen.SellerInventoryScreenView;
import frontend.FinancialReportsScreen.FinancialReportsScreenView;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;


public class MainScreenSellerView extends JComponent {
    
    private SellerInventoryScreenView sellerInventoryScreenView;
    
    private FinancialReportsScreenView financialReportsScreenView;
    
    public MainScreenSellerView() {
       
        // Instantiate Seller Inventory Screen View
        sellerInventoryScreenView = new SellerInventoryScreenView();
       
        // Instantiate Financial Reports Screen View
        financialReportsScreenView = new FinancialReportsScreenView();
       
        // Create UI components
        JButton sellerInventoryButton = new JButton("Open Seller Inventory");
        JButton financialReportsButton = new JButton("Open Financial Reports");
       
        // Add action listeners to the buttons
        sellerInventoryButton.addActionListener(e -> showSellerInventoryScreen());
        financialReportsButton.addActionListener(e -> showFinancialReportsScreen());
       
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
       
        // Set frame properties
        JFrame frame = new JFrame("Main Screen - Seller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);  // Center the frame on the screen
        frame.setVisible(true);
    }
    private void showSellerInventoryScreen() {
        // Implement logic to show Seller Inventory Screen
        sellerInventoryScreenView.setVisible(true);
    }
    private void showFinancialReportsScreen() {
        // Implement logic to show Financial Reports Screen
        financialReportsScreenView.setVisible(true);
    }
    public static void main(String[] args) {
        // Example usage
        new MainScreenSellerView();
    }
}
