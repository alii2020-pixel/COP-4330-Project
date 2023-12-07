// SellerInventoryScreenController.java
// Ethan Curtis

package frontend.SellerInventoryScreen;

import common.Product;
import frontend.LogoutWrapper.LogoutWrapperController;
import frontend.MainScreenSeller.*;
import java.util.*;
import frontend.ProductSeller.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controls interactions between the SellerInventoryScreenView and SellerInventoryScreenModel.
 * Manages the behavior and actions related to the seller's inventory screen.
 */
public class SellerInventoryScreenController {
    private SellerInventoryScreenModel model;
    private SellerInventoryScreenView view;
    private List<ProductSellerController> pControllers;
    
    /**
     * Constructs a SellerInventoryScreenController object.
     * Initializes the controller with the associated view and model.
     *
     * @param view  The SellerInventoryScreenView to be controlled.
     * @param model The SellerInventoryScreenModel to be managed.
     */
    public SellerInventoryScreenController(SellerInventoryScreenView view, SellerInventoryScreenModel model) {
        this.model = model;
        this.view = view;
        
        pControllers = new LinkedList<ProductSellerController>();
        
        view.addBackButtonListener(e -> onBackButtonClick());
        view.addAddProductButtonListener(e -> onAddProductButtonClick());
        
        updateProductViews();
    }
    
    /**
     * Handles the action when the back button is clicked.
     * Navigates back to the MainScreenSeller view and model.
     */
    private void onBackButtonClick() {
    	// back to MainScreenSeller
    	
    	MainScreenSellerView view = new MainScreenSellerView();
    	MainScreenSellerModel model = new MainScreenSellerModel(this.model.getSeller());
    	LogoutWrapperController.Instance.changeMVC(model, view, new MainScreenSellerController(view, model));
    }
    
    /**
     * Handles the action when the add product button is clicked.
     * Creates a new product and adds it to the seller's inventory.
     */
    private void onAddProductButtonClick() {
    	Product product = new Product();
    	
    	model.getSeller().addProduct(product);
    	
    	updateProductViews();
    }
    
    /**
     * Updates the product views in the SellerInventoryScreenView based on the SellerInventoryScreenModel.
     * Refreshes the displayed list of products in the seller's inventory.
     */
    private void updateProductViews() {
    	view.removeAllProductViews();
    	
    	List<ProductSellerView> views = new LinkedList<>();
    	
    	for (Product product : model.getSeller().getProducts()) {
    		ProductSellerView pView = new ProductSellerView();
    		views.add(pView);
    		
    		pView.setTitleFieldText(product.getName());
    		pView.setDescriptionFieldText(product.getDescription());
    		pView.setPriceFieldText(product.getPrice());
    		
    		pView.addDeleteProductButtonListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					model.getSeller().removeProduct(product);
					updateProductViews();
				}
    		});
    		
    		ProductSellerModel pModel = new ProductSellerModel(product);
    		
    		ProductSellerController pController = new ProductSellerController(pView, pModel);
    		pControllers.add(pController);
    	}
    	
    	view.addProductViews(views);
    }
}
