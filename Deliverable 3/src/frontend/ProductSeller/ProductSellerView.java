// ProductSellerView.java
// Ethan Curtis

package frontend.ProductSeller;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 * Represents the view for a product within the context of a seller.
 * Manages the graphical representation of the product details in the seller's view.
 */
public class ProductSellerView extends JComponent {
	private JTextField titleField, descriptionField, priceField;
	private JButton deleteProductButton;
	
	/**
     * Constructs a ProductSellerView object.
     * Initializes UI components for displaying and editing product details.
     */
	public ProductSellerView() {
		JPanel allContainer = new JPanel();
    	allContainer.setLayout(new BorderLayout());
    	
    	titleField = new JTextField();
    	descriptionField = new JTextField();
    	priceField = new JTextField();
    	
    	deleteProductButton = new JButton("Delete product");
    	
    	JPanel labelPanel = new JPanel();
    	labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
    	labelPanel.setPreferredSize(new Dimension(200, 100));
    	
    	labelPanel.add(titleField);
    	labelPanel.add(descriptionField);
    	labelPanel.add(priceField);
    	
    	allContainer.add(labelPanel);
    	allContainer.add(deleteProductButton, BorderLayout.EAST);
    	
    	add(allContainer);
    	
    	setLayout(new FlowLayout());
    	setVisible(true);
	}
	
	/**
     * Retrieves the text entered in the title field.
     *
     * @return The text in the title field.
     */
	public String getTitleFieldText() {
		return titleField.getText();
	}
	
	/**
     * Retrieves the text entered in the description field.
     *
     * @return The text in the description field.
     */
	public String getDescriptionFieldText() {
		return descriptionField.getText();
	}
	
	/**
     * Retrieves the text entered in the price field.
     *
     * @return The text in the price field.
     */
	public String getPriceFieldText() {
		return priceField.getText();
	}
	
	/**
     * Sets the text displayed in the title field.
     *
     * @param title The text to set in the title field.
     */
	public void setTitleFieldText(String title) {
		titleField.setText(title);
	}

	/**
     * Sets the text displayed in the description field.
     *
     * @param description The text to set in the description field.
     */
	public void setDescriptionFieldText(String description) {
		descriptionField.setText(description);
	}

	/**
     * Sets the text displayed in the price field.
     *
     * @param price The price to set in the price field.
     */
	public void setPriceFieldText(double price) {
		priceField.setText(String.format("%.2f", price));
	}

	/**
     * Adds a key listener to the title field.
     *
     * @param listener The KeyListener to add to the title field.
     */
	public void addTitleFieldListener(KeyListener listener) {
		titleField.addKeyListener(listener);
	}
	
	/**
     * Adds a key listener to the description field.
     *
     * @param listener The KeyListener to add to the description field.
     */
	public void addDescriptionFieldListener(KeyListener listener) {
		descriptionField.addKeyListener(listener);
	}
	
	/**
     * Adds a key listener to the price field.
     *
     * @param listener The KeyListener to add to the price field.
     */
	public void addPriceFieldListener(KeyListener listener) {
		priceField.addKeyListener(listener);
	}
	
	/**
     * Adds an action listener to the delete product button.
     *
     * @param listener The ActionListener to add to the delete product button.
     */
	public void addDeleteProductButtonListener(ActionListener listener) {
		deleteProductButton.addActionListener(listener);
	}
}
