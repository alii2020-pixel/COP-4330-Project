package frontend.PaymentScreen;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComponent;
import java.awt.event.ActionListener;

/**
 * Represents the payment screen view for the application.
 * Allows users to input payment information for their purchase.
 */
public class PaymentScreenView extends JComponent {
    private JTextField cardNumberField, expiryDateField, cvvField;
    private JButton submitButton;
    private JLabel totalCostLabel;
    
    /**
     * Constructs a PaymentScreenView object, initializing the UI components.
     * Creates fields to input card details and a button to submit the payment.
     */
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

    /**
     * Retrieves the card number entered by the user.
     *
     * @return The entered card number as a string.
     */
    public String getCardNumber() {
        return cardNumberField.getText();
    }
    
    /**
     * Retrieves the expiry date entered by the user.
     *
     * @return The entered expiry date as a string in "MM/YY" format.
     */
    public String getExpiryDate() {
        return expiryDateField.getText();
    }
    
    /**
     * Retrieves the CVV entered by the user.
     *
     * @return The entered CVV as a string.
     */
    public String getCVV() {
        return cvvField.getText();
    }
    
    /**
     * Sets an ActionListener for the submit button.
     *
     * @param listener ActionListener to be set for the submit button.
     */
    public void setSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }
    
    /**
     * Sets the label text displaying the total cost to be paid.
     *
     * @param text The text to be displayed as the total cost.
     */
    public void setTotalCostLabelText(String text) {
    	totalCostLabel.setText(text);
    }
}


