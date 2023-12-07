package frontend.PaymentScreen;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComponent;
import java.awt.event.ActionListener;

public class PaymentScreenView extends JComponent {
    private JTextField cardNumberField;
    private JTextField expiryDateField;
    private JTextField cvvField;
    private JButton submitButton;
    public PaymentScreenView() {
        initUI();
    }
    private void initUI() {
        // Set up UI elements
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Card Number:"));
        cardNumberField = new JTextField(16);
        panel.add(cardNumberField);
        panel.add(new JLabel("Expiry Date:"));
        expiryDateField = new JTextField(5);
        panel.add(expiryDateField);
        panel.add(new JLabel("CVV:"));
        cvvField = new JTextField(3);
        panel.add(cvvField);
        submitButton = new JButton("Submit");
        panel.add(submitButton);
        // No need to set up the frame as JComponent does not have one
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
}


