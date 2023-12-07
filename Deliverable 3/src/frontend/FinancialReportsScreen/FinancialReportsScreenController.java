// FinancialReportsScreenController.java
// Ethan Curtis

package frontend.FinancialReportsScreen;

import frontend.LogoutWrapper.LogoutWrapperController;
import frontend.MainScreenSeller.*;

public class FinancialReportsScreenController {
    private FinancialReportsScreenView view;
    private FinancialReportsScreenModel model;
    
    public FinancialReportsScreenController( FinancialReportsScreenView view, FinancialReportsScreenModel model) {
        this.model = model;
        this.view = view;
        
        view.addBackButtonListener(e -> onBackButtonClick());
        view.setTotalSalesLabelText(Integer.toString(model.getTotalSales()));
        view.setTotalProfitLabelText(String.format("$%.2f", model.getTotalProfit()));
    }

    private void onBackButtonClick() {
    	// back to MainScreenSeller
    	
    	MainScreenSellerView view = new MainScreenSellerView();
    	MainScreenSellerModel model = new MainScreenSellerModel(this.model.getSeller());
    	LogoutWrapperController.Instance.changeMVC(model, view, new MainScreenSellerController(view, model));
    }
}
