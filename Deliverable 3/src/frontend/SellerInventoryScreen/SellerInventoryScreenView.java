// SellerInventoryScreenView.java
// Ethan Curtis

package frontend.SellerInventoryScreen;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.List;
import frontend.ProductSeller.*;

/**
 * Represents the view for the seller's inventory screen.
 * Manages the graphical representation of the seller's inventory, including products and related actions.
 */
public class SellerInventoryScreenView extends JComponent {
	private JButton backButton, addProductButton;
	private JPanel productContainer;
	
	/**
     * Constructs a SellerInventoryScreenView object.
     * Initializes UI components for displaying the seller's inventory and related buttons.
     */
	public SellerInventoryScreenView() {
		JPanel allContainer = new JPanel();
    	allContainer.setLayout(new BorderLayout());
    	
    	productContainer = new JPanel(new GridLayout(0, 3, 10, 10));
    	
    	JPanel buttonContainer = new JPanel();
    	buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.X_AXIS));
    	
    	backButton = new JButton("Back to Main Menu");
    	addProductButton = new JButton("Add Product");
    	
    	buttonContainer.add(backButton);
    	buttonContainer.add(Box.createRigidArea(new Dimension(10, 0)));
    	buttonContainer.add(addProductButton);
    	
    	JScrollPane scrollPane = new JScrollPane(productContainer);
    	scrollPane.setPreferredSize(new Dimension(1100, 600));
    	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	
    	allContainer.add(buttonContainer, BorderLayout.NORTH);
    	allContainer.add(scrollPane);
    	
    	add(allContainer);
    	
    	setLayout(new FlowLayout());
    	setVisible(true);
	}
	
	/**
     * Adds an ActionListener to the back button.
     *
     * @param listener The ActionListener to add to the back button.
     */
	public void addBackButtonListener(ActionListener listener) {
		backButton.addActionListener(listener);
	}
	
	/**
     * Adds an ActionListener to the add product button.
     *
     * @param listener The ActionListener to add to the add product button.
     */
	public void addAddProductButtonListener(ActionListener listener) {
		addProductButton.addActionListener(listener);
	}
	
	/**
     * Removes all product views from the product container.
     */
	public void removeAllProductViews() {
		productContainer.removeAll();
	}
	
	/**
     * Adds a list of ProductSellerView instances to the product container for display.
     *
     * @param productViews The list of ProductSellerView instances to be added.
     */
	public void addProductViews(List<ProductSellerView> productViews) {
		for (ProductSellerView view : productViews) {
			productContainer.add(view);
		}
		revalidate();
		repaint();
	}
}
