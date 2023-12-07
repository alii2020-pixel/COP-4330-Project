// FinancialReportsScreenController.java
// Ethan Curtis

package frontend.FinancialReportsScreen;

import frontend.LogoutWrapper.LogoutWrapperController;
import frontend.MainScreenSeller.*;

/**
 * Controls the functionality of the Financial Reports screen, connecting the view and model.
 */
public class FinancialReportsScreenController {
    private FinancialReportsScreenView view;
    private FinancialReportsScreenModel model;
    
    /**
     * Constructs a FinancialReportsScreenController.
     *
     * @param view  The view associated with the financial reports screen.
     * @param model The model containing data for the financial reports screen.
     */
    public FinancialReportsScreenController( FinancialReportsScreenView view, FinancialReportsScreenModel model) {
        this.model = model;
        this.view = view;
        
        view.addBackButtonListener(e -> onBackButtonClick());
        view.setTotalSalesLabelText(Integer.toString(model.getTotalSales()));
        view.setTotalProfitLabelText(String.format("$%.2f", model.getTotalProfit()));
    }

    /**
     * Handles the action when the back button is clicked.
     * Redirects to the MainScreenSeller upon clicking the back button.
     */
    private void onBackButtonClick() {
    	// back to MainScreenSeller
    	
    	MainScreenSellerView view = new MainScreenSellerView();
    	MainScreenSellerModel model = new MainScreenSellerModel(this.model.getSeller());
    	LogoutWrapperController.Instance.changeMVC(model, view, new MainScreenSellerController(view, model));
    }
}
