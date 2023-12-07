package frontend.ShipmentScreen;

import javax.swing.SwingUtilities;

import frontend.LogoutWrapper.LogoutWrapperController;
import frontend.MainScreenCustomer.*;

/**
 * Controller responsible for managing the Shipment Screen view and model.
 * Handles the shipment details display and navigation back to the home screen.
 */
public class ShipmentScreenController {
    private ShipmentScreenModel model;
    private ShipmentScreenView view;

    /**
     * Constructs a ShipmentScreenController object.
     * Initializes the controller with the associated view and model.
     *
     * @param view  The view component for the shipment screen.
     * @param model The model component for managing shipment-related data.
     */
    public ShipmentScreenController(ShipmentScreenView view, ShipmentScreenModel model) {
        this.model = model;
        this.view = view;

        view.addHomeButtonListener(e -> onHomeButtonClick());
        displayShipmentDetails();
    }

    /**
     * Displays shipment details asynchronously on the view.
     * Invokes the model to load shipment information and updates the view accordingly.
     */
    public void displayShipmentDetails() {
        SwingUtilities.invokeLater(() -> {
            model.loadShipmentInfo();
            view.setShipmentDetails(model.getShipmentInfo());
        });
    }

    /**
     * Handles the action upon clicking the home button.
     * Navigates back to the main customer screen when the home button is clicked.
     */
    private void onHomeButtonClick() {
        // Return to home screen
    	MainScreenCustomerView view = new MainScreenCustomerView();
		MainScreenCustomerModel model = new MainScreenCustomerModel(this.model.getCustomer());
		LogoutWrapperController.Instance.changeMVC(model, view, new MainScreenCustomerController(view, model));
    }
}