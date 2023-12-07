// SellerInventoryScreen.java
// Ethan Curtis

package frontend.SellerInventoryScreen;

import common.Seller;

/**
 * Represents the model component for the seller's inventory screen.
 * Manages the data related to the seller's inventory.
 */
public class SellerInventoryScreenModel {
	private Seller seller;
	
	/**
     * Constructs a SellerInventoryScreenModel object.
     * Initializes the model with the associated seller.
     *
     * @param seller The seller whose inventory is being managed.
     */
	public SellerInventoryScreenModel(Seller seller) {
		this.seller = seller;
	}
	
	/**
     * Retrieves the seller associated with the inventory model.
     *
     * @return The seller object managed by this model.
     */
	public Seller getSeller() {
		return seller;
	}
}
