package frontend.ShipmentScreen;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ShipmentScreenView extends JPanel {
    private JTextArea shipmentDetailsTextArea;
    private JButton homeButton;

    public ShipmentScreenView() {
        shipmentDetailsTextArea = new JTextArea(10, 20);
        shipmentDetailsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(shipmentDetailsTextArea);
        
        homeButton = new JButton("Home");

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(homeButton, BorderLayout.SOUTH);
    }

    public void setShipmentDetails(String details) {
        shipmentDetailsTextArea.setText(details);
    }

    public void addHomeButtonListener(ActionListener listener) {
        homeButton.addActionListener(listener);
    }
}
