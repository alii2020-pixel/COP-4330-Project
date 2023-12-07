// MainScreenSellerController.java
// Brandon Christian, Ethan Curtis

package frontend.MainScreenSeller;

import frontend.LogoutWrapper.LogoutWrapperController;
import frontend.SellerInventoryScreen.*;
import frontend.FinancialReportsScreen.*;

/**
 * Controls the functionality of the main screen for sellers, handling interactions between the view and model.
 */
public class MainScreenSellerController {
    private MainScreenSellerView view;
    private MainScreenSellerModel model;
	
    /**
     * Constructs a MainScreenSellerController with the associated MainScreenSellerView and MainScreenSellerModel.
     *
     * @param view  The view component for the main screen of sellers.
     * @param model The model containing data and functionality for the main screen of sellers.
     */
	public MainScreenSellerController(MainScreenSellerView view, MainScreenSellerModel model) {
		this.view = view;
		this.model = model;
		
		view.addSellerInventoryButtonListener(e -> onSellerInventoryButtonClick());
		view.addFinancialReportsButtonListener(e -> onFinancialReportsButtonClick());
    }
	
	/**
     * Handles the action when the seller inventory button is clicked.
     * Navigates to the seller inventory screen.
     */
	private void onSellerInventoryButtonClick() {
		// open seller inventory screen
		SellerInventoryScreenView view = new SellerInventoryScreenView();
		SellerInventoryScreenModel model = new SellerInventoryScreenModel(this.model.getSeller());
		LogoutWrapperController.Instance.changeMVC(model, view, new SellerInventoryScreenController(view, model));
	}
	
	/**
     * Handles the action when the financial reports button is clicked.
     * Navigates to the financial reports screen.
     */
	private void onFinancialReportsButtonClick() {
		// open financial reports screen
		FinancialReportsScreenView view = new FinancialReportsScreenView();
		FinancialReportsScreenModel model = new FinancialReportsScreenModel(this.model.getSeller());
		LogoutWrapperController.Instance.changeMVC(model, view, new FinancialReportsScreenController(view, model));
	}
}