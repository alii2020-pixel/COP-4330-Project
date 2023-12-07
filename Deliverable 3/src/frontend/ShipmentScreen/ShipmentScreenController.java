package frontend.ShipmentScreen;

import javax.swing.SwingUtilities;

import frontend.LogoutWrapper.LogoutWrapperController;
import frontend.MainScreenCustomer.*;

public class ShipmentScreenController {
    private ShipmentScreenModel model;
    private ShipmentScreenView view;

    public ShipmentScreenController(ShipmentScreenView view, ShipmentScreenModel model) {
        this.model = model;
        this.view = view;

        view.addHomeButtonListener(e -> onHomeButtonClick());
        displayShipmentDetails();
    }

    public void displayShipmentDetails() {
        SwingUtilities.invokeLater(() -> {
            model.loadShipmentInfo();
            view.setShipmentDetails(model.getShipmentInfo());
        });
    }

    private void onHomeButtonClick() {
        // Return to home screen
    	MainScreenCustomerView view = new MainScreenCustomerView();
		MainScreenCustomerModel model = new MainScreenCustomerModel(this.model.getCustomer());
		LogoutWrapperController.Instance.changeMVC(model, view, new MainScreenCustomerController(view, model));
    }
}