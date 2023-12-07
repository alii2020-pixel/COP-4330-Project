// PaymentScreenController.java

package frontend.PaymentScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import frontend.LogoutWrapper.LogoutWrapperController;
import frontend.ShipmentScreen.*;

/**
 * Controls the payment screen functionality, managing interactions between the view and model.
 */
public class PaymentScreenController {
    private PaymentScreenView view;
    private PaymentScreenModel model;
    
    /**
     * Constructs a PaymentScreenController with the associated view and model.
     *
     * @param view  The view component for the payment screen.
     * @param model The model containing data and functionality for payment processing.
     */
    public PaymentScreenController(PaymentScreenView view, PaymentScreenModel model) {
        this.view = view;
        this.model = model;
        
        // Set up the submit button listener
        view.setSubmitButtonListener(new SubmitButtonListener());
        
        view.setTotalCostLabelText(String.format("Total cost: $%.2f", model.getCustomer().getShoppingCart().getCartTotal()));
    }
    
    /**
     * ActionListener implementation for the submit button on the payment screen.
     * Handles payment verification and transaction processing.
     */
    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Retrieve data from the view
            String cardNumber = view.getCardNumber();
            String expiryDate = view.getExpiryDate();
            String cvv = view.getCVV();
            // Verify payment details
            boolean paymentDetailsVerified = model.verifyPaymentDetails(cardNumber, expiryDate, cvv);
            if (paymentDetailsVerified) {
                // Process transaction
                boolean transactionSuccess = model.processTransaction();
                if (transactionSuccess) {
                    JOptionPane.showMessageDialog(view, "Payment successful!");
                    
                    model.getCustomer().getShoppingCart().removeAllProducts();
                    
                    switchToShipmentScreen();
                } else {
                    JOptionPane.showMessageDialog(view, "Transaction failed. Please try again.");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Invalid payment details. Please check and try again.");
            }
        }
    }
    
    /**
     * Switches the view to the shipment screen after successful payment processing.
     */
    private void switchToShipmentScreen() {
    	ShipmentScreenView view = new ShipmentScreenView();
    	ShipmentScreenModel model = new ShipmentScreenModel(this.model.getCustomer());
    	LogoutWrapperController.Instance.changeMVC(model, view, new ShipmentScreenController(view, model));
    }
}

