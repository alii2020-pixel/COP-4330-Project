package frontend.Product;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ProductView extends JComponent {
	private JButton incrementButton, decrementButton;
	private JLabel titleLabel, descriptionLabel, priceLabel, countLabel;
	
    public ProductView() {
    	JPanel allContainer = new JPanel();
    	allContainer.setLayout(new BoxLayout(allContainer, BoxLayout.X_AXIS));
    	
    	JPanel buttonPanel = new JPanel();
    	buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
    	
    	incrementButton = new JButton("+1");
    	decrementButton = new JButton("-1");
    	buttonPanel.add(incrementButton);
    	buttonPanel.add(decrementButton);
    	
    	JPanel labelPanel = new JPanel();
    	labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
    	
    	titleLabel = new JLabel("Item Title");
    	descriptionLabel = new JLabel("Item Description");
    	priceLabel = new JLabel("$0.00");
    	countLabel = new JLabel("0 item(s) in cart.");
    	
    	labelPanel.add(titleLabel);
    	labelPanel.add(descriptionLabel);
    	labelPanel.add(priceLabel);
    	labelPanel.add(countLabel);
    	
    	allContainer.add(labelPanel);
    	allContainer.add(buttonPanel);
    	
    	add(allContainer);
    	
    	setLayout(new FlowLayout());
    	setVisible(true);
    }
    
    public void setTitleLabelText(String text) {
    	titleLabel.setText(text);
    }
    
    public void setDescriptionLabelText(String text) {
    	descriptionLabel.setText(text);
    }
    
    public void setPriceLabelText(String text) {
    	priceLabel.setText(text);
    }
    
    public void setCountLabelText(String text) {
    	countLabel.setText(text);
    }
}
