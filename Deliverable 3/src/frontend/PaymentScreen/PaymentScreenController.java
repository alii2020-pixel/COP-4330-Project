// PaymentScreenController.java

package frontend.PaymentScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import frontend.LogoutWrapper.LogoutWrapperController;
import frontend.ShipmentScreen.*;

public class PaymentScreenController {
    private PaymentScreenView view;
    private PaymentScreenModel model;
    
    public PaymentScreenController(PaymentScreenView view, PaymentScreenModel model) {
        this.view = view;
        this.model = model;
        
        // Set up the submit button listener
        view.setSubmitButtonListener(new SubmitButtonListener());
        
        view.setTotalCostLabelText(String.format("Total cost: $%.2f", model.getCustomer().getShoppingCart().getCartTotal()));
    }
    
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
    
    private void switchToShipmentScreen() {
    	ShipmentScreenView view = new ShipmentScreenView();
    	ShipmentScreenModel model = new ShipmentScreenModel(this.model.getCustomer());
    	LogoutWrapperController.Instance.changeMVC(model, view, new ShipmentScreenController(view, model));
    }
}

