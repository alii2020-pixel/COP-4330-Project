// FinancialReportsScreenModel.java
// Ethan Curtis

package frontend.FinancialReportsScreen;

import common.Seller;

public class FinancialReportsScreenModel {
	private Seller seller;
	
	public FinancialReportsScreenModel(Seller seller) {
		this.seller = seller;
	}
	
	public Seller getSeller() {
		return seller;
	}
	
	public int getTotalSales() {
		return 50000; // simulate sales from server
	}
	
	public double getTotalProfit() {
		return 123456.78; // simulate profit calculation from server
	}
}
