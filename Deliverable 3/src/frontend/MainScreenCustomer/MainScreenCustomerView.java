// MainScreenCustomerView.java
// Ethan Curtis

package frontend.MainScreenCustomer;

import javax.swing.*;
import frontend.Product.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class MainScreenCustomerView extends JComponent {
	private JPanel productContainer;
	private JButton shoppingCartButton;
	
    public MainScreenCustomerView() {
    	JPanel allContainer = new JPanel();
    	allContainer.setLayout(new BoxLayout(allContainer, BoxLayout.X_AXIS));
    	
    	productContainer = new JPanel();
    	productContainer.setLayout(new BoxLayout(productContainer, BoxLayout.Y_AXIS));
    	
    	shoppingCartButton = new JButton("SHOPPING CART");
    	
    	allContainer.add(productContainer);
    	allContainer.add(shoppingCartButton);
    	
    	add(allContainer);
    	
    	setLayout(new FlowLayout());
    	setVisible(true);
    }
    
    public void addProductView(ProductView productView) {
    	productContainer.add(productView);
    	revalidate();
    	repaint();
    }
    
    public void addProductViews(List<ProductView> productViews) {
    	for (ProductView view : productViews) {
    		productContainer.add(view);
    	}
    	revalidate();
    	repaint();
    }
    
    public void resetProductContainer() {
    	productContainer.removeAll();
    }
    
    public void addShoppingCartButtonListener(ActionListener listener) {
    	shoppingCartButton.addActionListener(listener);
    }
}
