// MainScreenCustomerView.java
// Ethan Curtis

package frontend.MainScreenCustomer;

import javax.swing.*;
import frontend.Product.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Represents the view component for the main screen of a customer.
 */
public class MainScreenCustomerView extends JComponent {
	private JPanel productContainer;
	private JButton shoppingCartButton;
	
	/**
	 * Constructs the MainScreenCustomerView with components for displaying products and a shopping cart button.
	 */
    public MainScreenCustomerView() {
    	JPanel allContainer = new JPanel();
    	allContainer.setLayout(new BorderLayout());
    	
    	productContainer = new JPanel(new GridLayout(0, 3, 10, 10));
    	
    	shoppingCartButton = new JButton("View Shopping Cart");
    	
    	JScrollPane scrollPane = new JScrollPane(productContainer);
    	scrollPane.setPreferredSize(new Dimension(1100, 600));
    	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	
    	allContainer.add(shoppingCartButton, BorderLayout.NORTH);
    	allContainer.add(scrollPane);
    	
    	add(allContainer);
    	
    	setLayout(new FlowLayout());
    	setVisible(true);
    }
    
    /**
     * Adds a single product view to the product container panel.
     *
     * @param productView The product view to be added.
     */
    public void addProductView(ProductView productView) {
    	productContainer.add(productView);
    	revalidate();
    	repaint();
    }
    
    /**
     * Adds multiple product views to the product container panel.
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
     * Clears the product container panel, removing all product views.
     */
    public void resetProductContainer() {
    	productContainer.removeAll();
    }
    
    /**
     * Adds an ActionListener to the shopping cart button.
     *
     * @param listener The ActionListener to be added to the shopping cart button.
     */
    public void addShoppingCartButtonListener(ActionListener listener) {
    	shoppingCartButton.addActionListener(listener);
    }
}
