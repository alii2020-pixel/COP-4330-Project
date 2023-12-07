package frontend.ShoppingCartScreen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import frontend.Product.ProductView;

public class ShoppingCartScreenView extends JComponent {
	private JPanel productContainer;
	private JButton backButton, checkoutButton;
	private JLabel priceTotalLabel;
	
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
    
    public void addBackButtonListener(ActionListener listener) {
    	backButton.addActionListener(listener);
    }
    
    public void setPriceTotalLabelText(String text) {
    	priceTotalLabel.setText(text);
    }
}
