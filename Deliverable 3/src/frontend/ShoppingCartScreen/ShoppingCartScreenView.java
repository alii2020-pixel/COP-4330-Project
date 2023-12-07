// ShoppingCartScreenView.java
// Ethan Curtis

package frontend.ShoppingCartScreen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import frontend.Product.ProductView;

/**
 * Represents the view for the shopping cart screen.
 * Displays the list of products in the shopping cart and provides options for navigation and checkout.
 */
public class ShoppingCartScreenView extends JComponent {
	private JPanel productContainer;
	private JButton backButton, checkoutButton;
	private JLabel priceTotalLabel;
	
	/**
     * Constructs a ShoppingCartScreenView and initializes its components.
     * Sets up the layout and components for displaying products, navigation buttons, and the total price label.
     */
    public ShoppingCartScreenView() {
    	JPanel allContainer = new JPanel();
    	allContainer.setLayout(new BorderLayout());
    	
    	productContainer = new JPanel(new GridLayout(0, 3, 10, 10));
    	
    	backButton = new JButton("Back to Main Menu");
    	
    	JPanel checkoutContainer = new JPanel(new BorderLayout());
    	
    	checkoutButton = new JButton("Proceed to Checkout");
    	priceTotalLabel = new JLabel("Total: $0.00");
    	
    	checkoutContainer.add(priceTotalLabel, BorderLayout.NORTH);
    	checkoutContainer.add(checkoutButton);
    	
    	JScrollPane scrollPane = new JScrollPane(productContainer);
    	scrollPane.setPreferredSize(new Dimension(1100, 400));
    	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	
    	allContainer.add(backButton, BorderLayout.NORTH);
    	allContainer.add(checkoutContainer, BorderLayout.SOUTH);
    	allContainer.add(scrollPane);
    	
    	add(allContainer);
    	
    	setLayout(new FlowLayout());
    	setVisible(true);
    }
    
    /**
     * Adds a single product view to the product container.
     *
     * @param productView The view of the product to be added.
     */
    public void addProductView(ProductView productView) {
    	productContainer.add(productView);
    	revalidate();
    	repaint();
    }
    
    /**
     * Adds multiple product views to the product container.
     *
     * @param productViews The list of product views to be added.
     */
    public void addProductViews(List<ProductView> productViews) {
    	for (ProductView view : productViews) {
    		productContainer.add(view);
    	}
    	revalidate();
    	repaint();
    }
    
    /**
     * Removes all products from the product container.
     */
    public void resetProductContainer() {
    	productContainer.removeAll();
    }
    
    /**
     * Adds a listener for the back button.
     *
     * @param listener The ActionListener for the back button.
     */
    public void addBackButtonListener(ActionListener listener) {
    	backButton.addActionListener(listener);
    }
    
    /**
     * Adds a listener for the checkout button.
     *
     * @param listener The ActionListener for the checkout button.
     */
    public void addCheckoutButtonListener(ActionListener listener) {
    	checkoutButton.addActionListener(listener);
    }
    
    /**
     * Sets the text for the price total label.
     *
     * @param text The text to be set for the price total label.
     */
    public void setPriceTotalLabelText(String text) {
    	priceTotalLabel.setText(text);
    }
}
