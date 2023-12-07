// SellerInventoryScreenView.java
// Ethan Curtis

package frontend.SellerInventoryScreen;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.List;
import frontend.ProductSeller.*;

public class SellerInventoryScreenView extends JComponent {
	private JButton backButton, addProductButton;
	private JPanel productContainer;
	
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
    	
    	allContainer.add(buttonContainer, BorderLayout.NORTH);
    	allContainer.add(productContainer);
    	
    	add(allContainer);
    	
    	setLayout(new FlowLayout());
    	setVisible(true);
	}
	
	public void addBackButtonListener(ActionListener listener) {
		backButton.addActionListener(listener);
	}
	
	public void addAddProductButtonListener(ActionListener listener) {
		addProductButton.addActionListener(listener);
	}
	
	public void removeAllProductViews() {
		productContainer.removeAll();
	}
	
	public void addProductViews(List<ProductSellerView> productViews) {
		for (ProductSellerView view : productViews) {
			productContainer.add(view);
		}
		revalidate();
		repaint();
	}
}
