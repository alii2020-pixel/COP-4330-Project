//MainScreenSellerController.java
//Brandon Christian

package frontend.MainScreenSeller;
import frontend.FinancialReportsScreen.FinancialReportsScreenController;
import frontend.FinancialReportsScreen.FinancialReportsScreenModel;
import frontend.FinancialReportsScreen.FinancialReportsScreenView;
import frontend.SellerInventoryScreen.SellerInventoryScreenController;
import frontend.SellerInventoryScreen.SellerInventoryScreenModel;
import frontend.SellerInventoryScreen.SellerInventoryScreenView;

public class MainScreenSellerController {
    
	// public static void main(String[] args) {
	public MainScreenSellerController(MainScreenSellerView view, MainScreenSellerModel model) {

		// Instantiate the Seller Inventory MVC components
        SellerInventoryScreenModel sellerInventoryModel = new SellerInventoryScreenModel();
        SellerInventoryScreenView sellerInventoryView = new SellerInventoryScreenView();
        SellerInventoryScreenController sellerInventoryController = new SellerInventoryScreenController(sellerInventoryModel, sellerInventoryView);
        
		// Display the Seller Inventory Screen
        sellerInventoryController.showSellerInventoryScreen();
        
		// Instantiate the Financial Reports MVC components
        FinancialReportsScreenModel financialReportsModel = new FinancialReportsScreenModel();
        FinancialReportsScreenView financialReportsView = new FinancialReportsScreenView();
        FinancialReportsScreenController financialReportsController = new FinancialReportsScreenController(financialReportsModel, financialReportsView);
        
		// Display the Financial Reports Screen
        financialReportsController.showFinancialReportsScreen();
    }
}