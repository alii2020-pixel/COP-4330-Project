// MainScreenCustomerController.java
// Ethan Curtis

package frontend.MainScreenCustomer;

import frontend.LogoutWrapper.LogoutWrapperController;
import frontend.ShoppingCartScreen.*;

public class MainScreenCustomerController {
	MainScreenCustomerView view;
	MainScreenCustomerModel model;
	
	public MainScreenCustomerController(MainScreenCustomerView view, MainScreenCustomerModel model) {
		this.view = view;
		this.model = model;
		
		view.addShoppingCartButtonListener(e -> onShoppingCartButtonClick());
	}
	
	private void onShoppingCartButtonClick() {
		// navigate to shopping cart page
		
		ShoppingCartScreenView view = new ShoppingCartScreenView();
		ShoppingCartScreenModel model = new ShoppingCartScreenModel();
		LogoutWrapperController.Instance.changeMVC(model, view, new ShoppingCartScreenController(view, model));
	}
}

