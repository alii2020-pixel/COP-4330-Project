// SellerInventoryScreen.java
// Ethan Curtis

package frontend.SellerInventoryScreen;

import common.Seller;

public class SellerInventoryScreenModel {
	private Seller seller;
	
	public SellerInventoryScreenModel(Seller seller) {
		this.seller = seller;
	}
	
	public Seller getSeller() {
		return seller;
	}
}
