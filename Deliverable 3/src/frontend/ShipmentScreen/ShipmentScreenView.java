package frontend.ShipmentScreen;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Represents the graphical view for the shipment screen.
 * Displays shipment details and provides a button to navigate back to the home screen.
 */
public class ShipmentScreenView extends JPanel {
    private JTextArea shipmentDetailsTextArea;
    private JButton homeButton;

    /**
     * Constructs a ShipmentScreenView object.
     * Sets up the graphical components, such as a text area to display shipment details and a button to navigate home.
     */
    public ShipmentScreenView() {
        shipmentDetailsTextArea = new JTextArea(10, 20);
        shipmentDetailsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(shipmentDetailsTextArea);
        
        homeButton = new JButton("Home");

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(homeButton, BorderLayout.SOUTH);
    }

    /**
     * Sets the displayed shipment details in the text area.
     *
     * @param details The shipment details to be displayed.
     */
    public void setShipmentDetails(String details) {
        shipmentDetailsTextArea.setText(details);
    }

    /**
     * Adds an ActionListener to the home button.
     * Invokes the provided ActionListener when the home button is clicked.
     *
     * @param listener The ActionListener to be added to the home button.
     */
    public void addHomeButtonListener(ActionListener listener) {
        homeButton.addActionListener(listener);
    }
}
