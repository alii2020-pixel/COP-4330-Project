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


public class ShoppingCartScreenController {
	private ShoppingCartScreenView view;
	private ShoppingCartScreenModel model;
	
	private List<ProductController> pControllers;
	private ActionListener cartChangedAction;
	
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
	
	private void onBackButtonClick() {
		model.getCustomer().getShoppingCart().removeCartUpdatedListener(cartChangedAction);
		
		MainScreenCustomerView view = new MainScreenCustomerView();
		MainScreenCustomerModel model = new MainScreenCustomerModel(this.model.getCustomer());
		LogoutWrapperController.Instance.changeMVC(model, view, new MainScreenCustomerController(view, model));
	}
	
	private void onCheckoutButtonClick() {
		model.getCustomer().getShoppingCart().removeCartUpdatedListener(cartChangedAction);
		
		PaymentScreenView view = new PaymentScreenView();
		PaymentScreenModel model = new PaymentScreenModel(this.model.getCustomer());
		LogoutWrapperController.Instance.changeMVC(model ,view, new PaymentScreenController(view, model));
	}
	
	private void updatePriceTotalLabelText() {
		view.setPriceTotalLabelText(String.format("Total: $%.2f", model.getCustomer().getShoppingCart().getCartTotal()));
	}
}
