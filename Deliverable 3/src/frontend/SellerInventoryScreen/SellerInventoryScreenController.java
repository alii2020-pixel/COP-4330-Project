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

public class SellerInventoryScreenController {
    private SellerInventoryScreenModel model;
    private SellerInventoryScreenView view;
    
    private List<ProductSellerController> pControllers;
    
    public SellerInventoryScreenController(SellerInventoryScreenView view, SellerInventoryScreenModel model) {
        this.model = model;
        this.view = view;
        
        pControllers = new LinkedList<ProductSellerController>();
        
        view.addBackButtonListener(e -> onBackButtonClick());
        view.addAddProductButtonListener(e -> onAddProductButtonClick());
        
        updateProductViews();
    }
    
    private void onBackButtonClick() {
    	// back to MainScreenSeller
    	
    	MainScreenSellerView view = new MainScreenSellerView();
    	MainScreenSellerModel model = new MainScreenSellerModel(this.model.getSeller());
    	LogoutWrapperController.Instance.changeMVC(model, view, new MainScreenSellerController(view, model));
    }
    
    private void onAddProductButtonClick() {
    	Product product = new Product();
    	
    	model.getSeller().addProduct(product);
    	
    	updateProductViews();
    }
    
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
