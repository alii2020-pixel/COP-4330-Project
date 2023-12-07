// MainScreenCustomerController.java
// Ethan Curtis

package frontend.MainScreenCustomer;

import java.util.*;
import common.*;
import frontend.LogoutWrapper.LogoutWrapperController;
import frontend.ShoppingCartScreen.*;
import frontend.Product.*;

public class MainScreenCustomerController {
	private MainScreenCustomerView view;
	private MainScreenCustomerModel model;
	
	private List<ProductController> pControllers;
	
	public MainScreenCustomerController(MainScreenCustomerView view, MainScreenCustomerModel model) {
		this.view = view;
		this.model = model;
		
		List<ProductView> views = new LinkedList<ProductView>();
		pControllers = new LinkedList<ProductController>();
		
		for (Product product : model.getProducts()) {
			ProductView pView = new ProductView();
			views.add(pView);
			
			pView.setTitleLabelText(product.getName());
			pView.setDescriptionLabelText(product.getDescription());
			pView.setPriceLabelText(String.format("$%.2f", product.getPrice()));
			
			ProductModel pModel = new ProductModel(product, model.getShoppingCart());
			
			pView.setCountLabelText(Integer.toString(pModel.getCount()) + " item(s) in cart.");
			
			ProductController pController = new ProductController(pView, pModel);
			pControllers.add(pController);
		}
		
		view.addProductViews(views);
		
		view.addShoppingCartButtonListener(e -> onShoppingCartButtonClick());
	}
	
	private void onShoppingCartButtonClick() {
		// navigate to shopping cart page
		
		ShoppingCartScreenView view = new ShoppingCartScreenView();
		ShoppingCartScreenModel model = new ShoppingCartScreenModel(this.model.getShoppingCart());
		LogoutWrapperController.Instance.changeMVC(model, view, new ShoppingCartScreenController(view, model));
	}
}

