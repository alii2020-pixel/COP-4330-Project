// MainScreenSellerController.java
// Brandon Christian, Ethan Curtis

package frontend.MainScreenSeller;

import frontend.LogoutWrapper.LogoutWrapperController;
import frontend.SellerInventoryScreen.*;
import frontend.FinancialReportsScreen.*;

public class MainScreenSellerController {
    private MainScreenSellerView view;
    private MainScreenSellerModel model;
	
	public MainScreenSellerController(MainScreenSellerView view, MainScreenSellerModel model) {
		this.view = view;
		this.model = model;
		
		view.addSellerInventoryButtonListener(e -> onSellerInventoryButtonClick());
		view.addFinancialReportsButtonListener(e -> onFinancialReportsButtonClick());
    }
	
	private void onSellerInventoryButtonClick() {
		// open seller inventory screen
		SellerInventoryScreenView view = new SellerInventoryScreenView();
		SellerInventoryScreenModel model = new SellerInventoryScreenModel(this.model.getSeller());
		LogoutWrapperController.Instance.changeMVC(model, view, new SellerInventoryScreenController(view, model));
	}
	
	private void onFinancialReportsButtonClick() {
		// open financial reports screen
		FinancialReportsScreenView view = new FinancialReportsScreenView();
		FinancialReportsScreenModel model = new FinancialReportsScreenModel(this.model.getSeller());
		LogoutWrapperController.Instance.changeMVC(model, view, new FinancialReportsScreenController(view, model));
	}
}