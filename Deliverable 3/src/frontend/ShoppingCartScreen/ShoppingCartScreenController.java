// ShoppingCartScreenController.java
// Ethan Curtis

package frontend.ShoppingCartScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import common.Product;
import frontend.Product.*;
import frontend.LogoutWrapper.LogoutWrapperController;
import frontend.MainScreenCustomer.*;
import frontend.PaymentScreen.*;

/**
 * Controls the interactions between the ShoppingCartScreenView and ShoppingCartScreenModel.
 * Manages the display of products in the shopping cart, handles cart changes, and navigation options.
 */
public class ShoppingCartScreenController {
	private ShoppingCartScreenView view;
	private ShoppingCartScreenModel model;
	private List<ProductController> pControllers;
	private ActionListener cartChangedAction;
	
	/**
     * Constructs a ShoppingCartScreenController.
     * Initializes the view, model, and sets up listeners for cart updates and navigation buttons.
     *
     * @param view  The view representing the shopping cart screen.
     * @param model The model containing shopping cart information.
     */
	public ShoppingCartScreenController(ShoppingCartScreenView view, ShoppingCartScreenModel model) {
		this.view = view;
		this.model = model;
		
		List<ProductView> views = new LinkedList<ProductView>();
		pControllers = new LinkedList<ProductController>();
		
		for (Product product : model.getCustomer().getShoppingCart().getProducts()) {
			ProductView pView = new ProductView();
			views.add(pView);
			
			pView.setTitleLabelText(product.getName());
			pView.setDescriptionLabelText(product.getDescription());
			pView.setPriceLabelText(String.format("$%.2f", product.getPrice()));
			
			ProductModel pModel = new ProductModel(product, model.getCustomer().getShoppingCart());
			
			pView.setCountLabelText(Integer.toString(pModel.getCount()) + " item(s) in cart.");
			
			ProductController pController = new ProductController(pView, pModel);
			pControllers.add(pController);
		}
		
		view.addProductViews(views);
		
		view.addBackButtonListener(e -> onBackButtonClick());
		view.addCheckoutButtonListener(e -> onCheckoutButtonClick());
		
		cartChangedAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updatePriceTotalLabelText();
			}
		};
		model.getCustomer().getShoppingCart().addCartUpdatedListener(cartChangedAction);
		
		updatePriceTotalLabelText();
	}
	
	/**
     * Handles the action when the back button is clicked.
     * Removes the cart update listener and navigates back to the main customer screen.
     */
	private void onBackButtonClick() {
		model.getCustomer().getShoppingCart().removeCartUpdatedListener(cartChangedAction);
		
		MainScreenCustomerView view = new MainScreenCustomerView();
		MainScreenCustomerModel model = new MainScreenCustomerModel(this.model.getCustomer());
		LogoutWrapperController.Instance.changeMVC(model, view, new MainScreenCustomerController(view, model));
	}
	
	/**
     * Handles the action when the checkout button is clicked.
     * Removes the cart update listener and navigates to the payment screen.
     */
	private void onCheckoutButtonClick() {
		model.getCustomer().getShoppingCart().removeCartUpdatedListener(cartChangedAction);
		
		PaymentScreenView view = new PaymentScreenView();
		PaymentScreenModel model = new PaymentScreenModel(this.model.getCustomer());
		LogoutWrapperController.Instance.changeMVC(model ,view, new PaymentScreenController(view, model));
	}
	
	/**
     * Updates the total price label text on the shopping cart screen.
     * Displays the current total price of items in the cart.
     */
	private void updatePriceTotalLabelText() {
		view.setPriceTotalLabelText(String.format("Total: $%.2f", model.getCustomer().getShoppingCart().getCartTotal()));
	}
}
