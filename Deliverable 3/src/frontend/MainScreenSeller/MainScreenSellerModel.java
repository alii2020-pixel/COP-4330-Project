// MainScreeSellerModel.java
// Brandon Christian, Ethan Curtis

package frontend.MainScreenSeller;

import common.*;

/**
 * Represents the model component for the main screen of a seller.
 */
public class MainScreenSellerModel {
	private Seller seller;
	
	/**
     * Constructs a MainScreenSellerModel with the associated Seller.
     *
     * @param seller The seller associated with the main screen.
     */
	public MainScreenSellerModel(Seller seller) {
		this.seller = seller;
	}
	
	/**
     * Retrieves the seller associated with the main screen.
     *
     * @return The seller associated with the main screen.
     */
	public Seller getSeller() {
		return seller;
	}
}
