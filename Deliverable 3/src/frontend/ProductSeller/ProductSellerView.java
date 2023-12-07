package frontend.ProductSeller;

import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

public class ProductSellerView extends JComponent {
	private JTextField titleField, descriptionField, priceField;
	private JButton deleteProductButton;
	
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
	
	public void setTitleFieldText(String title) {
		titleField.setText(title);
	}

	public void setDescriptionFieldText(String description) {
		descriptionField.setText(description);
	}

	public void setPriceFieldText(double price) {
		priceField.setText(String.format("%.2f", price));
	}

	public void addTitleFieldListener(ActionListener listener) {
		titleField.addActionListener(listener);
	}
	
	public void addDescriptionFieldListener(ActionListener listener) {
		descriptionField.addActionListener(listener);
	}
	
	public void addPriceFieldListener(ActionListener listener) {
		priceField.addActionListener(listener);
	}
	
	public void addDeleteProductButtonListener(ActionListener listener) {
		deleteProductButton.addActionListener(listener);
	}
}
