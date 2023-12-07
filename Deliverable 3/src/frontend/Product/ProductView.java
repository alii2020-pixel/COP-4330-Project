// ProductView.java
// Ethan Curtis

package frontend.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Represents the view for an individual product in the application.
 * Allows users to view product details and manipulate the quantity in their cart.
 */
public class ProductView extends JComponent {
	private JButton incrementButton, decrementButton;
	private JLabel titleLabel, descriptionLabel, priceLabel, countLabel;
	
	/**
     * Constructs a ProductView object, initializing the UI components for displaying product details
     * and quantity manipulation buttons.
     */
    public ProductView() {
    	JPanel allContainer = new JPanel();
    	allContainer.setLayout(new BorderLayout());
    	
    	JPanel buttonPanel = new JPanel();
    	buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    	
    	incrementButton = new JButton("+1");
    	decrementButton = new JButton("-1");
    	buttonPanel.add(incrementButton);
    	buttonPanel.add(decrementButton);
    	
    	JPanel labelPanel = new JPanel();
    	labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
    	labelPanel.setPreferredSize(new Dimension(200, 100));
    	
    	titleLabel = new JLabel("Item Title");
    	descriptionLabel = new JLabel("Item Description");
    	priceLabel = new JLabel("$0.00");
    	countLabel = new JLabel("0 item(s) in cart.");
    	
    	labelPanel.add(titleLabel);
    	labelPanel.add(descriptionLabel);
    	labelPanel.add(priceLabel);
    	labelPanel.add(countLabel);
    	
    	allContainer.add(labelPanel);
    	allContainer.add(buttonPanel, BorderLayout.EAST);
    	
    	add(allContainer);
    	
    	setLayout(new FlowLayout());
    	setVisible(true);
    }
    
    /**
     * Sets the text for the title label displaying the product title.
     *
     * @param text The text to be displayed as the product title.
     */
    public void setTitleLabelText(String text) {
    	titleLabel.setText(text);
    }
    
    /**
     * Sets the text for the description label displaying the product description.
     *
     * @param text The text to be displayed as the product description.
     */
    public void setDescriptionLabelText(String text) {
    	descriptionLabel.setText(text);
    }
    
    /**
     * Sets the text for the price label displaying the product price.
     *
     * @param text The text to be displayed as the product price.
     */
    public void setPriceLabelText(String text) {
    	priceLabel.setText(text);
    }
    
    /**
     * Sets the text for the count label displaying the quantity of the product in the cart.
     *
     * @param text The text to be displayed as the product quantity in the cart.
     */
    public void setCountLabelText(String text) {
    	countLabel.setText(text);
    }
    
    /**
     * Adds an ActionListener for the increment button to increase the product quantity in the cart.
     *
     * @param listener ActionListener to be added to the increment button.
     */
    public void addIncrementButtonListener(ActionListener listener) {
    	incrementButton.addActionListener(listener);
    }
    
    /**
     * Adds an ActionListener for the decrement button to decrease the product quantity in the cart.
     *
     * @param listener ActionListener to be added to the decrement button.
     */
    public void addDecrementButtonListener(ActionListener listener) {
    	decrementButton.addActionListener(listener);
    }
}
