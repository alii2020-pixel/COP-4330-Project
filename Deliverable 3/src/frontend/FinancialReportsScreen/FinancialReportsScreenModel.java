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
	
}
