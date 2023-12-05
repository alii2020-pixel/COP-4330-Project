package frontend.ShipmentScreen;

import javax.swing.SwingUtilities;

public class ShipmentScreenController {
    private ShipmentScreenModel model;
    private ShipmentScreenView view;

    public ShipmentScreenController(ShipmentScreenModel model, ShipmentScreenView view) {
        this.model = model;
        this.view = view;

        view.addHomeButtonListener(e -> onHomeButtonClick());
    }

    public void displayShipmentDetails() {
        SwingUtilities.invokeLater(() -> {
            model.loadShipmentInfo();
            view.setShipmentDetails(model.getShipmentInfo());
        });
    }

    private void onHomeButtonClick() {
        // Return to home screen
        System.out.println("Displaying home screen");
    }
}