package frontend.PaymentScreen;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComponent;
import java.awt.event.ActionListener;

public class PaymentScreenView extends JComponent {
    private JTextField cardNumberField, expiryDateField, cvvField;
    private JButton submitButton;
    private JLabel totalCostLabel;
    
    public PaymentScreenView() {
    	JPanel allContainer = new JPanel(new GridLayout(2, 1, 10, 10));
    	
    	totalCostLabel = new JLabel("Total cost: $0.00");
    	allContainer.add(totalCostLabel);
    	
        JPanel creditCardInfoPanel = new JPanel(new FlowLayout());
        creditCardInfoPanel.add(new JLabel("Card Number:"));
        cardNumberField = new JTextField(16);
        creditCardInfoPanel.add(cardNumberField);
        creditCardInfoPanel.add(new JLabel("Expiry Date:"));
        expiryDateField = new JTextField(5);
        creditCardInfoPanel.add(expiryDateField);
        creditCardInfoPanel.add(new JLabel("CVV:"));
        cvvField = new JTextField(3);
        creditCardInfoPanel.add(cvvField);
        submitButton = new JButton("Submit");
        creditCardInfoPanel.add(submitButton);
        
        allContainer.add(creditCardInfoPanel);
        
        add(allContainer);
        setLayout(new FlowLayout());
        setVisible(true);
    }

    public String getCardNumber() {
        return cardNumberField.getText();
    }
    
    public String getExpiryDate() {
        return expiryDateField.getText();
    }
    
    public String getCVV() {
        return cvvField.getText();
    }
    
    public void setSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }
    
    public void setTotalCostLabelText(String text) {
    	totalCostLabel.setText(text);
    }
}


